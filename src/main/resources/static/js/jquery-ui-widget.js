/*!
 * jQuery UI Widget 1.8.1
 *
 * Copyright (c) 2010 AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * http://docs.jquery.com/UI/Widget
 */
(function( $ ) {

    var _remove = $.fn.remove;

    $.fn.remove = function( selector, keepData ) {
        return this.each(function() {
            if ( !keepData ) {
                if ( !selector || $.filter( selector, [ this ] ).length ) {
                    $( "*", this ).add( this ).each(function() {
                        $( this ).triggerHandler( "remove" );
                    });
                }
            }
            //dom元素在被删除前，触发一下remove事件，jquery框架本身没有对元素删除绑定事件
            return _remove.call( $(this), selector, keepData );
        });
    };

    $.widget = function( name, base, prototype ) {
        var namespace = name.split( "." )[ 0 ],
            fullName;
        name = name.split( "." )[ 1 ];
        fullName = namespace + "-" + name;
        //比如ui.tab,上面的name='tab';fullName='ui-tab';

        if ( !prototype ) {
            prototype = base;
            base = $.Widget;
        }
        //如果没有prototype,那么prototype就是base参数,实际base默认为$.Widget

        // create selector for plugin
        $.expr[ ":" ][ fullName ] = function( elem ) {
            return !!$.data( elem, name );
        };

        $[ namespace ] = $[ namespace ] || {};//是否有命名空间
        $[ namespace ][ name ] = function( options, element ) {//根据上面的例子，即初始化了$.ui.tab=func
            // allow instantiation without initializing for simple inheritance
            if ( arguments.length ) {
                this._createWidget( options, element );
            }
        };

        var basePrototype = new base();//初始化，一般都是调用了new $.Widget()
        // we need to make the options hash a property directly on the new instance
        // otherwise we'll modify the options hash on the prototype that we're
        // inheriting from
//    $.each( basePrototype, function( key, val ) {
//        if ( $.isPlainObject(val) ) {
//            basePrototype[ key ] = $.extend( {}, val );
//        }
//    });
        basePrototype.options = $.extend( {}, basePrototype.options );//初始化options值，注意不需要深度拷贝
        $[ namespace ][ name ].prototype = $.extend( true, basePrototype, {
            namespace: namespace,
            widgetName: name,
            widgetEventPrefix: $[ namespace ][ name ].prototype.widgetEventPrefix || name,
            widgetBaseClass: fullName
        }, prototype );
        //为新的ui模块创建原型，使用深度拷贝，在basePrototype上扩展一些模块基本信息，在扩展prototype,比如ui.tabs.js中就是tab的拥有各种方法的大对象

        $.widget.bridge( name, $[ namespace ][ name ] );//将此方法挂在jQuery对象上
    };

    $.widget.bridge = function( name, object ) {
        $.fn[ name ] = function( options ) {
            var isMethodCall = typeof options === "string",
                args = Array.prototype.slice.call( arguments, 1 ),
                returnValue = this;
            //如果第一个参数是string类型，就认为是调用模块方法
            //剩下的参数作为方法的参数，后面会用到

            // allow multiple hashes to be passed on init
            options = !isMethodCall && args.length ?
                $.extend.apply( null, [ true, options ].concat(args) ) :
                options;
            //可以简单认为是$.extend(true,options,args[0],...),args可以是一个参数或是数组

            // prevent calls to internal methods
            if ( isMethodCall && options.substring( 0, 1 ) === "_" ) {
                return returnValue;
            }
            //开头带下划线的方法都是私有方法，不让调用

            if ( isMethodCall ) {//如果是调用函数
                this.each(function() {
                    var instance = $.data( this, name ),//得到实例，实例作为一个数据和元素关联上
                        methodValue = instance && $.isFunction( instance[options] ) ?
                            instance[ options ].apply( instance, args ) ://如果实例和方法均存在，调用方法，把args作为参数传进去
                            instance;//否则返回undefined
                    if ( methodValue !== instance && methodValue !== undefined ) {//如果methodValue不是jquery对象也不是undefined
                        returnValue = methodValue;
                        return false;//跳出each，一般获取options的值会走这个分支
                    }
                });
            } else {//不是函数调用的话
                this.each(function() {
                    var instance = $.data( this, name );
                    if ( instance ) {//实例存在
                        if ( options ) {//有参数
                            instance.option( options );//调用option函数，一般是设置状态之类的操作
                        }
                        instance._init();//再次调用此函数，根据options调整
                    } else {
                        $.data( this, name, new object( options, this ) );
                        //没有实例的话，给元素绑定一个实例。注意这里的this是dom，object是模块类
                    }
                });
            }

            return returnValue;//返回，有可能是jquery对象，有可能是其他值
        };
    };

    $.Widget = function( options, element ) {//所有模块的基类
        // allow instantiation without initializing for simple inheritance
        if ( arguments.length ) {//如果有参数，调用初始化函数
            this._createWidget( options, element );
        }
    };

    $.Widget.prototype = {
        widgetName: "widget",
        widgetEventPrefix: "",
        options: {
            disabled: false
        },//上面的属性会在创建模块时被覆盖
        _createWidget: function( options, element ) {
            // $.widget.bridge stores the plugin instance, but we do it anyway
            // so that it's stored even before the _create function runs
            this.element = $( element ).data( this.widgetName, this );//缓存实例，保存jquery对象
            this.options = $.extend( true, {},
                this.options,
                $.metadata && $.metadata.get( element )[ this.widgetName ],
                options );//参数处理

            var self = this;
            this.element.bind( "remove." + this.widgetName, function() {
                self.destroy();
            });//注册销毁事件

            this._create();//创建
            this._init();//初始化
        },
        _create: function() {},
        _init: function() {},

        destroy: function() {//销毁模块：去除绑定事件、去除数据、去除样式、属性
            this.element
                .unbind( "." + this.widgetName )
                .removeData( this.widgetName );
            this.widget()
                .unbind( "." + this.widgetName )
                .removeAttr( "aria-disabled" )
                .removeClass(
                    this.widgetBaseClass + "-disabled " +
                    "ui-state-disabled" );
        },

        widget: function() {//返回jquery对象
            return this.element;
        },

        option: function( key, value ) {//设置选项函数
            var options = key,
                self = this;

            if ( arguments.length === 0 ) {
                // don't return a reference to the internal hash
                return $.extend( {}, self.options );//返回一个新的对象，不是内部数据的引用
            }

            if  (typeof key === "string" ) {
                if ( value === undefined ) {
                    return this.options[ key ];//取值
                }
                options = {};
                options[ key ] = value;//设置值
            }

            $.each( options, function( key, value ) {
                self._setOption( key, value );//调用内部的_setOption
            });

            return self;
        },
        _setOption: function( key, value ) {
            this.options[ key ] = value;

            if ( key === "disabled" ) {//增加或是去除className
                this.widget()
                    [ value ? "addClass" : "removeClass"](
                    this.widgetBaseClass + "-disabled" + " " +
                    "ui-state-disabled" )
                    .attr( "aria-disabled", value );
            }

            return this;
        },

        enable: function() {
            return this._setOption( "disabled", false );
        },
        disable: function() {
            return this._setOption( "disabled", true );
        },

        _trigger: function( type, event, data ) {
            var callback = this.options[ type ];

            event = $.Event( event );
            event.type = ( type === this.widgetEventPrefix ?
                type :
                this.widgetEventPrefix + type ).toLowerCase();
            data = data || {};

            // copy original event properties over to the new event
            // this would happen if we could call $.event.fix instead of $.Event
            // but we don't have a way to force an event to be fixed multiple times
            if ( event.originalEvent ) {//把原始的event属性重新赋到event变量上
                for ( var i = $.event.props.length, prop; i; ) {
                    prop = $.event.props[ --i ];
                    event[ prop ] = event.originalEvent[ prop ];
                }
            }

            this.element.trigger( event, data );

            return !( $.isFunction(callback) &&
                callback.call( this.element[0], event, data ) === false ||
                event.isDefaultPrevented() );
        }
    };

})( jQuery );
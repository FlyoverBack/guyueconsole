/**
数据字典公共查询方法，传入类型值，返回对应的标数信息（实现方式是从内存中获取）
**/
function initDictByType(type) {
	var result = new Array();
	$.ajax({
		url : '/common/dict/listfrominit/'+type,
		async:false,
		success : function(data) {
			//加载数据
            result = data;
		}
	});
	return result;
}

/**
数据字典公共转换方法，传入类型值，返回对应的标数信息
 //加载各数据字典
 id:数据字典中的类型；value：页面中的name；type页面标签的类型(类型主要为select,radio,checkbox,selectpicker)
 var datalist = [
 {id:"color",value:"type",type:"select"},
 {id:"color",value:"status",type:"select"},
 {id:"sex",value:"sex",type:"radio"},
 ]
 returnInitDict(datalist);
**/
function returnInitDict(datalist){
	for(var j=0;j<datalist.length; j++){
	    //加载对应数据字典数据
        var data = initDictByType(datalist[j].id);
        var param = datalist[j].value;
        //加载数据
        var html = "";
        if(datalist[j].type == "select"){
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }
            $("#"+param).append(html);
            $("#"+param).chosen({
                maxHeight : 200
            });
        }else if(datalist[j].type == "radio"){
            for (var i = 0; i < data.length; i++) {
                html +='<input type="radio" name="'+param+'" id="'+param+i+'" value="'+data[i].id+'">'+data[i].name;
            }
            $("#"+param).append(html);
        }else if(datalist[j].type == "checkbox"){
            for (var i = 0; i < data.length; i++) {
                html += '<input type="checkbox" id="' + param + i + '" value="' + data[i].id + '">' + data[i].name;
            }
            $("#"+param).append(html);
        }else if(datalist[j].type == "selectpicker"){
            document.getElementById(param).setAttribute("class","selectpicker");
            document.getElementById(param).setAttribute("multiple","multiple");
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }
            $("#"+param).append(html);
            $("#"+param).chosen({
                maxHeight : 200
            });
        }else{
            console.info(param+"必须制定一个type")
        }
	}
}
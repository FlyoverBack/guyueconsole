var prefix = "/club/clubInfo"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        queryName:$('#queryName').val(),
                        //careteStartTime:$('#careteStartTime').val(),
                        // careteEndTime:$('#careteEndTime').val(),
                        // locationId:$('#locationId').val()
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        visible: false,
                        field: 'clubId',
                        title: 'id'
                    },
                    {
                        field: 'clubName',
                        title: '场地名称',
                        align: 'center'
                    },
                    {
                        field: 'coachName',
                        title: '负责人姓名',
                        align: 'center'
                    },
                    {
                        field: 'tel',
                        title: '手机号',
                        align: 'center'
                    },
                    {
                        field: 'nickName',
                        title: '微信昵称',
                        align: 'center'
                    },
                    {
                        field: 'address',
                        title: '场地区域',
                        align: 'center'
                    },
                    {
                        field: 'clubStatus',
                        title: '状态',
                        formatter: function (value, row, index) {
                            console.info(value + row + index);
                            if (value == 0) {
                                return '停止运营';
                            }
                            if (value == 1) {
                                return '已注册';
                            }
                            if (value == 2) {
                                return '运营中';
                            }
                            if (value == 3) {
                                return '修整中';
                            }
                            return value;
                        },
                        align: 'center'
                    },
                    {
                        field: 'clubTcType',
                        title: '提成类型',
                        formatter: function (value, row, index) {
                            console.info(value + row + index);
                            if (value == 0) {
                                return '百分比';
                            }
                            if (value == 1) {
                                return '固定值';
                            }

                            return value;
                        },
                        align: 'center'
                    },
                    {
                        field: 'clubTc',
                        title: '场地提成',
                        align: 'center'
                    },
                    {
                        field: 'registrationTime',
                        title: '注册时间',
                        align: 'center'
                    },
                    {
                        title: '操作',
                        field: '',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'"   href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.clubId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            return e ;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

layui.use('upload', function () {
    var upload = layui.upload;
    //执行实例
    var uploadInst = upload.render({
        elem: '#uploadBtn' //绑定元素
        , url: '/upload/setFileUpload' //上传接口
        , multiple: true
        , before: function (obj) {
            //可设置回显
            console.log(obj)
        }
        , done: function (res) {
            console.log(res);
            //上传完毕回调
            if (res.code != 1000) {
                return layer.msg('上传失败');
            } else {
                return layer.msg('上传成功');
            }
        }
        , error: function () {
            //请求异常回调
        }
    });
});
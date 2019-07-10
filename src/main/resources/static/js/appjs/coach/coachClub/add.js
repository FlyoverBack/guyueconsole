$().ready(function() {
	//自定义验证手机号
	validateinit();
	//验证各字段方法
	validateRule();
	//加载各数据字典
    var datalist = [
        {id:"color",value:"type",type:"select"},
        {id:"color",value:"status",type:"select"},
        {id:"sex",value:"sex",type:"radio"},
    ]
    returnInitDict(datalist);
	//日期触发方法
    laydate({
        elem : '#registrationTime'
    });
    initCoachId();
});
function validateinit(){
	//全部验证方法可以查看validateExtend.js
    $.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写手机号码");
}

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var params = $('#signupForm').serialize();// 你的formid
    console.info(params);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/coach/coach/save",
		data : params,
		async : false,
		error : function(request) {
			parent.layer.alert("新增用户操作失败");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
//初始化回显最新教练ID
function initCoachId() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/coach/coachClub/initCoachId",
        async : false,
        error : function(request) {
            parent.layer.alert("获取最新教练ID失败！");
        },
        success : function(data) {
            console.info(data);
            $("#coachId").val(data);
        }
    });

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            coachName : {
				required : true
			},
            tel:{
            	required:true,
                isMobile:true
			}
		},
		messages : {
            coachName : {
				required : icon + "请输入姓名"
			},
            tel : {
                required : icon + "请输入手机号",
				isMobile: icon + "请输入正确的手机号"
            }
		}
	})
}

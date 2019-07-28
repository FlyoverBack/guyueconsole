$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/club/course/save",
		data :/* $('#signupForm').serialize(),// 你的formid*/
			{
                clubId:$("#clubName").val(),
                name:$("#name option:selected").text(),
                type:$("#name option:selected").val(),
                price:$("#price").val(),
                status:$("#status").val(),
                discount:$("#discount").val(),
                coachId:$("#coachId").val(),
                tryFlag:$("#tryFlag").val()

			},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
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
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}


function rowcolSel() {
    var row=$("#clubName").val();
    $.ajax({
        cache : true,
        type : "GET",
        url : "/club/course/queryCoach",
        data : {
            'clubId' : row
        },
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.courseList.length > 0) {
                for(var i in data.courseList){
                    $("#name").append("<option value="+data.courseList[i].key+">"+data.courseList[i].value+"</option> ");
                }
            } else {
                parent.layer.alert("没有找到可以添加的课程")
            }

        }
    });

}
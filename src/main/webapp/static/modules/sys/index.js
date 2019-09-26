$(document).ready(function(){
	selectCount();
	});


//获取当前项目名称路径（http://localhost:8080/ssm/）
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}


//查询会员总数
function selectCount(){
	$.ajax({
		type:"POST",
		url:getRootPath()+"selectCount",
		dataType:"json",
		data:{
			
		},
		success:function(result,testStatus){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
		
		}
	});
}


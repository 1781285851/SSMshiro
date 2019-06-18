//获取当前项目名称路径（http://localhost:8080/ssm/）
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

$(document).ready(function () {
	alert("进来ready方法");
	selectCount();
});

function selectCount(){
	alert("aaaaaaaaaaa");
	this.location.href=getRootPath()+"selectCount"
}
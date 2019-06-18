//获取当前项目名称路径（http://localhost:8080/ssm/）
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}


//重置

function resetCondition(){
	$("#hykh").val("");
	$("#yhm").val("");
	$("#sfzhm").val("");
	$("#lxdh").val("");
	$("#qq").val("");
	$("#wx").val("");
	$("#czry").val("");
	$("#xb").val("2");
	$("#wz").val("0");
	
}


//注册
function registerMember(){
	var ClubCard=document.getElementById("hykh").value;
	var Name=document.getElementById("yhm").value;
	var IdentityCard=document.getElementById("sfzhm").value;
	var Phone=document.getElementById("lxdh").value;
	var qq=document.getElementById("qq").value;
	var Wechat=document.getElementById("wx").value;
	var Administrator=document.getElementById("czry").value;
//	var Gender=document.getElementById('xb').selectedIndex;
	var GenderString=document.getElementById('xb')
	var index=GenderString.selectedIndex;
	var Gender=GenderString.options[index].text;
	var DanceTypesId=document.getElementById('wz').selectedIndex; //这里取到的是<option value="1">Breaking</option>的位置，而不是value值，从0开始
	alert(ClubCard+":"+Name+":"+IdentityCard+":"+Phone+":"+qq+":"+Wechat+":"+Administrator+":"+Gender+":"+DanceTypesId);
	if(ClubCard!=null && Name!=null && IdentityCard.length==18 && Phone.length==11 && qq!=null && Wechat!=null && Administrator!=null && Gender!="2" && DanceTypesId!="0"){
		$.ajax({
			type:"POST",
			url:getRootPath()+"registerMember",
			dataType:"json",
			data:{
				ClubCard:ClubCard,
				Name:Name,
				IdentityCard:IdentityCard,
				Phone:Phone,
				qq:qq,
				Wechat:Wechat,
				Administrator:Administrator,
				Gender:Gender,
				DanceTypesId:DanceTypesId
			},
			success:function(result,testStatus){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
				if(result == true){
					alert("注册成功");
					resetCondition();
				}else if(result == false){
					alert("该身份证号码已经存在，注册失败！！");
				}
			}
		});
		
	}else {
		alert("用户信息填写错误，或用户信息不完整");
	}	
}


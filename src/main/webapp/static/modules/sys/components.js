//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
$(document).ready(function(){
	//获取数据
	selectMenberAll(1)
	//获取shiro的值
	shiro()
	});

//获取当前项目名称路径（http://localhost:8080/ssm/）
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}


var remarkRole;
//获取shiro的值
function shiro(){
	$.ajax({
		type:"POST",
		url:getRootPath()+"ShiroRole",
		data:{},
		success:function(result){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
			remarkRole = result;
 		}
	});
}


//重置文本框
function Condition(){
	$("#hykh").val("");
	$("#yhm").val("");
	$("#czry").val("");
	$("#sfzhm").val("");
	$("#lxdh").val("");
	$("#qq").val("");
	$("#wx").val("");
	$("#xb").val("2");
	$("#wz").val("0");
	$("#startdate").val("");
	$("#enddate").val("");
	
}

//把时间格式转换为日期格式
function timestampToTime(timestamp) {
   var date = new Date(timestamp);//时间戳为10位需timestamp*1000，时间戳为13位的话不需乘1000
   var Y = date.getFullYear() + '-';
   var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
   var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
   var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
   var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
   var s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());
   return Y+M+D+h+m+s;
}


//会员的条件查询
function selectMenberAll(PN){
	var Name = document.getElementById("yhm").value;
	var ClubCard = document.getElementById("hykh").value;
	var Administrator = document.getElementById("czry").value;
	var Phone = document.getElementById("lxdh").value;
	var IdentityCard = document.getElementById("sfzhm").value;
	
	var GenderString = document.getElementById('xb')//获取性别
	var index = GenderString.selectedIndex;//获取性别的下标位置 从0开始
	var Gender = GenderString.options[index].text;//根据下标获取文本
	
	var DanceTypesId=document.getElementById('wz').value;//这里取到的是<option value="1">Breaking</option>的位置，而不是value值，从0开始
	var Startdate = document.getElementById("startdate").value
	var Enddate = document.getElementById("enddate").value
	
	if(Gender == "请选择性别...."){Gender=""}
	if(DanceTypesId == "0"){DanceTypesId=""}
	
	$.ajax({
			type:"POST",
			url:getRootPath()+"selectMenberBy",
			data:{
				Name:Name,
				ClubCard:ClubCard,
				Administrator:Administrator,
				Phone:Phone,
				IdentityCard:IdentityCard,
				Gender:Gender,
				DanceTypesId:DanceTypesId,
				Startdate:Startdate,
				Enddate:Enddate,
				PN:PN
			},
			success:function(result){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
				alert(result)
				console.log(result);
				//1、解析并显示员工数据
				menber(result)
				page(result)
				build_page_nav(result)
			}
		});
}


function menber(result){
	//清空table表格数据
	$("#emps_table tbody").empty();
	var emps = result.extend.pageInfo.list;
	$.each(emps,function(index,item){
		var index = $("<td></td>").append(index+1);
		var name = $("<td></td>").append(item.name);
		var gender = $("<td></td>").append(item.gender);
		var clubCard = $("<td></td>").append(item.clubCard);
		var danceName = $("<td></td>").append(item.danceName);
		var identityCard = $("<td></td>").append(item.identityCard);
		var phone = $("<td></td>").append(item.phone);
		var creationTime = $("<td></td>").append(timestampToTime(item.creationTime));
		var administrator = $("<td></td>").append(item.administrator);
		var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("照片").click(function photo(){
							getPhoto(item.identityCard)//调用查询方法，传入身份证号码。
							$("#empAddModal").modal({
								backdrop:"static"
							});
						});
		//为编辑按钮添加一个自定义的属性，来表示当前员工id
		editBtn.attr("edit-id",item.identityCard);
		
		var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除 补卡 转卡").click(function deleteMem(){
							$.ajax({
								type:"POST",
								url:getRootPath()+"deleteMem",
								data:{
									IdentityCard:item.identityCard
								},
								success:function(result){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
									alert(result);
									selectMenberAll(1)
								}
							});
						})
		
		//获取src/main/java/com/dancer/realm/ShiroController.java返回的值
		//为删除按钮添加一个自定义的属性来表示当前删除的员工id
		delBtn.attr("del-id",item.identityCard);
		var btnTd = $("<td></td>").append(editBtn).append(" ");
		if(remarkRole == '1' || remarkRole==1){
			btnTd.append(delBtn)
			}
		//var delBtn = 
		//append方法执行完成以后还是返回原来的元素
		$("<tr></tr>").append(index)
			.append(name)
			.append(gender)
			.append(clubCard)
			.append(danceName)
			.append(identityCard)
			.append(phone)
			.append(creationTime)
			.append(administrator)
			.append(btnTd)
			.appendTo("#emps_table tbody");
	});
	
}

//解析显示分页信息
function page(result){
	$("#page_info_area").empty();
	$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页, 总共"+
			result.extend.pageInfo.pages+"页, 总共"+
			result.extend.pageInfo.total+"条记录");
	totalRecord = result.extend.pageInfo.total;
	currentPage = result.extend.pageInfo.pageNum;
}



//解析显示分页条，点击分页要能去下一页....
function build_page_nav(result){
	//page_nav_area
	$("#page_nav_area").empty();
	var ul = $("<ul></ul>").addClass("pagination");
	
	//构建元素
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
	if(result.extend.pageInfo.hasPreviousPage == false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			selectMenberAll(1);
		});
		prePageLi.click(function(){
			selectMenberAll(result.extend.pageInfo.pageNum -1);
		});
	}
	
	
	
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	if(result.extend.pageInfo.hasNextPage == false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			selectMenberAll(result.extend.pageInfo.pageNum +1);
		});
		lastPageLi.click(function(){
			selectMenberAll(result.extend.pageInfo.pages);
		});
	}
	
	
	
	//添加首页和前一页 的提示
	ul.append(firstPageLi).append(prePageLi);
	//1,2，3遍历给ul中添加页码提示
	$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
		
		var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
		if(result.extend.pageInfo.pageNum == item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			selectMenberAll(item);
		});
		ul.append(numLi);
	});
	//添加下一页和末页 的提示
	ul.append(nextPageLi).append(lastPageLi);
	
	//把ul加入到nav
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#page_nav_area");
}

//根据身份证查找信息
function getPhoto(IdentityCard){
	var Name = document.getElementById("yhm").value;
	var ClubCard = document.getElementById("hykh").value;
	var Administrator = document.getElementById("czry").value;
	var Phone = document.getElementById("lxdh").value;
	
	var GenderString = document.getElementById('xb')//获取性别
	var index = GenderString.selectedIndex;//获取性别的下标位置 从0开始
	var Gender = GenderString.options[index].text;//根据下标获取文本
	
	var DanceTypesId=document.getElementById('wz').value;//这里取到的是<option value="1">Breaking</option>的位置，而不是value值，从0开始
	var Startdate = document.getElementById("startdate").value
	var Enddate = document.getElementById("enddate").value
	
	if(Gender == "请选择性别...."){Gender=""}
	if(DanceTypesId == "0"){DanceTypesId=""}
	
	$.ajax({
		url:getRootPath()+"selectMenberBy",
		type:"POST",
		data:{
			IdentityCard:IdentityCard,
			Name:Name,
			ClubCard:ClubCard,
			Administrator:Administrator,
			Phone:Phone,
			IdentityCard:IdentityCard,
			Gender:Gender,
			DanceTypesId:DanceTypesId,
			Startdate:Startdate,
			Enddate:Enddate
			
		},
		success:function(result){
			//{"code":100,"msg":"处理成功！",
				//"extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
			//console.log(result);
			//显示部门信息在下拉列表中
			//$("#empAddModal select").append("")
			//$.each(result.extend.depts,function(){
			//	var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
			//	optionEle.appendTo(ele);
			//});
			
			
			$("#identityCard").empty();
			
			
			/**
			 * <div class="col-sm-12">
			<label for="exampleInputEmail1">身份证号码：</label>
				<input type="text" class="form-control" id="sfzhm" placeholder="请输入身份证号码"  placeholder=item.identityCard>
				<p id="message" style="font-size:20px;color:red"></p>
			</div>
			 */
			console.log(result);
			
				var s = $("#identityCard")
				var sfzhm1 = $("<label></label>").attr("for","exampleInputEmail1").append("身份证号码:")
				var sfzhm2 = $("<input>").attr("type","text").addClass("form-control").attr("id","shengfen").attr("name","shengfen").attr("value",result.extend.pageInfo.list[0].identityCard).attr("disabled","disabled");
					sfzhm1.appendTo(s);
					sfzhm2.appendTo(s);
					
			
			
		}
	});
	
}
























package com.dancer.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dancer.crud.entity.MemberRegistration;
import com.dancer.crud.entity.MemberRegistrationVo;
import com.dancer.crud.entity.MemberVo;
import com.dancer.crud.service.MemberRegistrationService;
import com.dancer.realm.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/")
public class MemberRegistrationController {
	
	@Autowired
	MemberRegistrationService memberRegistrationService;
	
	/**
	 * 查询该身份证是否注册并ajax请求返回数据
	 * @param IdentityCard
	 * @param model
	 * @return
	 */
	@RequestMapping(value="ajaxIdentityCard", method = RequestMethod.GET, produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String selectMenberByIdentityCardController(String sfzhmname) {
		MemberRegistration member = memberRegistrationService.selectMenberByIdentityCardService(sfzhmname);
		if(null==member) {
			System.out.println("可以注册");
			return "该用户不存在 可以注册";
		}else {
			System.out.println("bu可以注册");
			return "该用户存在 不可以注册";
		}
	}
	
	
	/**
	 * 添加会员
	 * @param request
	 * @param ClubCard
	 * @param Name
	 * @param IdentityCard
	 * @param Phone
	 * @param qq
	 * @param Wechat
	 * @param Administrator
	 * @param Gender
	 * @param DanceTypesId
	 * @return
	 */
	@RequestMapping(value="registerMember", method = RequestMethod.POST)
	@ResponseBody
	public String insertMenberController(HttpServletRequest request,@RequestParam("ClubCard") String ClubCard,@RequestParam("Name") String Name,
										@RequestParam("IdentityCard") String IdentityCard,@RequestParam("Phone") String Phone,@RequestParam("qq") String qq,
										@RequestParam("Wechat") String Wechat,@RequestParam("Administrator") String Administrator,
										@RequestParam("Gender") String Gender,@RequestParam("DanceTypesId") Integer DanceTypesId
										){
		String aString = memberRegistrationService.insertMenberService( ClubCard, Name, IdentityCard, Phone, qq, Wechat, Administrator, Gender, DanceTypesId);
		if ("success".equals(aString)) {
			return "true";
		}else {
			return "false";
		}
		
	}
	
	
	/**
	 * 保存图片
	 * @param file
	 * @param product
	 * @param map
	 * @return
	 */
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String insertPhotoController(MultipartFile file, @RequestParam("shengfen") String IdentityCard, MemberRegistration memberRegistration) {
		try {
			return memberRegistrationService.insertPhotoService(file, IdentityCard, memberRegistration);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	/**
	 * 查询会员人数
	 * @return
	 */
	@RequestMapping(value="selectCount", method = RequestMethod.POST)
	public String selectCountController(HttpSession session) {
		//总人数
		int sum = memberRegistrationService.selectCountService();
		//Breaking人数
		int sumBreaking = memberRegistrationService.selectCountByBreakingService();
		//Poppin人数
		int sumPoppin = memberRegistrationService.selectCountByPoppinService();
		//Locking人数
		int sumLocking = memberRegistrationService.selectCountByLockingService();
		//Hiphop人数
		int sumHiphop = memberRegistrationService.selectCountByHiphopService();
		//Jazz人数
		int sumJazz = memberRegistrationService.selectCountByJazzService();
		//Shuffle人数
		int sumShuffle = memberRegistrationService.selectCountByShuffleService();
		//Urban人数
		int sumUrban = memberRegistrationService.selectCountByUrbanService();
		//Wacking人数
		int sumWacking = memberRegistrationService.selectCountByWackingService();
		session.setAttribute("sum",sum);
		session.setAttribute("sumBreaking",sumBreaking);
		session.setAttribute("sumPoppin",sumPoppin);
		session.setAttribute("sumLocking",sumLocking);
		session.setAttribute("sumHiphop",sumHiphop);
		session.setAttribute("sumJazz",sumJazz);
		session.setAttribute("sumShuffle",sumShuffle);
		session.setAttribute("sumUrban",sumUrban);
		session.setAttribute("sumWacking",sumWacking);
		return "modules/sys/index";
	}
	
	
	
	/**
	 * 根据条件查询会员数据
	 * @param memberRegistrationVo
	 * @return
	 */
	@RequestMapping(value="selectMenberBy", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectMenberController(@RequestParam("Name") String Name,
			@RequestParam("ClubCard") String ClubCard,@RequestParam("Administrator") String Administrator,
			@RequestParam("Phone") String Phone,@RequestParam("IdentityCard") String IdentityCard,
			@RequestParam("Gender") String Gender,@RequestParam("DanceTypesId") String DanceTypesId,
			@RequestParam("Startdate") String Startdate,@RequestParam("Enddate") String Enddate,
			@RequestParam(value = "PN",defaultValue = "1") Integer PN) {
		if("" == ClubCard){ClubCard = null;System.out.println("ClubCard");}
		if("" == Name){Name = null;System.out.println("Name");}
		if("" == Administrator){Administrator = null;System.out.println("Administrator");}
		if("" == Phone){Phone = null;System.out.println("Phone");}
		if("" == IdentityCard){IdentityCard = null;System.out.println("IdentityCard");}
		if("" == Gender){Gender = null;System.out.println("Gender");}
		if("" == DanceTypesId){DanceTypesId = null;System.out.println("DanceTypesId");}
		if("" == Startdate){Startdate = null;System.out.println("Startdate");}
		if("" == Enddate){Enddate = null;System.out.println("Enddate");}
		System.out.println("ClubCard="+ClubCard);
		System.out.println("Name="+Name);
		System.out.println("Administrator="+Administrator);
		System.out.println("Phone="+Phone);
		System.out.println("IdentityCard="+IdentityCard);
		System.out.println("IdentityCard="+Gender);
		System.out.println("DanceTypesId="+DanceTypesId);
		System.out.println("Startdate="+Startdate);
		System.out.println("Enddate="+Enddate);
		//1.先引入PageHelper分页插件，在查询之前传入页码和每页的大小
		PageHelper.startPage(PN,5);
		//2.这是查询所有数据
		List<MemberRegistrationVo> mem = memberRegistrationService.selectMenberService(ClubCard,Name,
				Administrator,Phone,IdentityCard,Gender,DanceTypesId,Startdate,Enddate);
		//3.使用PageInfo包装查询好的结果，将查询到的所有数据交给PageInfo
		//封装了详细的分页信息，包括我们查询出来的所有数据，传入每页显示的页数（两个参数为查询到的所有数据和页面可以显示的页数）
		PageInfo pageInfo = new PageInfo(mem,5);
		System.out.println("共"+mem.size()+"条数据");
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	/**
	 * 删除用户（状态改为1）
	 * @param IdentityCard
	 * @return
	 */
	@RequestMapping(value="deleteMem", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	@RequiresRoles("T1")
	public String deleteMemController(@RequestParam("IdentityCard") String IdentityCard) {
		System.out.println("IdentityCard:"+IdentityCard);
		int num = memberRegistrationService.deleteMemService(IdentityCard);
		System.out.println("ok");
		System.out.println(num);
		if("0".equals(num)) {
			return "删除失败";
		};
		return "删除成功";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 根据条件查询会员数据
	 * @param memberRegistrationVo
	 * @return
	 */
	//第一种使用ajax的post请求，绑定数据并且发送到页面。可以成功发送数据，但是无法跳转页面，也就无法对页面进行渲染
	/*
	@RequestMapping(value="selectMenberBy111", method = RequestMethod.POST)
	public String selectMenberController(HttpServletRequest request, @RequestParam("Name") String Name,
			@RequestParam("ClubCard") String ClubCard,@RequestParam("Administrator") String Administrator,
			@RequestParam("Phone") String Phone,@RequestParam("IdentityCard") String IdentityCard,
			@RequestParam("Gender") String Gender,@RequestParam("DanceTypesId") String DanceTypesId,
			@RequestParam("Startdate") String Startdate,@RequestParam("Enddate") String Enddate,
			@RequestParam(value = "PN",defaultValue = "1") Integer PN) {
		if("" == ClubCard){ClubCard = null;System.out.println("ClubCard");}
		if("" == Name){Name = null;System.out.println("Name");}
		if("" == Administrator){Administrator = null;System.out.println("Administrator");}
		if("" == Phone){Phone = null;System.out.println("Phone");}
		if("" == IdentityCard){IdentityCard = null;System.out.println("IdentityCard");}
		if("" == Gender){Gender = null;System.out.println("Gender");}
		if("" == DanceTypesId){DanceTypesId = null;System.out.println("DanceTypesId");}
		if("" == Startdate){Startdate = null;System.out.println("Startdate");}
		if("" == Enddate){Enddate = null;System.out.println("Enddate");}
		System.out.println("ClubCard="+ClubCard);
		System.out.println("Name="+Name);
		System.out.println("Administrator="+Administrator);
		System.out.println("Phone="+Phone);
		System.out.println("IdentityCard="+IdentityCard);
		System.out.println("IdentityCard="+Gender);
		System.out.println("DanceTypesId="+DanceTypesId);
		System.out.println("Startdate="+Startdate);
		System.out.println("Enddate="+Enddate);
		//1.先引入PageHelper分页插件，在查询之前传入页码和每页的大小
		PageHelper.startPage(PN,7);
		//2.这是查询所有数据
		List<MemberRegistrationVo> mem = memberRegistrationService.selectMenberService(ClubCard,Name,
				Administrator,Phone,IdentityCard,Gender,DanceTypesId,Startdate,Enddate);
		//3.使用PageInfo包装查询好的结果，将查询到的所有数据交给PageInfo
		//封装了详细的分页信息，包括我们查询出来的所有数据，传入每页显示的页数（两个参数为查询到的所有数据和页面可以显示的页数）
		//PageInfo pageInfo = new PageInfo(mem,5);
		//System.out.println("共"+mem.size()+"条数据");
		//Model绑定数据传到页面
		//Model.addAttribute("pageInfo", pageInfo);
		request.setAttribute("mem", mem);
		return "modules/sys/components";
	}*/
	
	/*
	//这种使用链接请求，可以进行页面跳转和渲染
	@RequestMapping(value="selectMenberBy", method = RequestMethod.GET)
	public String selectMenberController(Model Model, @RequestParam("DanceTypesId") String DanceTypesId,
			
			@RequestParam(value = "PN",defaultValue = "1") Integer PN) {
		//1.先引入PageHelper分页插件，在查询之前传入页码和每页的大小
		PageHelper.startPage(PN,7);
		//2.这是查询所有数据
		List<MemberRegistrationVo> mem = memberRegistrationService.selectMenberService(null,null,
				null,null,null,null,DanceTypesId,null,null);
		//3.使用PageInfo包装查询好的结果，将查询到的所有数据交给PageInfo
		//封装了详细的分页信息，包括我们查询出来的所有数据，传入每页显示的页数（两个参数为查询到的所有数据和页面可以显示的页数）
		PageInfo pageInfo = new PageInfo(mem,5);
		System.out.println("共"+mem.size()+"条数据");
		//Model绑定数据传到页面
		Model.addAttribute("pageInfo", pageInfo);
		return "modules/sys/components";
	}
	*/
	
	
	
	
	
	
	
	
}

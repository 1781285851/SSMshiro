package com.dancer.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dancer.crud.service.MemberRegistrationService;

@Controller
@RequestMapping("/")
public class MemberRegistrationController {
	
	@Autowired
	MemberRegistrationService memberRegistrationService;
	
	/**
	 * 添加会员  先判断改会员是否存在，如果存在返回true，不存在返回false
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
										@RequestParam("Gender") String Gender,@RequestParam("DanceTypesId") Integer DanceTypesId){
		System.out.println("进入会员保存+================================="+Name);
		String aString = memberRegistrationService.insertMenberService( ClubCard, Name, IdentityCard, Phone, qq, Wechat, Administrator, Gender, DanceTypesId);
		if ("success".equals(aString)) {
			return "true";
		}else {
			return "false";
		}
		
	}
	
	
	/**
	 * 查询所有会员总数
	 * @return
	 */
	@RequestMapping(value="selectCount", method = RequestMethod.GET)
	public String selectCountController(Model model) {
		System.out.println("查询会员总数++++++++++++++++++++++++");
		int sum = memberRegistrationService.selectCountService();
		model.addAttribute("sum",sum);
		return "modules/sys/index";
	}
	
	
	/**
	 * 查询Breaking会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountBreaking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountBreakingController() {
		int sumBreaking = memberRegistrationService.selectCountByBreakingService();
		return sumBreaking;
	}
	
	
	/**
	 * 查询Poppin会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountPoppin", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountPoppinController() {
		int sumPoppin = memberRegistrationService.selectCountByPoppinService();
		return sumPoppin;
	}
	
	
	/**
	 * 查询Locking会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountLocking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountLockingController() {
		int sumLocking = memberRegistrationService.selectCountByLockingService();
		return sumLocking;
	}
	
	
	/**
	 * 查询Hiphop会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountHiphop", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountHiphopController() {
		int sumHiphop = memberRegistrationService.selectCountByHiphopService();
		return sumHiphop;
	}
	
	
	/**
	 * 查询Jazz会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountJazz", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountJazzController() {
		int sumJazz = memberRegistrationService.selectCountByJazzService();
		return sumJazz;
	}
	
	
	/**
	 * 查询Shuffle会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountShuffle", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountShuffleController() {
		int sumShuffle = memberRegistrationService.selectCountByShuffleService();
		return sumShuffle;
	}
	
	
	/**
	 * 查询Urban会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountUrban", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountUrbanController() {
		int sumUrban = memberRegistrationService.selectCountByUrbanService();
		return sumUrban;
	}
	
	
	/**
	 * 查询Wacking会员总数
	 * @return
	 */
	@RequestMapping(value="selectCountWacking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountWackingController() {
		int sumWacking = memberRegistrationService.selectCountByWackingService();
		return sumWacking;
	}
	
	
}

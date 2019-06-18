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
	 * ��ӻ�Ա  ���жϸĻ�Ա�Ƿ���ڣ�������ڷ���true�������ڷ���false
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
		System.out.println("�����Ա����+================================="+Name);
		String aString = memberRegistrationService.insertMenberService( ClubCard, Name, IdentityCard, Phone, qq, Wechat, Administrator, Gender, DanceTypesId);
		if ("success".equals(aString)) {
			return "true";
		}else {
			return "false";
		}
		
	}
	
	
	/**
	 * ��ѯ���л�Ա����
	 * @return
	 */
	@RequestMapping(value="selectCount", method = RequestMethod.GET)
	public String selectCountController(Model model) {
		System.out.println("��ѯ��Ա����++++++++++++++++++++++++");
		int sum = memberRegistrationService.selectCountService();
		model.addAttribute("sum",sum);
		return "modules/sys/index";
	}
	
	
	/**
	 * ��ѯBreaking��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountBreaking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountBreakingController() {
		int sumBreaking = memberRegistrationService.selectCountByBreakingService();
		return sumBreaking;
	}
	
	
	/**
	 * ��ѯPoppin��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountPoppin", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountPoppinController() {
		int sumPoppin = memberRegistrationService.selectCountByPoppinService();
		return sumPoppin;
	}
	
	
	/**
	 * ��ѯLocking��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountLocking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountLockingController() {
		int sumLocking = memberRegistrationService.selectCountByLockingService();
		return sumLocking;
	}
	
	
	/**
	 * ��ѯHiphop��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountHiphop", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountHiphopController() {
		int sumHiphop = memberRegistrationService.selectCountByHiphopService();
		return sumHiphop;
	}
	
	
	/**
	 * ��ѯJazz��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountJazz", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountJazzController() {
		int sumJazz = memberRegistrationService.selectCountByJazzService();
		return sumJazz;
	}
	
	
	/**
	 * ��ѯShuffle��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountShuffle", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountShuffleController() {
		int sumShuffle = memberRegistrationService.selectCountByShuffleService();
		return sumShuffle;
	}
	
	
	/**
	 * ��ѯUrban��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountUrban", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountUrbanController() {
		int sumUrban = memberRegistrationService.selectCountByUrbanService();
		return sumUrban;
	}
	
	
	/**
	 * ��ѯWacking��Ա����
	 * @return
	 */
	@RequestMapping(value="selectCountWacking", method = RequestMethod.POST)
	@ResponseBody
	public int selectCountWackingController() {
		int sumWacking = memberRegistrationService.selectCountByWackingService();
		return sumWacking;
	}
	
	
}

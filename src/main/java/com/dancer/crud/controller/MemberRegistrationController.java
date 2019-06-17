package com.dancer.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
}

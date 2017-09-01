package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.AddressDto;
import com.aartek.model.UserLogin;
import com.aartek.validator.RegistrationValidator;
import com.service.RegisterService;


@Controller
public class RegisterController {
	@Autowired
	private RegisterService reg;
	
	@Autowired
	 RegistrationValidator regValid;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String initUserReg(Map<String, Object> map) {
		System.out.println("Register First");
		map.put("UserLogin", new UserLogin());
		return "register";
	}
	
	@RequestMapping(value="/checkRegister", method=RequestMethod.POST)
	public String checkUserReg(@ModelAttribute("UserLogin") UserLogin usr,BindingResult bResult) {		
		regValid.validate(usr, bResult);
		if (bResult.hasErrors()) 
			return "register";
		String result =reg.registerUserService(usr);
		System.out.println(result);
		return "welcome";
	}

}

package com.aartek.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.aartek.model.UserLogin;
import com.service.LoginService;
import com.service.RegisterService;

@Controller
public class LoginWsController {

	@Autowired
	private LoginService loginServ;
	
	@Autowired
	private RegisterService rs;
	@RequestMapping(value="/login1/{mailId}" , method=RequestMethod.GET)
	public @ResponseBody UserLogin initUserLogin(@PathVariable String mailId) {
		return loginServ.getUser(mailId);
	}

	@RequestMapping(value="/login1" , method=RequestMethod.POST)
	public @ResponseBody String initUserLogin(@RequestBody UserLogin user) {
		return rs.registerUserService(user);
	}
}

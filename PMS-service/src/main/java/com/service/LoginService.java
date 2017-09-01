package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.UserLogin;
import com.repo.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	public String checkLoginService(UserLogin usr) {
		String str = loginRepo.checkLoginRepo(usr);
		System.out.println("Inside service");
		return str;
	}
	
	public UserLogin getUser(String mailId) {
		return loginRepo.getUserData(mailId);
	}

	public UserLogin validateUserServ(UserLogin usr) {

		System.out.println("Service\n\t:" + usr.getMailId() + "\t" + usr.getPass());
		loginRepo.validateUserRepo(usr);
		return usr;
	}
	
	/*public boolean checkUser(UserLogin user) {
		if(loginRepo.checkValidUser(user))
			return true;
	}*/
}

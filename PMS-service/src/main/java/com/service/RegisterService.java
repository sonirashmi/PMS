package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.UserLogin;
import com.repo.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepo registerRepo;
	public String registerUserService(UserLogin usr) {	
		String str=registerRepo.registerUserRepo(usr);
			return str;
	}
	//============================================================
	public boolean validateUser(UserLogin usr) {
	
	System.out.println("Service\n\t:"+usr.getMailId()+"\t"+usr.getPass());
	if(registerRepo.isUserAlreayExits(usr))
		return true;
	else 
		return false;
	
}
}

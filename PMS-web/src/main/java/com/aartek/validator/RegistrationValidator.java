package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.UserLogin;
import com.service.RegisterService;

@Component
public class RegistrationValidator implements Validator{

	@Autowired
	RegisterService registerService;
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserLogin.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors err) {
		// Validation for Empty values or spaces 
		UserLogin userLogin=(UserLogin)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "fName", "fName.emptyOrSpace");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "lName", "lName.emptyOrSpace");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "mailId", "mailId.emptyOrSpace");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "pass", "password.emptyOrSpace");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "mob", "mob.emptyOrSpace");
		
		//Business rule related Validation 
		if(userLogin.getfName()!=null && userLogin.getfName().trim().length()>0) {
			if(userLogin.getfName().trim().length()>20)
				err.rejectValue("fName", "fName.length.exceeds");
		}
		
		if(userLogin.getlName()!=null && userLogin.getlName().trim().length()>0) {
			if(userLogin.getlName().trim().length()>10)
				err.rejectValue("lName", "lName.length.exceeds");
		}
		
		if(userLogin.getMob()!=null && userLogin.getMob().trim().length()>0) {
			if(userLogin.getMob().trim().length()!=10)
				err.rejectValue("mob", "mob.length.exceeds");
		}
		
		if(userLogin.getMailId()!=null  && userLogin.getMailId().trim().length()>0) {
			if(userLogin.getMailId().trim().length()>=20 ) {
				err.rejectValue("mailId", "mailId.length.exceeds");
			}else if(!userLogin.getMailId().contains("@")) {
				err.rejectValue("mailId", "mailId.format.first.rule");
			}
		}
		
		if(userLogin.getPass()!=null  && userLogin.getPass().trim().length()>0) {
			if(userLogin.getPass().trim().length()>=10 ) {
				err.rejectValue("pass", "pass.length.exceeds");
			}
		}
		//DB validations
		if(!registerService.validateUser(userLogin)) {
			err.rejectValue("mailId", "mailId.alreadyRegistered");
		}
		
	}
}

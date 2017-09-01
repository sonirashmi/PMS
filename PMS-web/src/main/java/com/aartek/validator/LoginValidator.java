package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.UserLogin;
import com.service.LoginService;
import com.service.RegisterService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	LoginService loginService;

	public boolean supports(Class<?> clazz) {
		return UserLogin.class.isAssignableFrom(clazz);
	}

	public void validate(Object user, Errors err) {
		// TODO Auto-generated method stub
		UserLogin userLogin = (UserLogin) user;

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "mailId", "mailId.emptyOrSpace");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "pass", "password.emptyOrSpace");
		
		if (userLogin.getMailId() != null && userLogin.getMailId().trim().length() > 0) {
			if (userLogin.getMailId().trim().length() >= 20) {
				err.rejectValue("mailId", "mailId.length.exceeds");
			} else if (!userLogin.getMailId().contains("@")) {
				err.rejectValue("mailId", "mailId.format.first.rule");
			}
		}

		if (userLogin.getPass() != null && userLogin.getPass().trim().length() > 0) {
			if (userLogin.getPass().trim().length() >= 10) {
				err.rejectValue("pass", "pass.length.exceeds");
			}
		}
		// DB validations
		/*if (!loginService.checkUser(userLogin)) {
			err.rejectValue("mailId", "mailId.alreadyRegistered");
		}*/
	}

}

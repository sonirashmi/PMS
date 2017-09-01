package com.aartek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.ProjectDetailsDTO;
@Component
public class ProjectDetailsValidator implements Validator{
	

	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return ProjectDetailsDTO.class.isAssignableFrom(cls);
	}

	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ProjectDetailsDTO pDto=(ProjectDetailsDTO)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client", "error.client.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "error.pname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.startDate.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "error.endDate.empty");
	}

}

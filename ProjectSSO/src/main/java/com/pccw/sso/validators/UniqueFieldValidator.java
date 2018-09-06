package com.pccw.sso.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.pccw.sso.model.User;
import com.pccw.sso.service.UserService;

public class UniqueFieldValidator implements ConstraintValidator<Unique, String>{
	
	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(Unique constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String field, ConstraintValidatorContext context) {
		return userService.getUser(field)==null;
	}

}

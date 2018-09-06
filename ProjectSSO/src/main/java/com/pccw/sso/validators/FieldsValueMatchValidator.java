package com.pccw.sso.validators;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;


public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object>{
	
	String field;
	String fieldMatch;
	String message;

	@Override
	public void initialize(FieldsValueMatch constraintAnnotation) {
		this.field =  constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
		this.message = constraintAnnotation.message();
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		 Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		 Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
		 if (fieldValue != null) {
		    return fieldValue.equals(fieldMatchValue);
		    } else {
		      return fieldMatchValue == null;
		    }
	}

}

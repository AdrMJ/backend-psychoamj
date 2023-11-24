package com.psychoamj.aj4.validation.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.psychoamj.aj4.validation.CorrectDate;

public class CorrectDateValidator implements ConstraintValidator<CorrectDate, LocalDate>{

	private LocalDate minDate;
	private LocalDate maxDate;
	
	@Override
	public void initialize(CorrectDate constraintAnnotation) {
		minDate = LocalDate.of(2003, 07, 04);
		maxDate = LocalDate.now();
	}
	
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

		if (value == null) {
			return false;
		}
		
		return value.isAfter(minDate) && value.isBefore(maxDate);
	}

}

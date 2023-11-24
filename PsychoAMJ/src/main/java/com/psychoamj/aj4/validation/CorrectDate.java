package com.psychoamj.aj4.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.psychoamj.aj4.validation.validator.CorrectDateValidator;

@Target({ ElementType.FIELD })
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Constraint(validatedBy = CorrectDateValidator.class)
public @interface CorrectDate {
	String message() default "Date should be between {min} and {max}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

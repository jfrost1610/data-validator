/**
 * 
 */
package com.frost.datavalidator.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.frost.datavalidator.validator.Age.List;

/**
 * @author jobin
 *
 */
@Retention(RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Documented
@Repeatable(List.class)
@Constraint(validatedBy = { AgeValidator.class })
public @interface Age {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "Age must be more than {value}";

	long value();

	@Retention(RUNTIME)
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Documented
	@interface List {
		Age[] value();
	}
}
/**
 * 
 */
package com.frost.datavalidator.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author jobin
 *
 */
public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

	protected long minAge;

	@Override
	public void initialize(Age age) {
		this.minAge = age.value();
	}

	@Override
	public boolean isValid(LocalDate bday, ConstraintValidatorContext validatorCtx) {

		if (bday == null) {
			return true;
		}

		LocalDate today = LocalDate.now();
		return ChronoUnit.YEARS.between(bday, today) >= minAge;

	}
}
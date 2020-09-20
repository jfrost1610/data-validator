/**
 * 
 */
package com.frost.datavalidator.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jobin
 *
 */
@Slf4j
public class DateValidator implements ConstraintValidator<Date, String> {

	@Override
	public boolean isValid(String date, ConstraintValidatorContext validatorCtx) {

		try {
			LocalDate.parse(date);
		} catch (Exception e) {
			log.error("Failed to parse the date : {}", e);
			return false;
		}

		return true;

	}
}
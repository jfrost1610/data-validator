/**
 * 
 */
package com.frost.datavalidator.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.frost.datavalidator.validator.Age;
import com.frost.datavalidator.validator.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jobin
 *
 */
public class DataModel {

	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be empty")
	@Getter
	@Setter
	private String name;

	@NotNull(message = "Dob cannot be null")
	@Date
	@Age(value = 18)
	@Setter
	private String dob;

	@NotNull(message = "Salary cannot be null")
	@Min(value = 1, message = "Salary should be more than or equal to 1")
	@Getter
	@Setter
	private String salary;

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return LocalDate.parse(dob);
	}

}

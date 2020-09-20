/**
 * 
 */
package com.frost.datavalidator.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.frost.datavalidator.validator.Age;

import lombok.Data;

/**
 * @author jobin
 *
 */
@Data
public class DataModel {

	@NotBlank(message = "Name cannot be empty")
	private String name;

	@Age(value = 18)
	private LocalDate dob;

	@Min(value = 1, message = "Salary should be more than or equal to 1")
	private int salary;

}

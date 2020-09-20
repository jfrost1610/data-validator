/**
 * 
 */
package com.frost.datavalidator.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.frost.datavalidator.exception.ValidationException;
import com.frost.datavalidator.model.DataModel;

/**
 * @author jobin
 *
 */
@RestController
@RequestMapping("/data")
public class DataController {

	@PutMapping("/{userId}")
	public @ResponseBody ResponseEntity<String> createData(
			@RequestHeader(value = "fileType", required = true) String fileType,
			@PathVariable(value = "userId", required = true) String userId, @Valid @RequestBody DataModel data)
			throws ValidationException {

		if (StringUtils.isBlank(userId)) {
			throw new ValidationException("UserId cannot be empty");
		}

		if (StringUtils.isBlank(fileType)) {
			throw new ValidationException("FileType Header cannot be empty");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("Data is valid.");

	}

}

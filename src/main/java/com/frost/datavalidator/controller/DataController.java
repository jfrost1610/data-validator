/**
 * 
 */
package com.frost.datavalidator.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.frost.datavalidator.model.DocumentDetails;
import com.frost.datavalidator.service.DocumentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jobin
 *
 */
@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DocumentService documentService;

	@PutMapping("/{userId}")
	public @ResponseBody ResponseEntity<String> createData(
			@RequestHeader(value = "fileType", required = true) String fileType,
			@PathVariable(value = "userId", required = true) String userId, @Valid @RequestBody DataModel data)
			throws ValidationException {

		performBasicValidations(fileType, userId);

		documentService.addDocument(userId, fileType, data);

		return ResponseEntity.status(HttpStatus.CREATED).body("New Document created of type " + fileType);

	}

	/**
	 * @param fileType
	 * @param userId
	 * @throws ValidationException
	 */
	private void performBasicValidations(String fileType, String userId) throws ValidationException {

		if (StringUtils.isBlank(userId)) {
			throw new ValidationException("UserId cannot be empty");
		}

		if (StringUtils.isBlank(fileType)) {
			throw new ValidationException("FileType Header cannot be empty");
		}

		DocumentDetails existingDocument = documentService.checkIfDocumentExists(userId);
		if (existingDocument.isExists()) {
			throw new ValidationException(existingDocument.getName()
					+ " Document already exists for this user. You can only update this existing document.");
		}

	}

}

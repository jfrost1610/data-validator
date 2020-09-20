package com.frost.datavalidator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frost.datavalidator.model.DocumentDetails;

@FeignClient(name = "documentSearchClient")
@RequestMapping("document")
public interface DocumentClient {

	@GetMapping(value = "/{userId}")
	public DocumentDetails getDocumentById(@PathVariable("userId") String userId);

	@GetMapping(value = "/{userId}/exists")
	public DocumentDetails exists(@PathVariable("userId") String userId);

}

package com.frost.datavalidator.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frost.datavalidator.client.DocumentClient;
import com.frost.datavalidator.model.DataModel;
import com.frost.datavalidator.model.DocumentDetails;
import com.frost.datavalidator.publisher.DocumentPublisher;

@Service
public class DocumentService {

	@Autowired
	private DocumentClient client;

	@Autowired
	private DocumentPublisher publisher;

	public DocumentDetails checkIfDocumentExists(String userId) {
		return client.exists(userId);
	}

	public DocumentDetails getDocument(String userId) {
		return client.getDocumentById(userId);
	}

	public void addDocument(String userId, String fileType, DataModel data) {

		DocumentDetails newDocument = DocumentDetails.builder().userId(userId).type(fileType).datas(Arrays.asList(data))
				.build();
		publisher.create(newDocument);

	}

}

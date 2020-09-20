package com.frost.datavalidator.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.frost.datavalidator.model.DocumentDetails;

@Service
public class DocumentPublisher {

	@Value("${kafka.topic.create}")
	private String createTopic;

	@Value("${kafka.topic.update}")
	private String updateTopic;

	@Autowired
	private KafkaTemplate<String, DocumentDetails> kafkaTemplate;

	public void create(DocumentDetails payload) {
		kafkaTemplate.send(createTopic, payload);
	}

	public void update(DocumentDetails payload) {
		kafkaTemplate.send(updateTopic, payload);
	}

}

/**
 * 
 */
package com.boot.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.boot.kafka.model.LibraryEvent;
import com.boot.kafka.service.LibraryEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rajac
 *
 */
@Component
@Slf4j
public class LibraryEventConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LibraryEventService libraryEventService;

	@KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "library-group")
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
		log.info("onMessage recived {}", consumerRecord.value());
		try {
			LibraryEvent readValue = objectMapper.readValue(consumerRecord.value(), LibraryEvent.class);
			if (readValue != null) {
				libraryEventService.saveLibraryEventData(readValue);
			}
		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException occured - {}", e.getLocalizedMessage());
		}
	}
}

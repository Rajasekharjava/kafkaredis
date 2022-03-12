/**
 * 
 */
package com.boot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.kafka.model.LibraryEvent;
import com.boot.kafka.model.LibraryEventType;
import com.boot.kafka.service.KafkaProducerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rajac
 *
 */
@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class KafkaLibraryRestController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping("/libraryEvents")
	public ResponseEntity<Object> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) {
		log.info("postLibraryEvent api started");
		libraryEvent.setLibraryEventType(LibraryEventType.NEW);
		kafkaProducerService.sendMessage(libraryEvent);
		return ResponseEntity.ok("Successfully Sent to the kafka Broker");
	}

}

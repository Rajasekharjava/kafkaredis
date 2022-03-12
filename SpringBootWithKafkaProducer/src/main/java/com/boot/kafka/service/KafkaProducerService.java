/**
 * 
 */
package com.boot.kafka.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.boot.kafka.model.LibraryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rajac
 *
 */
@Service
@Slf4j
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void sendMessage(LibraryEvent libraryEvent) {
		log.info("sendMessage method started");

		String writeValueAsString = null;
		try {
			writeValueAsString = objectMapper.writeValueAsString(libraryEvent);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException();
		}

		ListenableFuture<SendResult<Integer, String>> sendDefault = kafkaTemplate
				.sendDefault(libraryEvent.getLibraryEventId(), writeValueAsString);

		sendDefault.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onFailure(Throwable ex) {
				log.error("Unable to send data to kafka broker -{}", ex.getCause());
			}

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				ProducerRecord<Integer, String> producerRecord = result.getProducerRecord();
				Integer key = producerRecord.key();
				String topic = producerRecord.topic();
				Integer partition = producerRecord.partition();
				log.info("Successfully sent data to the kafka broker key ={} , topic={},partition={} ", key, topic,
						partition);

			}
		});

	}

}

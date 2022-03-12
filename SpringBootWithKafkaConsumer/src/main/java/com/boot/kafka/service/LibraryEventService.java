package com.boot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.kafka.model.LibraryEvent;
import com.boot.kafka.repo.LibraryEventRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LibraryEventService {

	@Autowired
	private LibraryEventRepo libraryEventRepo;

	public void saveLibraryEventData(LibraryEvent libraryEvent) {
		/*
		 * if (libraryEvent.getLibraryEventId() != null) { throw new
		 * IllegalArgumentException("Not a Library Event"); }
		 */
		libraryEvent.getBook().setLibraryEvent(libraryEvent);
		libraryEventRepo.save(libraryEvent);
		log.info("saveLibraryEventData successfull!..");
	}

}

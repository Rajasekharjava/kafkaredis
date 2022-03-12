package com.boot.kafka.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LibraryEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2593078282621116759L;

	private Integer libraryEventId;

	private LibraryEventType libraryEventType;

	private Book book;

}

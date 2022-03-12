package com.boot.kafka.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LIBRARY_EVENT")
public class LibraryEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2593078282621116759L;

	@Id
	@Column(name = "LIBRARY_EVENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer libraryEventId;

	@Enumerated(EnumType.STRING)
	@Column(name = "LIBRARY_EVENT_TYPE")
	private LibraryEventType libraryEventType;

	@OneToOne(mappedBy = "libraryEvent", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private Book book;

}

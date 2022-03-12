/**
 * 
 */
package com.boot.kafka.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rajac
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2850784033923668736L;

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "PUBLISHER")
	private String publisher;

	@OneToOne
	@JoinColumn(name = "LIBRARY_EVENT_ID")
	private LibraryEvent libraryEvent;

}

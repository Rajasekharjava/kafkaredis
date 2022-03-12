/**
 * 
 */
package com.boot.kafka.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author rajac
 *
 */
@Data
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2850784033923668736L;

	private Integer bookId;

	private String bookName;

	private String publisher;

}

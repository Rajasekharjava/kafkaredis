/**
 * 
 */
package com.boot.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.kafka.model.Book;

/**
 * @author rajac
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

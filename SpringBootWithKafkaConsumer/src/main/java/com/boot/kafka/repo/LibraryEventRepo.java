package com.boot.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.kafka.model.LibraryEvent;

@Repository
public interface LibraryEventRepo extends JpaRepository<LibraryEvent, Integer> {

}

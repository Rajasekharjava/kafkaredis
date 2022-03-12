package com.boot.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableKafka
public class SpringBootWithKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaProducerApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("library-events").partitions(3).replicas(3).build();
	}
}

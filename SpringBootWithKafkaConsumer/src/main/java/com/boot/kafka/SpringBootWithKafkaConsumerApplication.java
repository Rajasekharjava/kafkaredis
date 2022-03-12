package com.boot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.boot.kafka")
@EntityScan(basePackages = "com.boot.kafka.model")
@EnableJpaRepositories(basePackages = "com.boot.kafka.repo")
@EnableTransactionManagement
@EnableKafka
public class SpringBootWithKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaConsumerApplication.class, args);
	}

}

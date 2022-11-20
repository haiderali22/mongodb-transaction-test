package com.hali.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@SpringBootApplication
public class MongodbTransactionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbTransactionTestApplication.class, args);
	}
	
	

}

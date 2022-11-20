package com.hali.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@Configuration
public class Config {
	
	@Bean
	MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
	    return new MongoTransactionManager(dbFactory);
	}
}

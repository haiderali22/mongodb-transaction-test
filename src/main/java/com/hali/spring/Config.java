package com.hali.spring;

import de.flapdoodle.embed.mongo.commands.MongodArguments;
import de.flapdoodle.embed.mongo.config.Storage;
import de.flapdoodle.embed.mongo.spring.autoconfigure.TypedBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

import java.util.function.Function;

@Configuration
public class Config {
	
	@Bean
	MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
	    return new MongoTransactionManager(dbFactory);
	}
}

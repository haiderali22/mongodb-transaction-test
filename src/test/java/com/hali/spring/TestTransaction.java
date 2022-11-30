package com.hali.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(
		exclude = org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration.class
)
public class TestTransaction {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;

	@BeforeEach
	public void setUp() {
		personRepository.deleteAll();
	}

	@Test
	public void addNoTransactionalTest() {
		try {
			personService.addNoTransactional();
		} catch (Exception e) {
			// TODO: handle exception
		}


		Assertions.assertEquals(1, personRepository.findAll().size());
	}

	@Test
	public void addTransactionalTest() {
		try {
			personService.addTransactional();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Assertions.assertEquals(0, personRepository.findAll().size());
	}
}

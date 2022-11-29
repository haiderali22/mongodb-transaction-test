package com.hali.spring;

import de.flapdoodle.embed.mongo.commands.MongodArguments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@EnableAutoConfiguration(
		exclude = org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration.class
)
@ExtendWith(SpringExtension.class)
@DirtiesContext
public class TestTransaction {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;
	
	@BeforeEach
	public void setUp() {
//		personService = new PersonService(personRepository);
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

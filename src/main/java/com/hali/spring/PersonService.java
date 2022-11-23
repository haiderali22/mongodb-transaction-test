package com.hali.spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
	private final PersonRepository personRepository; 
	
	
	public void addNoTransactional() {
		personRepository.save(Person.builder()
				.name("test1")
				.build());
		if(true)
		throw new IllegalArgumentException("");
		
		personRepository.save(Person.builder()
				.name("test2")
				.build());
	}
	
	@Transactional
	public void addTransactional() {
		personRepository.save(Person.builder()
				.name("test1")
				.build());
		
		if(true)
			throw new IllegalArgumentException("");
		
		
		personRepository.save(Person.builder()
				.name("test2")
				.build());
	}

	public void addTransactionalS() {
		personRepository.save(Person.builder()
				.name("test1")
				.build());
		
	}
}

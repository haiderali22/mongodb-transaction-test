package com.hali.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final PersonService personService;
	
	@GetMapping("/test0")
	public void test0(){
		personService.addTransactionalS();
	}
	
	@GetMapping("/test1")
	public void test1(){
		personService.addTransactional();
	}
	
	@GetMapping("/test2")
	public void test2(){
		personService.addNoTransactional();
	}
}

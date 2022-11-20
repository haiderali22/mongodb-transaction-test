package com.hali.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "persons")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

	@Id
	private String id;
	
	private String name;
}

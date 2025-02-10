package com.TODOSpringBoot.TODOTASK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodotaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodotaskApplication.class, args);
	}

}

// Presentation Layer

// A -> We Have to make Presentation Layer => Controller

// B -> We to Convert data into Jav Object  => DTO

// Percistance Layer   --> After that we have till completed the Presentation layer now we work on percistance layer

// A -> Now we 1st make a Entity  ==> Entity
// B -> Entity Operation depends on the Repository so make repository   ==? Repositoty


// Service Layer  till Now we make Percistance and presentatinon layer seperetly noe combine these using sevice layer

// A -> Make Service in Between prsentation layer and percistance layer  ==> Service
// B -> We Required the ModelMapper class so take model mapper and make it bean in config folder  ==> Config
// C -> Connect Service in betwenn the presentation layer and percistance layer


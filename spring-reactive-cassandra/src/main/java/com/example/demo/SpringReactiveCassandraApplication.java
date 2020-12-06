package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class SpringReactiveCassandraApplication {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping("/getUsers")
	public Flux<User> getUsers()
	{
		return repository.findAll();
	}
	
	@GetMapping("/getUserByAge/{age}")
	public Flux<User> getUserByAge(@PathVariable int age)
	{
		return repository.findByAgeLessThan(age);
	}

	@GetMapping("/getUser/{name}")
	public Mono<User> getUser(@PathVariable String name)
	{
		return repository.findByName(name);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveCassandraApplication.class, args);
	}

}

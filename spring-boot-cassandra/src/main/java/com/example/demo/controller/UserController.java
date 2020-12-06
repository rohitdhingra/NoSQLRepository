package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(1,"Rohit","Noida",34));
		users.add(new User(2,"Rahul","Mumbai",37));
		users.add(new User(3,"Anchal","Noida",34));
		users.add(new User(4,"Gargi","Mumbai",36));
		repository.saveAll(users);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return repository.findAll();
	}
	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age)
	{
		return repository.findByAgeGreaterThan(age);
	}
}

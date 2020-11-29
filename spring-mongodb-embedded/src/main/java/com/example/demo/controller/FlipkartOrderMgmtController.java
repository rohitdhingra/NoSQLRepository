package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.FlipkartRepository;

@RestController
@RequestMapping("/orderService")
public class FlipkartOrderMgmtController {
	@Autowired
	private FlipkartRepository repository;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody User user)
	{
		repository.save(user);
		
		return "Order Placed Successfully";
	}
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name)
	{
		return repository.findByName(name);
	}
	
	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserByAddress(@PathVariable String city)
	{
		return repository.findByCity(city);
	}
}

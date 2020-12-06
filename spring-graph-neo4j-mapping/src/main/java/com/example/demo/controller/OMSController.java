package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.node.Customer;
import com.example.demo.node.Product;
import com.example.demo.repository.CustomerRepository;

@RestController
public class OMSController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostConstruct
	public void purchaseOrder() {
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(1,"Mobile",1,8000));
		products.add(new Product(2,"LED",1,18000));
		Customer customer = new Customer(1,"Rohit",new String[] {"Noida"},products);
		
		List<Product> products2 = new ArrayList<>();
		products2.add(new Product(3,"Bike",1,40000));
		products2.add(new Product(4,"AC",1,260000));
		Customer customer2 = new Customer(2,"Rahul",new String[] {"Mumbai"},products2);
		customerRepository.save(customer);
		customerRepository.save(customer2);
	}
	
	@GetMapping("/getOrders")
	public List<Customer> getPurchaseOrder()
	{
		return (List<Customer>) customerRepository.findAll();
	}
	@GetMapping("/getInfo/{name}")
	public Customer getInfo(@PathVariable String name)
	{
	return customerRepository.findByName(name);	
	}
}

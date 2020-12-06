package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class SpringBootCouchbaseExampleApplication {

	@Autowired
	private CustomerRepository repository;
	
	@PostConstruct
	public void initCustomerRepo()
	{
		repository.saveAll(Stream.of(new Customer(1,"Rohit",new String[] {"Noida"}),
				new Customer(2,"Rahul",new String[] {"Mumbai"})
				).collect(Collectors.toList()));
	}
	
	@GetMapping("/fetchAllCustomers")
	public Iterable<Customer> getAll(){
		return repository.findAll();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouchbaseExampleApplication.class, args);
	}

}

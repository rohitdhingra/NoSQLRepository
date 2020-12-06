package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@PostConstruct
	public void addEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"Rohit",new String[] {"Noida"}));
		employees.add(new Employee(2,"Rahul",new String[] {"Mumbai"}));
		employees.add(new Employee(3,"Anchal",new String[] {"Noida"}));
		repository.saveAll(employees);
	}
	
	@GetMapping("/getAllEmployees")
	public Iterable<Employee> getEmployee()
	{
		return  repository.findAll();
	}
	
	@GetMapping("/getEmployee/{name}")
	public Employee getEmployeeByName(@PathVariable String name)
	{
		return repository.findByName(name);
	}
	
}

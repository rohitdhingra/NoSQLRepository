package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demo.node.Customer;

public interface CustomerRepository extends Neo4jRepository<Customer, Integer>{

	Customer findByName(String name);

}

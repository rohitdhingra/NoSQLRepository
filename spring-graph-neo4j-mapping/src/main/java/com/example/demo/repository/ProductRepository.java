package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demo.node.Product;

public interface ProductRepository extends Neo4jRepository<Product, Integer> {

}

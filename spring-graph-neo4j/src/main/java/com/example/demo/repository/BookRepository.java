package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demo.node.Book;

public interface BookRepository extends Neo4jRepository<Book, Integer>{

	Book findByName(String name);

}

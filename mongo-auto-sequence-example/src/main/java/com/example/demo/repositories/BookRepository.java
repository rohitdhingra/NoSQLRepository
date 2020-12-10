package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{

}

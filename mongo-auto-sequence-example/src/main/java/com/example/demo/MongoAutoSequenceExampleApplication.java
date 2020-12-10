package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.SequenceGeneratorService;

@SpringBootApplication
@RestController
public class MongoAutoSequenceExampleApplication {

	@Autowired
	private BookRepository repository;
	@Autowired
	private SequenceGeneratorService seqService;
	
	@PostMapping("/saveBook")
	public Book save(@RequestBody Book book)
	{
		book.setId(seqService.getSequenceNumber(Book.SEQUENCE_NAME));
		return repository.save(book);
	}
	
	
	@GetMapping("/getAllBooks")
	public List<Book> getBooks()
	{
	return repository.findAll();	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MongoAutoSequenceExampleApplication.class, args);
	}

}

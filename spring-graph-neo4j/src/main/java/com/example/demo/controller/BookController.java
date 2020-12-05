package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.node.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book)
	{
		bookRepository.save(book);
		return "Book Added successfully";
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks()
	{
		return (List<Book>) bookRepository.findAll();
	}
	
	@GetMapping("/getBook/{name}")
	public Book getBook(@PathVariable String name)
	{
		return bookRepository.findByName(name);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable String id	)
	{
		bookRepository.deleteById(id);
		return "Record deleted successfully:"+id;
	}
}

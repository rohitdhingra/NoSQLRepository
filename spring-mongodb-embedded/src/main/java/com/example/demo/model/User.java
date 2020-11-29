package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Order_DB")
public class User {
	@Id
private int id;
private String name;
private String gender;

private List<Product> products;
private Address address;
}

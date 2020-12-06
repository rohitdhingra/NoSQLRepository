package com.example.demo.node;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private int id;
	private String name;
	private int qty;
	private double price;
}

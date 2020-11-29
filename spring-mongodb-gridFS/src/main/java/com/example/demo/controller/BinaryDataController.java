package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@RestController
public class BinaryDataController {

	@Autowired
	private GridFsOperations gridFsOperations;
	String fileId = "";

	@GetMapping("/saveFiles")
	public String saveFile() throws FileNotFoundException {
		// define metadata
		DBObject metaData = new BasicDBObject();
		metaData.put("organisation", "JMD");

		// Store image file
		InputStream inputStream = new FileInputStream("C://poc//Bill.jpeg");
		metaData.put("type", "image");

		// store this to mongodb
		fileId = gridFsOperations.store(inputStream, "bill.jpeg", "image/jpeg", metaData).getId().toString();
		System.out.println("File Id Stored" + fileId);

		metaData.put("type", "data");
		gridFsOperations.store(new FileInputStream("C://poc//DockerIssue.txt"), "myText.txt", "text/plain", metaData)
				.getId().toString();
		return "File Stored Successfully";

	}

	@GetMapping("/retrieveImage")
	public String retrieveImageFile() throws IOException {
		GridFSDBFile dbFile = gridFsOperations.findOne(new Query(Criteria.where("_id").is(fileId)));
		System.out.println("File Name:" + dbFile.getFilename());
		dbFile.writeTo("F:/EclipseWorkSpaces/STSWS/spring-mongodb-gridFS/new");
		return "Image File Retrived with name:" + dbFile.getFilename();
	}

	@GetMapping("/retrieveText")
	public String retrieveTextFile() throws IOException {
		GridFSDBFile dbFile = gridFsOperations.findOne(new Query(Criteria.where("metadata.type").is("data")));
		dbFile.writeTo("F://EclipseWorkSpaces//STSWS//spring-mongodb-gridFS//new//");
		System.out.println("File Name:" + dbFile.getFilename());
		return "Text File Retrived with name:" + dbFile.getFilename();
	}
}

package com.example.demo.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DbSequence;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public int getSequenceNumber(String sequenceNumber) {
		Query query = new Query(Criteria.where("id").is(sequenceNumber));
		Update update = new Update().inc("seq", 1);
		DbSequence counter = mongoOperations.findAndModify(query, update,
				FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);
		
		return !Objects.isNull(counter)?counter.getSeq():1;
	}
}

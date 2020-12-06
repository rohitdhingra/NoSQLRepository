package com.example.demo.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.demo.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCassandraRepository<User, Integer> {

	@AllowFiltering
	Flux<User> findByAgeLessThan(int age);

	@AllowFiltering
	Flux<User> findByAddress(String address);
	
	@AllowFiltering
	Mono<User> findByName(String name);

}

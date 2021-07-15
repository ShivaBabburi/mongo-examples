package com.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

	//@Query(value = "{'categories': {$eleMatch:{$in:[?0,'?1']}}}")
	List<Book> findByCategories(String[] categories);
	
}
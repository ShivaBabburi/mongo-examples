package com.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByAddressState(String state);

	@Query(value = "{'marks':{$gte:?0}}",fields = "{'firstName':1, 'id':0}")
	List<Student> findByStudentGreaterThanMarks(Double marks);

}

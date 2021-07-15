package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}

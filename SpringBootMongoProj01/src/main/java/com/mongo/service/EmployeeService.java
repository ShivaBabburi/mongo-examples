package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongo.model.Employee;
import com.mongo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	public Employee add(Employee emp) {
		return empRepo.insert(emp);
	}

	public Employee update(Employee emp) {
		return empRepo.save(emp);
	}

	public Object delete(String id) {
		empRepo.deleteById(id);
		return id;
	}
	
	public List<Employee> findBySalary(String salary){
		Query query=new Query();
		query.addCriteria(Criteria.where("salary").gte(salary));
		return mongoTemplate.find(query, Employee.class);
	}

	public List<Employee> findByfirstName(String firstName) {
		Query query=new Query(Criteria.where("firstName").regex("^"+firstName));
		return mongoTemplate.find(query, Employee.class);
	}

}

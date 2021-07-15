package com.mongo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Employee;
import com.mongo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empSvc;
	
	@GetMapping("/all")
	public List<Employee> getAll(){
		return empSvc.getAll();
	}
	
	@PostMapping("/create")
	public Employee add(@RequestBody Employee emp){
		return empSvc.add(emp);
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee emp){
		return empSvc.update(emp);
	}

	/*
	@DeleteMapping
	public Object delete(String id){
	  return empSvc.delete(id);
	}
	*/
	
	@GetMapping("/salary/")
	public List<Employee> getEmpsBySalary(@PathParam(value = "salary") String salary){
		return empSvc.findBySalary(salary);
	}
	
	@GetMapping("/firstName/")
	public List<Employee> getEmpsByFirstName(@PathParam(value = "firstName") String firstName){
		return empSvc.findByfirstName(firstName);
	}
}

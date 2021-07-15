package com.mongo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Student;
import com.mongo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentSvc;
	
	@GetMapping("/all")
	public List<Student> getAllStudents(){
		return studentSvc.getAllStudents();
	}
	
	@PostMapping("/createStudent")
	public String saveStudent(@RequestBody Student stud) {
		return studentSvc.saveStudent(stud);
	}
	
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student stud) {
		return studentSvc.updateStudent(stud);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@RequestParam("id") String id) {
		studentSvc.deleteStudent(id);
	}
	
	@GetMapping("/page")
	public Map<String, Object> getAllStudentsInPage(@RequestParam(name = "pageno",defaultValue = "0")  int pageNo,
					@RequestParam(name = "pageSize",defaultValue = "2") int pageSize,
					@RequestParam(name = "sortBy", defaultValue = "id") String sortBy){
		return studentSvc.getAllStudentsInPage(pageNo, pageSize,sortBy);
	}
	
	//example executor
	@GetMapping("/example")
	public List<Student> getAllByExample(@RequestBody Student stud){
		return studentSvc.getAllByExample(stud);
	}
	
	//query by method name
	@GetMapping("/firstName")
	public List<Student> getAllStudentsByFirstName(@RequestParam String firstName){
		return studentSvc.getAllStudentsByFirstName(firstName);
	}
	
	@GetMapping("/state")
	public List<Student> getAllStudentsBasedOnState(@RequestParam(name = "state") String state){
		return studentSvc.getAllStudentsBasedOnState(state);
	}
	
	//query based on json
	@GetMapping("/marks")
	public List<Student> getAllStudentsByMarksGreaterThan(@RequestParam(name = "marks") Double marks){
		return studentSvc.getAllStudentsByMarksGreaterThan(marks);
	}
}

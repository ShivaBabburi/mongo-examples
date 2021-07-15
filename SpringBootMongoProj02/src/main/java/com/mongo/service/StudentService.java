package com.mongo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mongo.model.Student;
import com.mongo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	
	public String saveStudent(Student stud) {
		Student stud1=studentRepo.insert(stud);
		if(stud1!=null) {
			return "Student saved with id :: "+stud1.getId();
		}
		else {
			return "Student is not saved ";
		}
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}

	public String updateStudent(Student stud) {
		Student stud1=studentRepo.save(stud);
		if(stud1!=null) {
			return "Student updated with id :: "+stud1.getId();
		}
		else {
			return "Student is not updated ";
		}
	}

	public void deleteStudent(String id) {
			studentRepo.deleteById(id);
	}

	public Map<String, Object> getAllStudentsInPage(int pageNo, int pageSize, String sortBy) {
		Map<String, Object> response=new HashMap<String, Object>();
		Sort sort=Sort.by(sortBy);
		Pageable page=PageRequest.of(pageNo, pageSize, sort);
		Page<Student> studPage= studentRepo.findAll(page);
		response.put("data", studPage.getContent());
		response.put("Total No of Pages :: ", studPage.getTotalPages());
		response.put("Total no of Elements :: ", studPage.getTotalElements());
		response.put("current Page no", studPage.getNumber());
		return response;
	}

	public List<Student> getAllByExample(Student stud) {
		//ExampleMatcher matcher=ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("firstName", GenericPropertyMatcher.of(StringMatcher.EXACT));
		Example<Student> e=Example.of(stud);
		return studentRepo.findAll(e);
	}

	public List<Student> getAllStudentsByFirstName(String firstName) {
		return studentRepo.findByFirstName(firstName);
	}

	public List<Student> getAllStudentsBasedOnState(String state) {
		return studentRepo.findByAddressState(state);
	}

	public List<Student> getAllStudentsByMarksGreaterThan(Double marks) {
		return studentRepo.findByStudentGreaterThanMarks(marks);
	}
}

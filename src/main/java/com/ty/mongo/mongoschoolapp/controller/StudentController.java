package com.ty.mongo.mongoschoolapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.mongo.mongoschoolapp.dao.StudentDao;
import com.ty.mongo.mongoschoolapp.dto.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDao dao;
	
	@GetMapping("/save")
	public Student save() {
		Student s = new Student();
		s.setId(4);
		s.setName("Raju");
		s.setAge(22);
		s.setPercentage(89.34);
		s.setDob(LocalDateTime.now());
		return dao.saveStudent(s);
	}
	
	@GetMapping("/all")
	public List<Student> getAll() {
		return dao.getAllStudent();
	}
}

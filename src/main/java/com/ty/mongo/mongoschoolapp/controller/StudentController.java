package com.ty.mongo.mongoschoolapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.mongo.mongoschoolapp.dao.StudentDao;
import com.ty.mongo.mongoschoolapp.dto.Pan;
import com.ty.mongo.mongoschoolapp.dto.Student;
import com.ty.mongo.mongoschoolapp.service.SequenceGenerator;

@RestController
public class StudentController {

	@Autowired
	private StudentDao dao;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@GetMapping("/save")
	public Student save() {
		Student s = new Student();
		s.setId((int)sequenceGenerator.generateSequence("student_sequence"));
		s.setName("Dinesh");
		s.setAge(22);
		s.setPercentage(89.34);
		s.setDob(LocalDateTime.now());
		
		Pan p = new Pan();
		p.setId((int)sequenceGenerator.generateSequence("pan_sequence"));
		p.setDateTime(LocalDateTime.now());
		p.setName("Geetha");
		s.setPan(p);
		return dao.saveStudent(s);
	}
	
	@GetMapping("/all")
	public List<Student> getAll() {
		return dao.getAllStudent();
	}
	
	@GetMapping("/bystuname")
	public List<Student> gteAllByStudentName(@RequestParam(name="name")  String name) {
		return dao.getByStuName(name);
	}
	
	@GetMapping("/bypanname")
	public Student gteAllByPanName(@RequestParam(name="name")  String name) {
		return dao.getByPanName(name);
	}
}

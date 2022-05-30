package com.ty.mongo.mongoschoolapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.mongo.mongoschoolapp.dto.Student;
import com.ty.mongo.mongoschoolapp.repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getAllStudent() {
		return repository.findAll();
	}
	
	public List<Student> getByStuName(String name) {
		return repository.getStudentForName(name);
	}
	
	public Student getByPanName(String name) {
		return repository.getStudentForPanName(name);
	}
}

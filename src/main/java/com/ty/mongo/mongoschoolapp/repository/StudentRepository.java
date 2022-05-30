package com.ty.mongo.mongoschoolapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.mongo.mongoschoolapp.dto.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{
	
	@Query("{name:?0}")
	public List<Student> getStudentForName(String name);
	@Query("{'pan.name':?0}")
	public Student getStudentForPanName(String name);
}

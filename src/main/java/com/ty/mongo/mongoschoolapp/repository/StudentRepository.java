package com.ty.mongo.mongoschoolapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.mongo.mongoschoolapp.dto.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{
}

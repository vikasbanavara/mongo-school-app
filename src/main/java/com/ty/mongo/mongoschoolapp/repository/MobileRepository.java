package com.ty.mongo.mongoschoolapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.mongo.mongoschoolapp.dto.Mobile;
import com.ty.mongo.mongoschoolapp.dto.Sim;

public interface MobileRepository extends MongoRepository<Mobile, Integer>{

	@Query(value = "{ 'sims.id' : ?0 }",fields = "{'sims.id':1,'sims.provider':1,'sims.mic':1}")
	List<Mobile> findSim(int id);
	//{user.id:0,sims:{$elemMatch:{'id':1}}}
}

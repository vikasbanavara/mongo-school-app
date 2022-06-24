package com.ty.mongo.mongoschoolapp.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "mobile")
@Data
public class Mobile {
	@Transient
	public static final String SEQUENCE_NAME = "mobile_sequence";
	@Id
	private long id;
	private String name;
	private double cost;
	private List<Sim> sims;
}

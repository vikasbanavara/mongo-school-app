package com.ty.mongo.mongoschoolapp.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
@Document(collection = "sim")
@Data
public class Sim {
	@Transient
	public static final String SEQUENCE_NAME = "sim_sequence";
	@Id
	private long id;
	private String provider;
	private String mic;
}

package com.ty.mongo.mongoschoolapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.mongo.mongoschoolapp.dto.Mobile;
import com.ty.mongo.mongoschoolapp.dto.Sim;
import com.ty.mongo.mongoschoolapp.repository.MobileRepository;
import com.ty.mongo.mongoschoolapp.util.SequenceGenerator;

@RestController
public class MobileController {
	

	@Autowired
	MobileRepository mobileRepository;

	@Autowired
	private SequenceGenerator sequenceGenerator;

	@PostMapping("/mobiles")
	public Mobile saveMobile(@RequestBody Mobile mobile) {
		mobile.setId(sequenceGenerator.generateSequence("mobile_sequence"));
		List<Sim> sims = mobile.getSims();
		for(Sim sim : sims) {
			sim.setId(sequenceGenerator.generateSequence("sim_sequence"));
		}
		return mobileRepository.save(mobile);
	}

	@GetMapping("/get")
	public Mobile get() {
		Mobile m = new Mobile();
		m.setSims(Arrays.asList(new Sim(), new Sim()));
		return m;
	}
	
	@GetMapping("/sim")
	public Object getSim(@RequestParam int id) {
		return mobileRepository.findSim(id);
	}
}

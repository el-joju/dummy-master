package com.endpoint.dummy.web.controller;

import com.endpoint.dummy.domain.model.Empleado;
import com.endpoint.dummy.domain.model.Movie;
import com.endpoint.dummy.domain.model.ResponseAll;
import com.endpoint.dummy.domain.service.MovieDBConsumerService;
import com.endpoint.dummy.web.response.MovieResponse;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endpoint")
public class EndPointsController {

	@Autowired
	MovieDBConsumerService movieDBConsumerService;

	@GetMapping
	public String responseWithHelloWorld() {
		return "Hello World";
	}

	@GetMapping(
//    		path = "/consuming-latest-movie",
			path = "/findAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseAll> getLatestMovie() {
//		return new ResponseEntity<ResponseAll>(movieDBConsumerService.getLastMovie(), HttpStatus.OK);
		
		ResponseAll out = new ResponseAll();
		out.setMessage(RandomStringUtils.randomAlphabetic(100));
		out.setStatus(RandomStringUtils.random(50));
		Empleado e = new Empleado();
		e.setEmployee_age(RandomStringUtils.randomNumeric(5));
		e.setEmployee_name(RandomStringUtils.randomAlphabetic(10));
		e.setId(Integer.parseInt(RandomStringUtils.randomNumeric(2)));
		out.setData(e);
		return new ResponseEntity<ResponseAll>(out, HttpStatus.OK);
	}
}

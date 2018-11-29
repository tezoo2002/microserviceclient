package com.practice.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.jpa.entity.Contact;
import com.practice.demo.jpa.repository.ContactRepository;

import io.swagger.annotations.ApiOperation;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/api")
@Component
public class JobResource {
	
	@Autowired ContactRepository contactRepository;
	
//	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
//	@ApiOperation(value = "create job", notes = "create job")
//    public void createJob(@ApiParam(required = true) @RequestBody JobEvent job) {
//    }
	
//	@RequestMapping(value = "/hi", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
//	@ApiOperation(value = "greet", notes = "greet api")
//    public String hello() {
//		return "hi";
//    }
	
    @RequestMapping(value = "/getFirstName", method = RequestMethod.GET)
    @ApiOperation(value = "greet", notes = "greet api")
    public ResponseEntity<String> listAllUsers() {
    	List<Contact> contacts = contactRepository.findByLastName("Padala");
        return new ResponseEntity<String>(contacts.get(0).getFirstName(), HttpStatus.OK);
    }
}

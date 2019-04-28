package com.spring.hibernate.controller;


import com.spring.hibernate.model.EmployeeList;
import com.spring.hibernate.service.ManageEmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/employee")
public class HomeController {
	@Autowired
	private ManageEmployeeImpl me;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeList> get(){
		return new ResponseEntity<EmployeeList>(me.listAll(), HttpStatus.OK);
	}
}

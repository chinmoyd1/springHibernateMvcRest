package com.spring.hibernate.controller;


import com.spring.hibernate.service.ManageEmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/employee")
public class HomeController {

	/*@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}*/
	@Autowired
	private ManageEmployeeImpl me;

	@RequestMapping(method = RequestMethod.GET)
	String get(){
		return me.listAll("");
	}
}

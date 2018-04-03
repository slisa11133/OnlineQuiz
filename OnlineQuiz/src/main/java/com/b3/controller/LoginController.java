package com.b3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.Subject;
import com.b3.model.User;
import com.b3.service.SubjectService;
import com.b3.service.UserService;

@Controller
public class LoginController {

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	public LoginController() {
		System.out.println("LoginController()");
	}


	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		model.setViewName("login");
		return model;
	}


}
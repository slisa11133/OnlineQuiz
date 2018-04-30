package com.b3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.Subject;
import com.b3.model.User;
import com.b3.service.LoginService;
import com.b3.service.SubjectService;
import com.b3.service.UserService;

@Controller
public class LoginController {

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	public LoginController() {
		System.out.println("LoginController()");
	}

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/loginCheck", method=RequestMethod.POST)
	public ModelAndView loginCheck(HttpSession httpsession, HttpServletRequest request,ModelAndView model) throws IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        
        String user_role=loginService.loginCheck(username, password);
		if(!user_role.equals("false")) {
			
			httpsession.setAttribute("current_user", userService.getUser(username));
			httpsession.setAttribute("username", userService.getUser(username).getName());
			httpsession.setAttribute("userId", userService.getUser(username).getId());
			
			if(user_role.equals("student")) {
				//model.setViewName("StudentMainPage");
				//return model;
				return new ModelAndView("redirect:/DoTest/chooseTest?quizType=Test");
			}
			else if(user_role.equals("teacher")){
				return new ModelAndView("redirect:/QuizManage/SubjectList");
			}
			else if(user_role.equals("manager")){
				return new ModelAndView("redirect:/user/list");
			}
		}
		model.setViewName("login");
		model.addObject("msg","login failed");
		return model;
	}
	
	@RequestMapping(value = "/registerCheck", method=RequestMethod.POST)
	public ModelAndView registerCheck(HttpServletRequest request,ModelAndView model) throws IOException {
		String username = request.getParameter("reg_username");
        String password = request.getParameter("reg_pwd");
        String realname = request.getParameter("reg_name");
        String grade = request.getParameter("reg_grade");
        String email = request.getParameter("email");
		
        model.addObject("msg",userService.registerUser(username, realname, grade, password, email));
        model.setViewName("login");
        return model;
		
	}
}
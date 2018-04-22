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
	private SubjectService subjectService;
	private User user=new User();
	@Autowired
	private UserService userService;
	@Autowired
	private SessionFactory sessionFactory;

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
			
			if(user_role.equals("student")) {
				//model.setViewName("StudentMainPage");
				//return model;
				return new ModelAndView("redirect:/DoTest/chooseTest?quizType=Test");
			}
			else {
				return new ModelAndView("redirect:/QuizManage/SubjectList");
			}
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/registerCheck", method=RequestMethod.POST)
	public ModelAndView registerCheck(HttpServletRequest request,ModelAndView model) throws IOException {
		String username = request.getParameter("reg_username");
        String password = request.getParameter("reg_pwd");
        String realname = request.getParameter("reg_name");
        String grade = request.getParameter("reg_grade");
		user.setId(username);
		user.setName(realname);
        user.setPwd(password);
        user.setGrade(grade);
        user.setIs_open("T");
        user.setRole("student");
        
        /*userService.addUser(user);
        model.setViewName("login");
		return model;*/
		
		if (userService.getUser(user.getId()) == null) { // if user id is 0 then creating the
			// user other updating the user
			userService.addUser(user);
			model.addObject("msg","registration successful");
			model.setViewName("login");
			return model;
		}

		else {
			// userService.updateUser(user);
			model.addObject("msg", "Account already exist!");
			model.setViewName("login");
			return model;

		}
		
	}
}
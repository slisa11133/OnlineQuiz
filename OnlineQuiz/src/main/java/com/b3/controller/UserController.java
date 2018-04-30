package com.b3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.User;
import com.b3.model.UserAbility;
import com.b3.service.UserService;

import com.b3.model.Ability;
import com.b3.model.Report;
import com.b3.service.BaseReportFactory;
import com.b3.service.StudentReportFactory;
import com.b3.service.TeacherReportFactory;
import com.b3.service.UserAbilityService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	public UserController() {
		System.out.println("UserController()");
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserAbilityService userAbilityService;

	@RequestMapping(value = "/list")
	public ModelAndView listUser(ModelAndView model,HttpSession httpsession) throws IOException {
		List<User> listUser = userService.getAllUsers();
		model.addObject("listUser", listUser);
		model.setViewName("UserManage");
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		return model;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,HttpSession httpsession) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("UserForm");
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		return model;
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public ModelAndView back(ModelAndView model) {
		return new ModelAndView("redirect:/user/list");

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		if (userService.getUser(user.getId()) == null) { // if user id is 0 then creating the
			// user other updating the user
			userService.addUser(user);
			return new ModelAndView("redirect:/user/list");
		}

		else {
			// userService.updateUser(user);
			ModelAndView model = new ModelAndView();
			model.addObject("msg", "Account already exist!");
			model.setViewName("UserForm");
			return model;

		}
		// return new ModelAndView("redirect:/user/list");
		// return new ModelAndView("redirect:/user/list");
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		String userId = request.getParameter("id");
		userService.deleteUser(userId);
		return new ModelAndView("redirect:/user/list");
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		String userId = request.getParameter("id");
		User user = userService.getUser(userId);
		ModelAndView model = new ModelAndView("editUser");
		model.addObject("user", user);
		/** user grade options **/
		model.addObject("Ugrades", userService.getUgrades());
		/** user role options **/
		model.addObject("Urole", userService.getUrole());
		return model;
	}

	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute User user) {
		userService.updateUser(user);
		return new ModelAndView("redirect:/user/list");

	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("redirect:/");
	}

	@Autowired
	private StudentReportFactory StudentreportFactory;
	@Autowired
	private TeacherReportFactory TeacherreportFactory;
	
	@RequestMapping(value = "/getAbilitiesResults", method = RequestMethod.GET)
	public ModelAndView getUserAbilitiesResults(HttpSession httpsession, HttpServletRequest request) {
		String userId = (String) httpsession.getAttribute("userId"); // request.getParameter("id");
		List<UserAbility> userAbilitiesResults = userAbilityService.getUserAbilities(userId);
		BaseReportFactory reportFactory;
		reportFactory = StudentreportFactory;
		List<Report> Sreport = reportFactory.createReport(userId);
		reportFactory = TeacherreportFactory;
		List<Report> Treport = reportFactory.createReport();
		
		
		
		ModelAndView model = new ModelAndView("studentAbilitiesResults");
		// ModelAndView model = new ModelAndView("UserAbilitiesResults");
		model.addObject("userAbilitiesResults", userAbilitiesResults);
		model.addObject("Sreport", Sreport);
		model.addObject("Treport", Treport);
		return model;
	}
	
	
	
	@RequestMapping(value = "/getAbilitiesResultsDiagram", method = RequestMethod.GET)
	public ModelAndView getUserAbilitiesResultsDiagram(HttpSession httpsession, HttpServletRequest request) {
		String userId = (String) httpsession.getAttribute("userId");// request.getParameter("id");
		List<UserAbility> userAbilitiesResults = userAbilityService.getUserAbilities(userId);
		ModelAndView model = new ModelAndView("UserAbilitiesResultsDiagram");
		model.addObject("userAbilitiesResults", userAbilitiesResults);
		return model;
	}
	
	@RequestMapping(value = "/getTeacherAbilitiesResultsDiagram", method = RequestMethod.GET)
	public ModelAndView getTeacherAbilitiesResultsDiagram(HttpSession httpsession, HttpServletRequest request) {
		String userId = (String) httpsession.getAttribute("userId");// request.getParameter("id");
		BaseReportFactory reportFactory;
		reportFactory = TeacherreportFactory;
		List<Report> Treport = reportFactory.createReport();
		ModelAndView model = new ModelAndView("TAblitiesReportDiagram");
		model.addObject("Treport", Treport);
		return model;
	}

}
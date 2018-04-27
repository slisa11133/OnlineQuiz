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
import com.b3.model.Essay;
import com.b3.model.Question;
import com.b3.model.QuestionAbility;
import com.b3.model.Report;
import com.b3.model.Subject;
import com.b3.service.BaseReportFactory;
import com.b3.service.EssayService;
import com.b3.service.StudentReportFactory;
import com.b3.service.TeacherReportFactory;
import com.b3.service.UserAbilityService;
import com.b3.service.QuestionAbilityService;
import com.b3.service.QuestionService;
import com.b3.service.AbilityService;

@Controller
@RequestMapping("/EssayForm")
public class EssayMarkingController {

	private static final Logger logger = Logger.getLogger(EssayMarkingController.class);

	public EssayMarkingController() {
		System.out.println("EssayMarkingController()");
	}

	@Autowired
	private EssayService essayService;	
	
	@Autowired
	private QuestionService questionService;	
	
	@Autowired
	private AbilityService abilityService;	
	
	@Autowired
	private UserAbilityService userAbilityService;	
	

	@Autowired
	private QuestionAbilityService questionAbilityService;

	@RequestMapping(value = "/EssayList")
	public ModelAndView listEssay(ModelAndView model) throws IOException {
		List<Essay> listEssay = essayService.getAllEssayNotMark();
		model.addObject("listEssay", listEssay);
		model.setViewName("EssayForm");
		return model;
	}


	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public ModelAndView back(ModelAndView model) {
		return new ModelAndView("redirect:/EssayForm/EssayList");

	}
	
	@RequestMapping(value = "/deleteEssay", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		Integer essayId = Integer.parseInt(request.getParameter("id"));
		essayService.deleteEssayById(essayId);
		return new ModelAndView("redirect:/EssayForm/EssayList");
	}


	@RequestMapping(value = "/saveMarking", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute Essay essay) {
		essayService.updateEssay(essay);
		return new ModelAndView("redirect:/EssayForm/EssayList");

	}
		
	@RequestMapping(value = "/EssayMarking", method = RequestMethod.GET)
	public ModelAndView essayMarking(HttpServletRequest request) {
		
		Integer essayId = Integer.parseInt(request.getParameter("id"));	
		Essay essay = essayService.getEssayById(essayId);
		Integer quesId = essay.getQ_id();
		//System.out.println("Question Id is "+ quesId);		
		//List<QuestionAbility> listAbility = questionAbilityService.getAllQuestionAbilitiesByQ(quesId);
		List<String> listAbility = questionAbilityService.getAllQuestionAbilities(quesId);
		UserAbility userAbility = new UserAbility();
		ModelAndView model = new ModelAndView("EssayMarking");
		model.addObject("essay", essay);
		model.addObject("userAbility", userAbility);
		/** question ability options **/
		model.addObject("Qability", listAbility);
		return model;
	}
	
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("redirect:/");
	}


}
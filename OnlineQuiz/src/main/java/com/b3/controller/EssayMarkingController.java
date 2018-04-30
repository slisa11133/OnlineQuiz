package com.b3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
	public ModelAndView listEssay(ModelAndView model, HttpSession httpsession) throws IOException {
		List<Essay> listEssay = essayService.getAllEssayNotMark();
		model.addObject("listEssay", listEssay);
		model.setViewName("EssayForm");
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
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

	@Transactional
	@RequestMapping(value = "/saveMarking", method = RequestMethod.POST)
	public ModelAndView saveUpdate(HttpServletRequest request, @ModelAttribute Essay essay) {
		String[] a_ids = request.getParameterValues("a_id");
		String[] results = request.getParameterValues("result");
		List<UserAbility> userAbility = new ArrayList<UserAbility>();
		for (int i = 0; i < a_ids.length; i++) {

			Integer a_id = Integer.parseInt(a_ids[i]);
			float result = Float.parseFloat(results[i]);
			UserAbility ability = new UserAbility();
			ability.setUId(essay.getU_id());
			ability.setAId(a_id);
			ability.setResult(result);
			userAbility.add(ability);
		}
		essayService.updateUserAbility(userAbility);
		essayService.updateEssay(essay);
		
		return new ModelAndView("redirect:/EssayForm/EssayList");

	}

	@RequestMapping(value = "/EssayMarking", method = RequestMethod.GET)
	public ModelAndView essayMarking(HttpServletRequest request, HttpSession httpsession) {
		User u = (User) httpsession.getAttribute("current_user");
		Integer essayId = Integer.parseInt(request.getParameter("id"));
		Essay essay = essayService.getEssayById(essayId);
		essay.setMarker_id(u.getId());
		Integer quesId = essay.getQ_id();
		// System.out.println("Question Id is "+ quesId);
		// List<QuestionAbility> listAbility =
		// questionAbilityService.getAllQuestionAbilitiesByQ(quesId);
		Map<String, String> listAbility = questionAbilityService.getAllEssayAbilities(quesId);
		UserAbility userAbility = new UserAbility();
		ModelAndView model = new ModelAndView("EssayMarking");
		model.addObject("essay", essay);
		model.addObject("userAbility", userAbility);
		/** question ability options **/
		model.addObject("Qability", listAbility);
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("redirect:/");
	}

}
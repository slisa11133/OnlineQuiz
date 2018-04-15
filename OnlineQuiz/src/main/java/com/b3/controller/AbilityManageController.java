package com.b3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.Ability;
import com.b3.service.AbilityService;

@Controller
@RequestMapping("/AbilityManage")
public class AbilityManageController {
	private static final Logger logger = Logger.getLogger(AbilityManageController.class);

	public AbilityManageController() {
		System.out.println("AbilityManageController()");
	}

	@Autowired
	private AbilityService abilityService;

	@RequestMapping(value = "/AbilityList")
	public ModelAndView listAbility(ModelAndView model) throws IOException {
		List<Ability> listAbility = abilityService.getAllAbility();
		model.addObject("listAbility", listAbility);
		model.setViewName("AbilityManage");
		return model;
	}

	@RequestMapping(value = "/newAbility", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Ability ability = new Ability();
		model.addObject("ability", ability);
		model.addObject("operation", "Add New Ability");
		model.setViewName("AbilityForm");
		return model;
	}

	@RequestMapping(value = "/saveAbility", method = RequestMethod.POST)
	public ModelAndView saveAbility(@ModelAttribute Ability ability) {
		// if true then creating the ability, false showing "already exist" message
		if (ability.getId() == 0)
			abilityService.addAbility(ability);
		else
			abilityService.updateAbility(ability);

		return new ModelAndView("redirect:/AbilityManage/AbilityList");
	}

	@RequestMapping(value = "/deleteAbility", method = RequestMethod.GET)
	public ModelAndView deleteAbility(HttpServletRequest request) {
		int abilityId = Integer.parseInt(request.getParameter("id"));
		abilityService.deleteAbility(abilityId);
		return new ModelAndView("redirect:/AbilityManage/AbilityList");
	}

	@RequestMapping(value = "/editAbility", method = RequestMethod.GET)
	public ModelAndView editAbility(HttpServletRequest request) {
		int abilityId = Integer.parseInt(request.getParameter("id"));
		Ability ability = abilityService.getAbility(abilityId);
		ModelAndView model = new ModelAndView("AbilityForm");
		model.addObject("ability", ability);
		model.addObject("operation", "Edit Ability");
		return model;
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView Cancel(HttpServletRequest request) {
		return new ModelAndView("redirect:/AbilityManage/AbilityList");
	}

}
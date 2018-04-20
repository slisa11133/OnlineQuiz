package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.AbilityDAO;
import com.b3.dao.QuestionAbilityDAO;
import com.b3.model.Ability;
import com.b3.model.User;

@Service
@Transactional
public class AbilityServiceImpl implements AbilityService {

	@Autowired
	private AbilityDAO abilityDAO;
	@Autowired
	private QuestionAbilityDAO questionabilityDAO;
	
	@Override
	@Transactional
	public void addAbility(Ability ability) {
		abilityDAO.addAbility(ability);
	}

	@Override
	@Transactional
	public List<Ability> getAllAbility() {
		return abilityDAO.getAllAbility();
	}

	@Override
	@Transactional
	public void deleteAbility(Integer abilityId) {
		abilityDAO.deleteAbility(abilityId);
		questionabilityDAO.deleteQuestionAbilityByA(abilityId);
	}

	public Ability getAbility(int empid) {
		return abilityDAO.getAbilityById(empid);
	}

	public Ability updateAbility(Ability ability) {
		// TODO Auto-generated method stub
		return abilityDAO.updateAbility(ability);
	}

	/**public void setAbilityDAO(AbilityDAO abilityDAO) {
		this.abilityDAO = abilityDAO;
	}**/

}

package com.b3.dao;

import java.util.List;
import java.util.Map;

import com.b3.model.QuestionAbility;

public interface QuestionAbilityDAO {

	public void addQuestionAbility(QuestionAbility questionability);

	public List<QuestionAbility> getAllQuestionAbilitiesByQ(Integer questionId);
	
	public List<String> getAllQuestionAbilities(Integer questionId);
	
	public Map<String, String> getAllEssayAbilities(Integer questionId);

	public void deleteQuestionAbilityByQ(Integer questionId);
	
	public void deleteQuestionAbilityByS(Integer subjectId);
	
	public void deleteQuestionAbilityByA(Integer abilityId);

	public QuestionAbility getQuestionAbilityById(int questionabilityid);
	
}

package com.b3.model.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.OptionDAO;
import com.b3.dao.QuestionAbilityDAO;
import com.b3.dao.QuestionDAO;
import com.b3.dao.UserAbilityDAO;
import com.b3.dao.UserAbilityDAOImpl;
import com.b3.model.Options;
import com.b3.model.Question;
import com.b3.model.QuestionAbility;


@Service
@Transactional
public class QuestionBFQ extends QuestionObject {
	@Autowired
	public QuestionDAO questionDAO;
	@Autowired
	public OptionDAO optionDAO;
	@Autowired
	public QuestionAbilityDAO questionAbilityDAO;
	
	@Override
	@Transactional
	public QuestionObject choose() {
		QuestionObject questionResult = new QuestionBFQ();
		Question question = questionDAO.getQuestionByType("BFQ", s_id, grade, level);
		//List<Options> options = optionDAO.getAllOptionsByQ(question.getId());
		String answer = optionDAO.getAnswerByQ(question.getId()).getOption();
		List<QuestionAbility> Qabilities = questionAbilityDAO.getAllQuestionAbilitiesByQ(question.getId());
		List<String> abilitieslist = questionAbilityDAO.getAllQuestionAbilities(question.getId());
		if(question!=null) {
			questionResult.setQ_id(question.getId());
			questionResult.setS_id(question.getSubId());
			questionResult.setQuestion(question.getQuestion());
			questionResult.setGrade(question.getGrade());
			questionResult.setLevel(question.getLevel());
			questionResult.setOptions(new ArrayList<Options>()); //no options
			questionResult.setAnswer(answer);
			questionResult.setAbilities(Qabilities);
			questionResult.setAbilitieslist(abilitieslist);
		}
		else
			questionResult = null;
        return questionResult;
	}
}

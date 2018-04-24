package com.b3.model.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.QuestionDAO;
import com.b3.dao.UserAbilityDAO;
import com.b3.dao.UserAbilityDAOImpl;
import com.b3.model.Question;


@Service
@Transactional
public class QuestionFIB extends QuestionObject {
	@Autowired
	public QuestionDAO questionDAO;
	
	@Override
	@Transactional
	public QuestionObject choose() {
		QuestionObject questionResult = new QuestionFIB();
		Question question = questionDAO.getQuestionByType("FIB", s_id, grade, level);
		if(question!=null) {
			questionResult.setQ_id(question.getId());
			questionResult.setS_id(question.getSubId());
			questionResult.setQuestion(question.getQuestion());
			questionResult.setGrade(question.getGrade());
			questionResult.setLevel(question.getLevel());
		}
		else
			questionResult = null;
        return questionResult;
	}
}

package com.b3.service.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.UserAbility;
import com.b3.model.question.QuestionObject;

public abstract class BaseQuestionFactory {
	
	
	
	
	//public abstract List<QuestionObject> createQuestion();
    public abstract QuestionObject createQuestion(int s_id, String grade, String level);
    public abstract void clear();
    
}

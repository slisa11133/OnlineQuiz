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
public class QuestionComposite extends QuestionObject {
	
	List<QuestionObject> questions = new ArrayList<QuestionObject>();
	
	
	@Override
	public void add(QuestionObject question){
		questions.add(question);
    }
 
	@Override
    public void remove(QuestionObject question){
		questions.remove(question);
    }
    
	@Override
    public boolean checkExist(QuestionObject question) {
		boolean check = false;
		for (QuestionObject q : questions) {
			if (q.getQ_id() == question.getQ_id()) {
				check = true;
				break;
			}
		}
		return check;
	}    
		
	@Override
	public List<QuestionObject> getQuestionSet() {
    	return questions;
	}
	
	@Override
	public void clearQuestionSet(){
		questions.clear();
    };
}

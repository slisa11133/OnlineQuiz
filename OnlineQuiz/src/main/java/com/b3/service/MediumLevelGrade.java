package com.b3.service;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.QuestionAbilityDAO;
import com.b3.dao.UserAbilityDAO;
import com.b3.dao.UserAbilityDAOImpl;
import com.b3.model.QuestionAbility;
import com.b3.model.UserAbility;
import com.b3.model.question.Paper;
import com.b3.model.question.QuestionObject;
import com.b3.service.QuestionAbilityService;
@Service
@Transactional
public class MediumLevelGrade implements GradeStrategy {

	//@Autowired
	//private UserAbilityDAO userabilitydao;
	@Autowired
	private UserAbilityService uas ;


	@Override
	@Transactional
	public int generateGrade(Paper paper, String u_id) {
		System.out.println("-----tz----"+u_id);
		// TODO Auto-generated method stub
		ArrayList<String> standardAnswerList = new ArrayList<String>();
		List<QuestionObject> questionlist = paper.getQuestionSet();
		List<String> answerlist = paper.getStudentAnswers();
		//List<UserAbility> userability = userabilitydao.getUserAbilities(u_id);
		//System.out.println(userability.size());
		//Map<String, Float> currentability = new HashMap<String, Float>();
		int result = 0;
		for(QuestionObject p:questionlist) {
			standardAnswerList.add(p.getAnswer());
		}
		int len = standardAnswerList.size()-1;
		System.out.println(len + "+"+ answerlist.size());
		while(len>=0) {
			System.out.println("user:"+answerlist.get(len)+"// standard"+standardAnswerList.get(len));
			if( answerlist.get(len).equals(standardAnswerList.get(len))) {
				System.out.println("v"+len);
				result++;
				}
			
			len--;
		}
		System.out.println("paper"+result+"id"+u_id);
		currentability(paper,u_id);
		return result;

	}
	@Override
	@Transactional
	public Map<String,Float> currentability(Paper paper, String u_id){
		System.out.println("-----tz----"+u_id);
		Map<String, Float> currentability = new HashMap<String, Float>();
		ArrayList<String> standardAnswerList = new ArrayList<String>();
		List<QuestionObject> questionlist = paper.getQuestionSet();
		List<String> answerlist = paper.getStudentAnswers();
		for(QuestionObject p:questionlist) {
			standardAnswerList.add(p.getAnswer());
		}
		int len = standardAnswerList.size()-1;

		while(len>=0) {
			System.out.println("user:"+answerlist.get(len)+"// standard"+standardAnswerList.get(len));
			if( answerlist.get(len).equals(standardAnswerList.get(len))) {
				System.out.println("v"+len);
				int q_id = questionlist.get(len).getQ_id();
				System.out.println("q_id"+q_id);
				
				List<String> questionabilitylist = questionlist.get(len).getAbilitieslist();
				ArrayList<String> abilitylist = new ArrayList<String>();
				for(int i = 0; i<questionabilitylist.size();i++) {
					String ability = String.valueOf(questionabilitylist.get(i));
					abilitylist.add(ability);
				}
				
				for(String s:abilitylist) {
					if (currentability.containsKey(s)) {
						float oldvalue = currentability.get(s);
						currentability.put(s, (float) (oldvalue+1));		
					}
					else {
						currentability.put(s, (float) (1));}						
				}
				
				for(String s:abilitylist) {
					System.out.println(currentability.get(s));
				}

			}
			len--;
		}
		
		return currentability;
	}
	

	
}

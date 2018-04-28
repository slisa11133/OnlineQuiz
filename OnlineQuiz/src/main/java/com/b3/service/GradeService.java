package com.b3.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.model.question.Paper;
import com.b3.service.EasyLevelGrade;
import com.b3.service.GradeStrategy;

@Service
@Transactional
public class GradeService {
	

	GradeStrategy grade;
	
	
	@Transactional
	public int gradecomputation(Paper paper, String u_id) {
		int level = Integer.valueOf( paper.getQuestionSet().get(0).getLevel());
		int result = 0;
		System.out.println("level+"+level);
		
		if (level == 1) {
			grade = new EasyLevelGrade();
			result = grade.generateGrade(paper, u_id);
		}else if(level == 2) {
			grade = new MediumLevelGrade();
			result = grade.generateGrade(paper, u_id);
		}else if(level == 3) {
			grade = new HardLevelGrade();
			result = grade.generateGrade(paper, u_id);
		}
		return result;
	}
	@Transactional
	public Map<String, Float> CurrentAbility(Paper paper, String u_id) {
		int level = Integer.valueOf( paper.getQuestionSet().get(0).getLevel());
		Map<String, Float> result = null;
		System.out.println("level+"+level);
		
		if (level == 1) {
			grade = new EasyLevelGrade();
			result = grade.currentability(paper, u_id);
		}else if(level == 2) {
			grade = new MediumLevelGrade();
			result = grade.currentability(paper, u_id);
		}else if(level == 3) {
			grade = new HardLevelGrade();
			result = grade.currentability(paper, u_id);
		}
		return result;
	}
	

}
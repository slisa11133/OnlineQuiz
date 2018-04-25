package com.b3.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.b3.model.UserAbility;
import com.b3.model.question.Paper;

public interface GradeStrategy {
	int generateGrade(Paper paper, String u_id);
	public Map<String,Float> currentability(Paper paper, String u_id);
}

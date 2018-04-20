package com.b3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.UserAbilityDAO;

@Service
@Transactional
public class ReportTeacher extends Report {
	@Autowired
	public UserAbilityDAO userAbilityDAO;
	@Override
	@Transactional
	public List<Report> getData() {
		System.out.println("get teacher report data.");
		List<Report> userAbilitiesResults = userAbilityDAO.getTeacherReport();
        return userAbilitiesResults;
	}
	public List<Report> getData(String userId) {
        return null;
	}
    
}

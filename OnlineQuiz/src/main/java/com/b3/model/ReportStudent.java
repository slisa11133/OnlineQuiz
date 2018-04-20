package com.b3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.UserAbilityDAO;
import com.b3.dao.UserAbilityDAOImpl;


@Service
@Transactional
public class ReportStudent extends Report {
	@Autowired
	public UserAbilityDAO userAbilityDAO;
	
	
	public List<Report> getData() {
        return null;
	}
	
	@Override
	@Transactional
	public List<Report> getData(String userId) {
		System.out.println("get student report data.");
		List<Report> reportResults = userAbilityDAO.getUserReport(userId);
        return reportResults;
	}
	
}

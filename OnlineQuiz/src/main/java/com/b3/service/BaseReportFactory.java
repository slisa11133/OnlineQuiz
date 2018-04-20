package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.UserAbility;

public abstract class BaseReportFactory {
	
	
	
	
	public abstract List<Report> createReport();
    public abstract List<Report> createReport(String userId);
    
}

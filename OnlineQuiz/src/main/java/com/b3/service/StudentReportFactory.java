package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.UserAbility;


@Service
public class StudentReportFactory extends BaseReportFactory {
	private Report report;
	@Autowired
	private ReportStudent Sreport;
	
	public List<Report> createReport() {
		return null;
	}
	
	@Override
	public List<Report> createReport(String userId) {
		if(this.report == null) {
			this.report = Sreport;
		}
		
		return report.getData(userId);
	}
}

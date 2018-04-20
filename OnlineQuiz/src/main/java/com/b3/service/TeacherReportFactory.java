package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.ReportTeacher;
import com.b3.model.UserAbility;

@Service
public class TeacherReportFactory extends BaseReportFactory {
	private Report report;
	@Autowired
	private ReportTeacher Treport;
	
	@Override
	public List<Report> createReport() {
		if(this.report == null) {
			this.report = Treport;
		}
		return report.getData();
	}
	
	public List<Report> createReport(String userId) {
		return null;
	}
	
}

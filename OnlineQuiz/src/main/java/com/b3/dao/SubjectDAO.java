package com.b3.dao;

import java.util.List;

import com.b3.model.Subject;

public interface SubjectDAO {

	public void addSubject(Subject subject);

	public List<Subject> getAllSubjects();

	public void deleteSubject(Integer subjectId);

	public Subject updateSubject(Subject subject);

	public Subject getSubjectById(int subjectid);
	
	public int checkExist(String subjectname);
}

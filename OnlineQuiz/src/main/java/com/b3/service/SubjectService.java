package com.b3.service;

import java.util.List;

import com.b3.model.Subject;

public interface SubjectService {
	
	public boolean addSubject(Subject subject);

	public List<Subject> getAllSubjects();

	public void deleteSubject(Integer subjectId);

	public Subject getSubject(int subjectid);

	public Subject updateSubject(Subject subject);
}

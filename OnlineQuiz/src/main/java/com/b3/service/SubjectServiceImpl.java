package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.SubjectDAO;
import com.b3.model.Subject;
import com.b3.dao.QuestionDAO;
import com.b3.dao.OptionDAO;
import com.b3.dao.QuestionAbilityDAO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private QuestionAbilityDAO questionabilityDAO;
	@Autowired
	private OptionDAO optionDAO;

	@Override
	@Transactional
	public boolean addSubject(Subject subject) {
		// subjectDAO.addSubject(subject);

		// if 0 then creating the subject other showing "already exist" message
		if (subjectDAO.checkExist(subject.getName()) == 0) {
			subjectDAO.addSubject(subject);
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public List<Subject> getAllSubjects() {
		return subjectDAO.getAllSubjects();
	}

	@Override
	@Transactional
	public void deleteSubject(Integer subjectId) {
		subjectDAO.deleteSubject(subjectId);
		questionDAO.deleteQuestionBySub(subjectId);
		questionabilityDAO.deleteQuestionAbilityByS(subjectId);
		optionDAO.deleteOptionBySub(subjectId);
	}

	public Subject getSubject(int empid) {
		return subjectDAO.getSubjectById(empid);
	}

	public Subject updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDAO.updateSubject(subject);
	}

	/**public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}**/

}

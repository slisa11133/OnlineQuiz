package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Subject;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * public void addSubject1(Subject subject) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(subject);
	 * 
	 * }
	 **/
	/* Method to CREATE an subject in the database */
	public void addSubject(Subject subject) {

		Integer subjectID = null;
		subjectID = (Integer) sessionFactory.getCurrentSession().save(subject);


	}

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {

		//return sessionFactory.getCurrentSession().createQuery("from subject").list();

		
		String sql = "SELECT * FROM subject";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Subject.class);
		List subjects = query.list();

		return subjects; 

	}

	@Override
	public void deleteSubject(Integer subjectId) {
		Subject subject = (Subject) sessionFactory.getCurrentSession().load(Subject.class, subjectId);
		if (null != subject) {
			this.sessionFactory.getCurrentSession().delete(subject);
		}

	}

	public Subject getSubjectById(int subjectid) {
		return (Subject) sessionFactory.getCurrentSession().get(Subject.class, subjectid);
	}
	
	public int checkExist(String subjectname) {
		//return (Subject) sessionFactory.getCurrentSession().get(Subject.class, subjectname);
		
		String sql = "SELECT count(*) FROM subject where name= :name ";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("name", subjectname);
		//query.addEntity(Subject.class);
		List result = query.list();
		int count = Integer.parseInt(result.get(0).toString());
		return count;
	}

	@Override
	public Subject updateSubject(Subject subject) {
		sessionFactory.getCurrentSession().update(subject);
		return subject;
	}

}
package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * public void addQuestion1(Question question) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(question);
	 * 
	 * }
	 **/
	/* Method to CREATE an question in the database */
	// public void addQuestion(Question question, List<Integer> abilityList) {
	public void addQuestion(Question question) {

		Integer questionID = null;
		questionID = (Integer) sessionFactory.getCurrentSession().save(question);

		// System.out.print(questionID);
/**
		String sql = "INSERT INTO question_ability (u_id, a_id) VALUES (:u_id, :a_id)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionID);
		query.setParameter("a_id", "1");
		query.executeUpdate(); **/
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestionsBySub(Integer subjectId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// question").list();

		String sql = "SELECT * FROM question WHERE s_id = :s_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("s_id", subjectId);
		query.addEntity(Question.class);

		List questions = query.list();

		return questions;

	}

	@Override
	public void deleteQuestionById(Integer questionId) {
		Question question = (Question) sessionFactory.getCurrentSession().load(Question.class, questionId);
		if (null != question) {
			this.sessionFactory.getCurrentSession().delete(question);
		}

	}

	@Override
	public void deleteQuestionBySub(Integer subjectId) {
		String sql = "DELETE FROM question WHERE s_id= :s_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("s_id", subjectId);
		query.executeUpdate();

	}

	public Question getQuestionById(int questionid) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, questionid);
	}

	@Override
	public Question updateQuestion(Question question) {
		sessionFactory.getCurrentSession().update(question);
		return question;
	}

}
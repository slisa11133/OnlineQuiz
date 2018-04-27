package com.b3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Question;
import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.User;
import com.b3.model.question.QuestionObject;

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
		 * String sql = "INSERT INTO question_ability (u_id, a_id) VALUES (:u_id,
		 * :a_id)"; SQLQuery query =
		 * sessionFactory.getCurrentSession().createSQLQuery(sql);
		 * query.setParameter("q_id", questionID); query.setParameter("a_id", "1");
		 * query.executeUpdate();
		 **/
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestionsBySub(Integer subjectId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// question").list();

		// String sql = "SELECT * FROM question WHERE s_id = :s_id";
		String sql = "SELECT a.q_id,a.question,a.type,a.grade,a.level, GROUP_CONCAT(c.short_name) ability  FROM question a";
		sql += " LEFT JOIN question_ability b on a.q_id=b.q_id";
		sql += " LEFT JOIN ability c on b.a_id=c.a_id";
		sql += " WHERE a.s_id = :s_id";
		sql += " GROUP BY a.q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("s_id", subjectId);
		//query.addEntity(Question.class);

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
	
	@Override
	public Question getQuestionByType(String type,int s_id,String grade,String level) {
		String sql = "SELECT * FROM question";
		sql += " where type = :type and s_id = :s_id and grade = :grade and level = :level";
		sql += " ORDER BY RAND()";
		sql += " LIMIT 1";
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("type", type);
		query.setParameter("s_id", s_id);
		query.setParameter("grade", grade);
		query.setParameter("level", level);
		
		Question question = null;
		if(query.list().size()>0) {
			query.addEntity(Question.class);
			question = (Question)query.list().get(0);
		}
		
		return question;
	}
	
	@Override
	public String isDuplicatedQuestion(String question) {

		String sql = "SELECT * FROM question WHERE question = :question";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("question", question);
		query.addEntity(Question.class);
		List questions = query.list();
		if(questions.isEmpty()) {
			return "True";
		}
		else {
			return "False";
		}	
    }

}
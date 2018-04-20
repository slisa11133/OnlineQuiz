package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Options;

@Repository
public class OptionDAOImpl implements OptionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * public void addOption1(Option option) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(option);
	 * 
	 * }
	 **/
	/* Method to CREATE an option in the database */
	public void addOption(Options option) {

		Integer optionID = null;
		optionID = (Integer) sessionFactory.getCurrentSession().save(option);

		// System.out.print(optionID);
		/**String sql = "INSERT INTO online_quiz.options(q_id, s_id, options, is_answer) VALUES(:q_id, :s_id, :options, :is_answer)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", option.getQId());
		query.setParameter("s_id", option.getSubId());
		query.setParameter("options", option.getOption());
		query.setParameter("is_answer", option.getIs_answer());
		optionID = (Integer) query.executeUpdate();
		System.out.print(optionID); **/
	}

	@SuppressWarnings("unchecked")
	public List<Options> getAllOptionsByQ(Integer questionId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// option").list();

		String sql = "SELECT * FROM options WHERE q_id = :q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		query.addEntity(Options.class);

		List options = query.list();

		return options;

	}

	@Override
	public void deleteOptionById(Integer optionId) {
		Options option = (Options) sessionFactory.getCurrentSession().load(Options.class, optionId);
		if (null != option) {
			this.sessionFactory.getCurrentSession().delete(option);
		}

	}

	@Override
	public void deleteOptionBySub(Integer subjectId) {
		String sql = "DELETE FROM online_quiz.options WHERE s_id= :s_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("s_id", subjectId);
		query.executeUpdate();

	}
	
	@Override
	public void deleteOptionByQ(Integer questionId) {
		String sql = "DELETE FROM online_quiz.options WHERE q_id= :q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		query.executeUpdate();

	}

	public Options getOptionById(int optionid) {
		return (Options) sessionFactory.getCurrentSession().get(Options.class, optionid);
	}

	@Override
	public Options updateOption(Options option) {
		sessionFactory.getCurrentSession().update(option);
		return option;
	}
	
	@Override
	public Options getAnswerByQ(Integer questionId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// option").list();

		String sql = "SELECT * FROM options WHERE q_id = :q_id and is_answer = 'T'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		query.addEntity(Options.class);

		Options option = (Options)query.list().get(0);

		return option;

	}

}
package com.b3.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.QuestionAbility;
import com.b3.model.Report;
import com.b3.model.ReportStudent;

@Repository
public class QuestionAbilityDAOImpl implements QuestionAbilityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* Method to CREATE an questionability in the database */
	public void addQuestionAbility(QuestionAbility questionability) {

		// Integer questionabilityID = null;
		// questionabilityID = (Integer)
		// sessionFactory.getCurrentSession().save(questionability);
		int num = questionability.getAbility().size();
		if (num > 0) {
			int q_id = questionability.getQId();
			int s_id = questionability.getSId();

			String sql = "INSERT INTO question_ability (q_id, s_id, a_id) VALUES";
			for (int i = 0; i < num; i++) {
				int a_id = Integer.parseInt(questionability.getAbility().get(i));
				if (i == 0)
					sql += " (" + q_id + ", " + s_id + ", " + a_id + ")";
				else
					sql += " ,(" + q_id + ", " + s_id + ", " + a_id + ")";
			}

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.executeUpdate();
		}

	}

	@SuppressWarnings("unchecked")
	public List<QuestionAbility> getAllQuestionAbilitiesByQ(Integer questionId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// questionability").list();

		String sql = "SELECT * FROM question_ability WHERE q_id = :q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		// query.addEntity(QuestionAbility.class);
		List<QuestionAbility> questionabilities = query.list();

		return questionabilities;

	}

	// public List<String> getAllQuestionAbilitiesByQuestion(Integer questionId) {
	//
	// // return sessionFactory.getCurrentSession().createQuery("from
	// // questionability").list();
	//
	// String sql = "SELECT * FROM question_ability WHERE q_id = :q_id";
	// SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
	// query.setParameter("q_id", questionId);
	// //query.addEntity(QuestionAbility.class);
	// List<String> questionabilities = query.list();
	//
	// return questionabilities;
	//
	// }

	public List<String> getAllQuestionAbilities(Integer questionId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// questionability").list();

		String sql = "SELECT a_id FROM question_ability WHERE q_id = :q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		// query.addEntity(QuestionAbility.class);
		List<String> questionabilities = query.list();

		return questionabilities;

	}

	@Override
	public Map<String, String> getAllEssayAbilities(Integer questionId) {

		// return sessionFactory.getCurrentSession().createQuery("from
		// questionability").list();

		String sql = "SELECT a.a_id, b.full_name FROM question_ability a";
		sql += " LEFT JOIN ability b on a.a_id = b.a_id";
		sql += " WHERE a.q_id = :q_id";

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		// query.addEntity(QuestionAbility.class);
		List questionabilities = query.list();

		Map<String, String> Qabilities = new LinkedHashMap<String, String>();

		for (Object a : questionabilities) {
			Object[] aa = (Object[]) a;
			Qabilities.put(aa[0].toString(), aa[1].toString());
		}

		return Qabilities;

	}

	@Override
	public void deleteQuestionAbilityByQ(Integer questionId) {
		String sql = "DELETE FROM question_ability WHERE q_id= :q_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("q_id", questionId);
		query.executeUpdate();

	}

	@Override
	public void deleteQuestionAbilityByS(Integer subjectId) {
		String sql = "DELETE FROM question_ability WHERE s_id= :s_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("s_id", subjectId);
		query.executeUpdate();

	}

	@Override
	public void deleteQuestionAbilityByA(Integer abilityId) {
		String sql = "DELETE FROM question_ability WHERE a_id= :a_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("a_id", abilityId);
		query.executeUpdate();

	}

	public QuestionAbility getQuestionAbilityById(int questionabilityid) {
		return (QuestionAbility) sessionFactory.getCurrentSession().get(QuestionAbility.class, questionabilityid);
	}

}
package com.b3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.memento.EssayMemento;
import com.b3.memento.EssayOriginator;
import com.b3.model.Ability;
import com.b3.model.Essay;
import com.b3.model.Report;
import com.b3.model.ReportStudent;

@Repository
public class EssayMementoDAOImpl implements EssayMementoDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean checkExist(String u_id) {
		boolean is_exist = false;
		String sql = "SELECT count(*) FROM memento";
		sql += " WHERE u_id = :u_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("u_id", u_id);

		List result = query.list();
		int count = Integer.parseInt(result.get(0).toString());
		if (count > 0)
			is_exist = true;
		return is_exist;
	}

	@Override
	public EssayMemento getEssayMementoByUser(String u_id) {
		String sql = "SELECT u_id, q_id, question, answer FROM memento";
		sql += " WHERE u_id = :u_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("u_id", u_id);
		
		//query.addEntity(EssayMemento.class);
		EssayOriginator originator = new EssayOriginator();
		List datas = query.list();
		for (Object a: datas) {
			Object[] aa = (Object []) a;
			originator.setU_id(aa[0].toString());
			originator.setQ_id(Integer.parseInt(aa[1].toString()));
			originator.setQuestion(aa[2].toString());
			originator.setAnswer(aa[3].toString());
		}

		return originator.getMemento();
	}

	@Override
	public void deleteEssayMementoByUser(String u_id) {
		String sql = "DELETE FROM memento WHERE u_id= :u_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("u_id", u_id);
		query.executeUpdate();

	}

	@Override
	public void addEssayMemento(EssayMemento essayMemento) {
		String sql = "INSERT INTO memento (u_id, q_id, question, answer) VALUES (:u_id, :q_id, :question, :answer)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("u_id", essayMemento.getU_id());
		query.setParameter("q_id", essayMemento.getQ_id());
		query.setParameter("question", essayMemento.getQuestion());
		query.setParameter("answer", essayMemento.getAnswer());
		query.executeUpdate();
	}
}

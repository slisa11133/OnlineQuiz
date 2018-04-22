package com.b3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Essay;
import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.User;

@Repository
public class EssayDAOImpl implements EssayDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* Method to CREATE an essay in the database */
	// public void addEssay(Essay essay, List<Integer> abilityList) {
	public void addEssay(Essay essay) {

		Integer essayID = null;
		essayID = (Integer) sessionFactory.getCurrentSession().save(essay);

	}

	@SuppressWarnings("unchecked")
	public List<Essay> getAllEssayNotMark() {

		String sql = "SELECT * FROM essay";
		sql += " WHERE marker_id is null or marker_id=''";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		//query.addEntity(Essay.class);

		List essays = query.list();

		return essays;

	}
	
	public List<Essay> getAllEssayByUid(String userId) {

		String sql = "SELECT * FROM essay";
		sql += " WHERE u_id= :u_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Essay.class);
		query.setParameter("u_id", userId);
		
		List essays = query.list();

		return essays;

	}

	@Override
	public void deleteEssayById(Integer essayId) {
		Essay essay = (Essay) sessionFactory.getCurrentSession().load(Essay.class, essayId);
		if (null != essay) {
			this.sessionFactory.getCurrentSession().delete(essay);
		}

	}

	public Essay getEssayById(int essayid) {
		return (Essay) sessionFactory.getCurrentSession().get(Essay.class, essayid);
	}

	@Override
	public Essay updateEssay(Essay essay) {
		sessionFactory.getCurrentSession().update(essay);
		return essay;
	}
	

}
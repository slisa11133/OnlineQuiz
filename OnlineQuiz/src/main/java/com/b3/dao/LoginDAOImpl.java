package com.b3.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Options;
import com.b3.model.User;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean loginCheck(String username, String pwd) {
		String sql = "select * from user where u_id = '" + username + "' and pwd = '" + pwd + "'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
//		query.setParameter("u_id", username);
//		query.setParameter("pwd", pwd);
		query.addEntity(User.class);

		List options = query.list();
		Iterator iter = options.iterator();
		if(iter.hasNext()){
			return true;
		}
		return false;
	};
}

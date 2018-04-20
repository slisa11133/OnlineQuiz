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
	public String loginCheck(String username, String pwd) {
		String sql = "select * from user where u_id = '" + username + "' and pwd = '" + pwd + "'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
//		query.setParameter("u_id", username);
//		query.setParameter("pwd", pwd);
		query.addEntity(User.class);

		List <User> students = query.list();
		Iterator iter = students.iterator();
		if(iter.hasNext()){
			//System.out.println(students.get(0).getRole());
			return students.get(0).getRole();
		}
		
		return "false";
	};
}

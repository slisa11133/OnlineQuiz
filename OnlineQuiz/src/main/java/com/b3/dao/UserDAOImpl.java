package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.User;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* Method to CREATE an user in the database */
	   public void addUser(User user){
			   String userID = null;
		         userID = (String) sessionFactory.getCurrentSession().save(user); 
		       
		      //System.out.print(userID);
		      
	   }

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		//return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	         String sql = "SELECT * FROM user";
	         SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
	         query.addEntity(User.class);
	         List users = query.list();

	        
	         return users;
	     
	}

	@Override
	public void deleteUser(String userId) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, userId);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	public User getUser(String userid) {
		return (User) sessionFactory.getCurrentSession().get(
				User.class, userid);
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

}
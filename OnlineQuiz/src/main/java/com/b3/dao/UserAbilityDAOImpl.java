package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.UserAbility;


@Repository
public class UserAbilityDAOImpl implements UserAbilityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserAbility> getUserAbilities(String userId) {
		String sql = "SELECT * FROM user_ability where u_id = '" + userId + "'";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(UserAbility.class);
        List<UserAbility> userAbilities = query.list();
        return userAbilities;
	}

}

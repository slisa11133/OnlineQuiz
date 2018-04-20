package com.b3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Ability;

@Repository
public class AbilityDAOImpl implements AbilityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * public void addAbility1(Ability ability) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(ability);
	 * 
	 * }
	 **/
	/* Method to CREATE an ability in the database */
	public void addAbility(Ability ability) {

		Integer abilityID = null;
		abilityID = (Integer) sessionFactory.getCurrentSession().save(ability);

	}

	@SuppressWarnings("unchecked")
	public List<Ability> getAllAbility() {

		//return sessionFactory.getCurrentSession().createQuery("from ability").list();
		
		String sql = "SELECT * FROM ability";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Ability.class);
		List ability = query.list();

		return ability; 

	}

	@Override
	public void deleteAbility(Integer abilityId) {
		Ability ability = (Ability) sessionFactory.getCurrentSession().load(Ability.class, abilityId);
		if (null != ability) {
			this.sessionFactory.getCurrentSession().delete(ability);
		}

	}

	public Ability getAbilityById(int abilityid) {
		return (Ability) sessionFactory.getCurrentSession().get(Ability.class, abilityid);
	}
	

	@Override
	public Ability updateAbility(Ability ability) {
		sessionFactory.getCurrentSession().update(ability);
		return ability;
	}

}
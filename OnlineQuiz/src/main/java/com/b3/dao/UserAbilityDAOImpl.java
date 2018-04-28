package com.b3.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.ReportTeacher;
import com.b3.model.UserAbility;

@Repository
public class UserAbilityDAOImpl implements UserAbilityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAbility> getUserAbilities(String userId) {
		String sql = "SELECT * FROM user_ability WHERE u_id = '" + userId + "'";
		System.out.println(sql);
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(UserAbility.class);
		
		List<UserAbility> userAbilities = query.list();
		return userAbilities;
	}

	@Override
	public List<Report> getUserReport(String userId) {
		String sql = "SELECT a.u_id,b.name as userName,b.grade as userGrade";
		sql += " ,b.is_open as userState,a.a_id,c.full_name as abilityName,a.result ";
		sql += " FROM user_ability a";
		sql += " LEFT JOIN user b on a.u_id = b.u_id";
		sql += " LEFT JOIN ability c on a.a_id = c.a_id";
		//sql += " group by a.a_id";
		sql += " where a.u_id = '" + userId + "'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		List<Report> userAbilities = new ArrayList<Report>();
		List datas = query.list();
		for (Object a: datas) {
			Object[] aa = (Object []) a;
			Report re = new ReportStudent();
			re.setU_id(aa[0].toString());
			re.setUserName(aa[1].toString());
			re.setUserGrade(aa[2].toString());
			re.setUserState(aa[3].toString());
			re.setA_id(Integer.parseInt(aa[4].toString()));
			re.setAbilityName(aa[5].toString());
			re.setResult(Float.parseFloat(aa[6].toString()));
			userAbilities.add(re);
		}
		return userAbilities;
	}

	@Override
	public List<Report> getTeacherReport() {
		String sql = "SELECT 'avg' as u_id,'avg' as userName,'avg' as userGrade";
		sql += " ,'avg' as userState,a.a_id,c.full_name as abilityName,avg(a.result) as result ";
		sql += " FROM user_ability a";
		sql += " LEFT JOIN user b on a.u_id = b.u_id";
		sql += " LEFT JOIN ability c on a.a_id = c.a_id";
		sql += " group by a.a_id";

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		List<Report> userAbilities = new ArrayList<Report>();
		List datas = query.list();
		for (Object a: datas) {
			Object[] aa = (Object []) a;
			Report re = new ReportTeacher();
			re.setU_id(aa[0].toString());
			re.setUserName(aa[1].toString());
			re.setUserGrade(aa[2].toString());
			re.setUserState(aa[3].toString());
			re.setA_id(Integer.parseInt(aa[4].toString()));
			re.setAbilityName(aa[5].toString());
			re.setResult(Float.parseFloat(aa[6].toString()));
			userAbilities.add(re);
		}
		return userAbilities;
	}
	@Override
	public void setUserAbilities(UserAbility ua) {
		String sql = "UPDATE user_ability SET result = :result WHERE ua_id=:ua_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("result", ua.getResult());
		query.setParameter("ua_id", ua.getUa_id());
		query.executeUpdate();
		sessionFactory.getCurrentSession().clear();
	}

}

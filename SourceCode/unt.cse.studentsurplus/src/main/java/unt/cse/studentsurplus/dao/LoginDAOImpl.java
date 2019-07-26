package unt.cse.studentsurplus.dao;
/**
 * 
 * @author haidi chen 
 *
 */
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import unt.cse.studentsurplus.model.LoginCredential;

@Repository
@Transactional
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public LoginCredential getLoginCredential(String email) {
		try {
			@SuppressWarnings("rawtypes")
			Query query=sessionFactory.getCurrentSession().createQuery("from LoginCredential where login_id='" + email + "'");
			return (LoginCredential) query.getSingleResult();
		} catch (Exception e) {
			LoginCredential l = new LoginCredential();
			l.setCid(-1);
			return l;
		}
	}

}

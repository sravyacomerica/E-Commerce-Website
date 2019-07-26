package unt.cse.studentsurplus.service;
/**
 * 
 * @author haidi chen 
 */
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unt.cse.studentsurplus.dao.LoginDAO;
import unt.cse.studentsurplus.dao.LoginDAOImpl;
import unt.cse.studentsurplus.model.LoginCredential;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	LoginDAO loginDao;
	
	public LoginServiceImpl() {
		loginDao = new LoginDAOImpl();
	}

	@Transactional
	@Override
	public boolean findUser(String email, String Password) {

		LoginCredential lc = loginDao.getLoginCredential(email);
		
		if (lc.getCid() == -1) {
			System.out.println("no result");
			return false;
		}
		else {
			Password = DigestUtils.sha256Hex(Password);
			if (Password.equals(lc.getPassword())) {
				return true;
			}
			else {
				System.out.println("this is where it goes wrong");
				return false;
			}
		}

	}

}

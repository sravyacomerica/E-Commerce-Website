package unt.cse.studentsurplus.service;

/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.commons.codec.digest.DigestUtils;

import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import unt.cse.studentsurplus.dao.LoginDAO;
import unt.cse.studentsurplus.model.LoginCredential;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	LoginDAO loginDao;

	@InjectMocks
	LoginServiceImpl loginService;

	private String email;
	private String password;
	private LoginCredential lc;

	@Before
	public void setUp() throws Exception {
		email = new String("nick@gma.com");
		password = new String("888888");
		lc = new LoginCredential();
		lc.setCid(3);
		lc.setLogin_id(email);
		lc.setPassword(DigestUtils.sha256Hex(password));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindUser() {
		// find a existing user info
		when(loginDao.getLoginCredential(email)).thenReturn(lc);
		boolean b = loginService.findUser(email, password);
		verify(loginDao).getLoginCredential(email);
		// if the user information is stored in database, it should return true
		assertEquals(true, b);

		// test a wrong password
		lc.setCid(1);
		lc.setLogin_id("john@gmail.com");
		lc.setPassword(DigestUtils.sha256Hex("123456"));
		when(loginDao.getLoginCredential("john@gmail.com")).thenReturn(lc);
		b = loginService.findUser("john@gmail.com", "worngpassword");
		verify(loginDao).getLoginCredential("john@gmail.com");
		// if the password doesn't match, false will be returned;
		assertEquals(false, b);

		// find a non-existing user info
		lc.setCid(-1);
		when(loginDao.getLoginCredential("fake@gma.com")).thenReturn(lc);
		b = loginService.findUser("fake@gma.com", password);
		verify(loginDao).getLoginCredential("fake@gma.com");
		// if the user information is not stored in database, false should be returned
		assertEquals(false, b);

	}

}

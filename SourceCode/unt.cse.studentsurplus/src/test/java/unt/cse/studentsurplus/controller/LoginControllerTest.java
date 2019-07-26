package unt.cse.studentsurplus.controller;
/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@Mock
	private LoginService loginService;
	
	@InjectMocks
	private LoginController loginController;
	
	private LoginCredential lc;
	private String email;
	private String password;

	@Before
	public void setUp() throws Exception {
		email = new String("nick@gma.com");
		password = new String("888888");
		lc = new LoginCredential();
		lc.setLogin_id(email);
		lc.setPassword(password);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testLogin() {
		ModelAndView model = new ModelAndView();
		assertEquals("login", loginController.login(model).getViewName());
	}

	@Test
	public void testSubmit() {
		ModelMap m = new ModelMap();
		HttpSession s = null;
		
		// test a valid login_id
		when(loginService.findUser(email, password)).thenReturn(true);
		String result = loginController.submit(lc, m, s);
		verify(loginService).findUser(email, password);
		// if the login_id is valid and the password matches, it goes to "home" page
		assertEquals("home", result);
		
		// test a invalid login_id
		String invalidId = "hell";
		lc.setLogin_id(invalidId);
		when(loginService.findUser(invalidId, password)).thenReturn(false);
		result = loginController.submit(lc, m, s);
		verify(loginService).findUser(invalidId, password);
		// if the login_id is invalid, it refreshes the "login" page
		assertEquals("login", result);
		
		// test a wrong password
		String wrongPwd = "999999";
		lc.setLogin_id(email);
		lc.setPassword(wrongPwd);
		when(loginService.findUser(email, wrongPwd)).thenReturn(false);
		result = loginController.submit(lc, m, s);
		verify(loginService).findUser(email, wrongPwd);
		// if the password doesn't match, refresh the "login" page
		assertEquals("login", result);
		
		// test a empty login form
		lc.setLogin_id("");
		lc.setPassword("");
		when(loginService.findUser("", "")).thenReturn(false);
		result = loginController.submit(lc, m, s);
		verify(loginService).findUser("", "");
		// if the login form is empty, it also refreshes the "login" page
		assertEquals("login", result);
	}

}

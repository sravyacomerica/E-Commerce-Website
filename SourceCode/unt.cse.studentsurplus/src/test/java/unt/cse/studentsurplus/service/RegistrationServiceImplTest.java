package unt.cse.studentsurplus.service;

/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import unt.cse.studentsurplus.dao.RegistrationDAO;
import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

	@Mock
	private RegistrationDAO rd;

	@Mock
	MultipartFile picture;

	@InjectMocks
	private RegistrationServiceImpl rs;

	private LoginCredential login;
	private User user;
	private Address address;

	@Before
	public void setUp() throws Exception {
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		Date date = new Date(time);

		user = new User();
		user.setUser_id(0);
		user.setEmail("email");
		user.setLast_name("last");
		user.setFirst_name("first");
		user.setMiddle_name("middle");
		user.setPhone_number("12345");
		user.setPicture(picture);
		user.setDate_deleted(date);
		user.setDate_created(timestamp);
		user.setDate_last_modified(timestamp);

		login = new LoginCredential();
		login.setUid(0);
		login.setCid(0);
		login.setRole(0);
		login.setLogin_id("id");
		login.setPassword("password");
		login.setDateCreated(timestamp);
		login.setDateDeleted(timestamp);
		login.setDateLastModified(timestamp);

		address = new Address();
		address.setUser_id(0);
		address.setAddress_id(0);
		address.setCity("city");
		address.setState("state");
		address.setStreet("street");
		address.setzip_code("12345");
		address.setApartment("apartment");
		address.setDate_created(timestamp);
		address.setDate_last_modified(timestamp);
		address.setDate_deleted(timestamp.toString());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLogin_Cred() {
		// if all the required information is provided, add it
		when(rd.addLogin_Cred(login)).thenReturn(true);
		boolean b = rs.addLogin_Cred(login);
		verify(rd).addLogin_Cred(login);
		assertEquals(true, b);

		// if some information is missing, adding will fail
		/*
		 * LoginCredential lc = new LoginCredential(); lc.setCid(5);
		 * when(rd.addLogin_Cred(lc)).thenReturn(false); b = rs.addLogin_Cred(lc);
		 * verify(rd).addLogin_Cred(lc); assertEquals(false, b);
		 */
	}

	@Test
	public void testEditLogin_Cred() {
		rs.editLogin_Cred(login);
		verify(rd).editLogin_Cred(login);
	}

	@Test
	public void testDeleteLogin_Cred() {
		rs.deleteLogin_Cred(1);
		verify(rd).deleteLogin_Cred(1);
	}

	@Test
	public void testGetLoginId() {
		// get the login_id of user whose credential_id is 0
		when(rd.getLoginId(0)).thenReturn(login);
		assertEquals(login, rs.getLoginId(0));
		verify(rd).getLoginId(0);
	}

	@Test
	public void testAdd() {
		// if the user information is all provided, then add it
		when(rd.add(user)).thenReturn(true);
		assertEquals(true, rs.add(user));
		verify(rd).add(user);

		// if some of the required information is not provided,
		// then add operation will be failed
		User u = new User();
		u.setFirst_name("fn");
		u.setLast_name("ln");
		when(rd.add(u)).thenReturn(false);
		assertEquals(false, rs.add(u));
		verify(rd).add(u);
	}

	@Test
	public void testEdit() {
		User u = new User();
		when(rd.edit(user)).thenReturn(u);
		assertEquals(u.getUser_id(), rs.edit(user).getUser_id());
		verify(rd).edit(user);
	}

	@Test
	public void testDelete() {
		rs.delete(0);
		verify(rd).delete(0);
	}

	@Test
	public void testGetUser() {
		when(rd.getUser(0)).thenReturn(user);
		User uu = rs.getUser(0);
		assertEquals(user.getUser_id(), uu.getUser_id());
		assertEquals(user.getEmail(), uu.getEmail());
		verify(rd).getUser(0);
	}

	@Test
	public void testAddAddress() {
		when(rd.addAddress(address)).thenReturn(true);
		assertEquals(true, rs.addAddress(address));
		verify(rd).addAddress(address);
	}

	@Test
	public void testEditAddress() {
		Address ad = new Address();
		ad.setAddress_id(90);
		when(rd.editAddress(address)).thenReturn(ad);
		assertEquals(ad.getAddress_id(), rs.editAddress(address).getAddress_id());
		verify(rd).editAddress(address);
	}

	@Test
	public void testDeleteAddress() {
		rs.deleteAddress(0);
		verify(rd).deleteAddress(0);
	}

	@Test
	public void testGetAddress() {
		when(rd.getAddress(0)).thenReturn(address);
		Address ad = rs.getAddress(0);
		assertEquals(address.getAddress_id(), ad.getAddress_id());
		assertEquals(address.getUser_id(), ad.getUser_id());
		verify(rd).getAddress(0);
	}

	@Test
	public void testGetAddressofUser() {
		when(rd.getAddressofUser(0)).thenReturn(address);
		Address ad = rs.getAddressofUser(0);
		assertEquals(address.getAddress_id(), ad.getAddress_id());
		assertEquals(address.getApartment(), ad.getApartment());
		verify(rd).getAddressofUser(0);
	}

	@Test
	public void testGetByEmail() {
		String email = "email";
		when(rd.getByEmail(email)).thenReturn(user);
		User u = rs.getByEmail(email);
		assertEquals(user.getUser_id(), u.getUser_id());
		assertEquals(user.getEmail(), u.getEmail());
		verify(rd).getByEmail(email);
	}

}

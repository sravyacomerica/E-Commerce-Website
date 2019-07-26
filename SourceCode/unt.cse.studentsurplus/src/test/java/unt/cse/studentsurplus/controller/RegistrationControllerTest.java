package unt.cse.studentsurplus.controller;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *
 */
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	User user;
	LoginCredential login;
	Address address;

	@Mock
	MultipartFile picture;

	@Mock
	HttpServletRequest request;
	
	@Mock
    Model model;
	@Mock
	FileUploadHelper fileUploadHelper;

	@Mock
	RegistrationService registrationService;

	@InjectMocks
	RegistrationController underTest;

	@Mock
	HttpSession session;
	
	@Before
	public void setup() {
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

	void happyPath_when() {
		when(registrationService.add(any(User.class))).thenReturn(true);
		when(registrationService.addLogin_Cred(any(LoginCredential.class))).thenReturn(true);
		when(registrationService.addAddress(any(Address.class))).thenReturn(true);
	}

	void happyPath_verify() {
		verify(registrationService).add(any(User.class));
		verify(registrationService).addLogin_Cred(any(LoginCredential.class));
		verify(registrationService).addAddress(any(Address.class));
	}

	@Test
	public void testSubmit_happyPath() {
		user.setPicture(null);

		happyPath_when();

		String result = underTest.submit(user, login, address, request,session);

		happyPath_verify();

		assertEquals("redirect:/myProfile", result);
	}

	@Test
	public void testSubmit_pictureIsEmpty() {
		user.setPicture(picture);

		happyPath_when();
		when(picture.isEmpty()).thenReturn(true);

		String result = underTest.submit(user, login, address, request, session);

		happyPath_verify();
		verify(picture).isEmpty();

		assertEquals("redirect:/myProfile", result);
	}

	@Test
	public void testSubmit_pictureSuccess() {
		user.setPicture(picture);

		happyPath_when();
		when(picture.isEmpty()).thenReturn(false);

		String result = underTest.submit(user, login, address, request, session);

		happyPath_verify();
		verify(picture).isEmpty();

		assertEquals("redirect:/myProfile", result);
	}
	
	@Test
	public void testcallEditUserForm() {
		user.setPicture(null);

		
		String result = underTest.callEditUserForm(user.getUser_id(), model);

	    address = registrationService.getAddress(address.getAddress_id());
		assertEquals("update-user-info-form", result);
	}
	
	

	public void testcallUpdateAddressInfoForm() {
		user.setPicture(null);

		
		String result = underTest.callUpdateAddressInfoForm(user,address, model, session);

	    address = registrationService.getAddress(address.getAddress_id());
		assertEquals("user-profile", result);
	}
	
	public void  testshowUserProfile() {
		user.setPicture(null);

		
		String result = underTest.showUserProfile(address,user, model, session);

		user = registrationService.getByEmail(login.getLogin_id());
		address = registrationService.getAddressofUser(user.getUser_id());
		assertEquals("user-profile", result);
	}
	
	public void  testcallUpdateUserInfoForm() {
		user.setPicture(null);

		
		String result = underTest.callUpdateUserInfoForm(user, model, session);

	    address = registrationService.getAddress(address.getAddress_id());
		assertEquals("user-profile", result);
	}
	
	public void  testcallEditUserAddressForm() {
		user.setPicture(null);

		
		String result = underTest.callEditUserAddressForm(address.getAddress_id(),model);

		address = registrationService.getAddress(address.getAddress_id());
		assertEquals("update-user-address-form", result);
	}

}

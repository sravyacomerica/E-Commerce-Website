package unt.cse.studentsurplus.controller;

/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import unt.cse.studentsurplus.dao.LoginDAO;
import unt.cse.studentsurplus.dao.ProductPostingDAO;
import unt.cse.studentsurplus.model.Email;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.MailSenderService;
import unt.cse.studentsurplus.service.ProductPostingService;
import unt.cse.studentsurplus.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class ProductOrderControllerTest {

	@Mock
	HttpSession session;

	@Mock
	Model model;

	@Mock
	ProductPostingDAO ppDao;

	@Mock
	LoginDAO logDao;

	@Mock
	MailSenderService mailSenderService;

	@Mock
	ProductPostingService productPostingService;

	@Mock
	RegistrationService regService;

	@Mock
	ProductPostingService ppService;

	@Mock
	Product productMock;

	@Mock
	Email emailMock;

	@InjectMocks
	ProductOrderController poController;

	private String login_id;
	private LoginCredential lc;
	private Product product;

	@Before
	public void setUp() throws Exception {
		login_id = "nick@gma.com";

		lc = new LoginCredential();
		lc.setLogin_id(login_id);
		lc.setUid(1);

		product = new Product();
		product.setUserId(2);
		product.setProductId(1);
		product.setIsAvailable(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToCart() {
		/*
		 * List<Integer> cart = null;
		 * 
		 * List<Product> cartProductList = new ArrayList<>();
		 * 
		 * Product pdt = new Product();
		 * 
		 * when(session.getAttribute("cart")).thenReturn(cart);
		 * when(poController.getProductsFromCart(cart, session)).thenReturn(null);
		 */
	}

	@Test
	public void testGetSellerOfProduct() {
		User user = new User();
		user.setUser_id(2);
		when(ppService.getProduct(1)).thenReturn(product);
		when(regService.getUser(2)).thenReturn(user);
		assertEquals(poController.getSellerOfProduct(1).getUser_id(), user.getUser_id());
		verify(ppService).getProduct(1);
		verify(regService).getUser(2);
	}

	@Test
	public void testGetCurrentSessionUser() {
		User user = new User();
		user.setUser_id(2);
		user.setEmail("hello");
		when(session.getAttribute("login_id")).thenReturn("hello");
		when(regService.getByEmail("hello")).thenReturn(user);

		assertEquals(poController.getCurrentSessionUser(session).getEmail(), user.getEmail());

		verify(session).getAttribute("login_id");
		verify(regService).getByEmail("hello");
	}

	@Test
	public void testGetProductsFromCart() {
		List<Integer> cart = new ArrayList<>();
		cart.add(0);
		cart.add(1);

		when(ppService.getProduct(anyInt())).thenReturn(productMock);
		when(productMock.getIsAvailable()).thenReturn(0, 1);

		List<Product> result = poController.getProductsFromCart(cart, session);

		verify(ppService, times(2)).getProduct(anyInt());
		verify(productMock, times(2)).getIsAvailable();

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	public void testcallSendEmail() {
		String result = poController.callSendEmail(1, emailMock, model, session);
		productPostingService.getProduct(1);
		assertEquals("send-email", result);
	}

	@Test
	public void testSendEmail() {
		String result = poController.SendEmail(emailMock, model, session);
		mailSenderService.sendMail("sravya@gmail.com", "hi", "text");
		assertEquals("email-sent", result);
	}

	@Test
	public void testshowCart() {
		String result = poController.showCart(model, session);
		assertEquals("cart", result);
	}

	@Test
	public void testremoveFromCart() {
		String result = poController.removeFromCart(1, model, session);
		assertEquals("redirect:/viewWishList", result);
	}

}

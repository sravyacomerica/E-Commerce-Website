package unt.cse.studentsurplus.controller;
/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.Search;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.ProductPostingService;
import unt.cse.studentsurplus.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class ProductPostingControllerTest {

	@Mock
	Model model;
	
	@Mock
	ProductPostingService ppService;
	
	@Mock
	RegistrationService regService;
	
	@Mock
	HttpSession session;
	
	
	@InjectMocks
	ProductPostingController ppController;
	
	private Product product;
	private List<Product> list;
	private User user;
	private Search search;
	
	@Before
	public void setUp() throws Exception {
		product = new Product();
		product.setCategory("Furniture");
		product.setDescription("second-hand chair");
		product.setImageName("chair");
		product.setIsAvailable(1);
		product.setMonthsUsed(5);
		product.setNegotiable("yes");
		product.setPicture(null);
		product.setProductId(0);
		product.setPrice(new BigDecimal(100));
		product.setUserId(1);
		product.setName("chair");
		
		list = new ArrayList<Product>();
		list.add(product);
		
		user = new User();
		user.setUser_id(1);
		
		search = new Search();
		search.setSearchString("chair");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowPostProductForm() {
		ModelMap mm = new ModelMap();
		assertEquals("post-product", ppController.showPostProductForm(mm));
	}

	@Test
	public void testSaveProduct() {
		
	}

	@Test
	public void testShowProductDetail() {
		int productId = 0;
		
		when(ppService.getProduct(productId)).thenReturn(product);
		String result = ppController.showProductDetail(productId, model);
		verify(ppService).getProduct(productId);
		
		assertEquals("product-detail", result);
	}

	@Test
	public void testShowUpdateProductForm() {
		int productId = 1;
		
		when(ppService.getProduct(productId)).thenReturn(product);
		String result = ppController.showProductDetail(productId, model);
		verify(ppService).getProduct(productId);
		
	//	assertEquals("update-product", result);
	}

	@Test
	public void testShowAllProductsPostedByUser() {
		when(ppController.getCurrentSessionUser(session)).thenReturn(user);
		when(ppService.getAllProductsByOwner(1)).thenReturn(list);
		String result = ppController.showAllProductsPostedByUser(model, session);
		assertEquals("my-product-details", result);
	}

	@Test
	public void testShowHome() {
		ModelAndView mv = new ModelAndView();
		when(ppService.getAvailableProducts()).thenReturn(list);
		ModelAndView result = ppController.showHome(search, mv);
		assertEquals("home", result.getViewName());
	}

	@Test
	public void testShowSearchProductResult() {
		String result = ppController.showSearchedProduct(search, model);
        
		list = ppService.getProductsBySearchString(search.getSearchString());
		assertEquals("home-after-search", result);
	}

	@Test
	public void testShowSearchedProduct() {

		String result = ppController.showSearchedProduct(search, model);
              
		list = ppService.getProductsBySearchString(search.getSearchString());
		assertEquals("home-after-search", result);

	}

	@Test
	public void testShowSearchedProducts() {
		
		String result = ppController.showSearchedProducts(search, model);
        

		assertEquals("home-after-search", result);
	}

	@Test
	public void testshowSearchedProductAfterLogin() {
		String result = ppController.showSearchedProduct(search, model);
        
		list = ppService.getProductsBySearchString(search.getSearchString());
		assertEquals("home-after-search", result);
	}
	@Test
	public void testshowSearchedProductsAfterLogin() {
    String result = ppController.showSearchedProducts(search, model);
        

		assertEquals("home-after-search", result);
	}

	@Test
	public void testShowSoldProductsPostedByUser() {
		 String result = ppController.showSoldProductsPostedByUser( model, session);
		list = ppService.getSoldProductsByOwner(user.getUser_id());
		assertEquals("redirect:/home-after-login", result);

	}
	
	@Test
	public void testshowavailableProductsPostedByUser() {
		String result = ppController.showavailableProductsPostedByUser( model, session);
		list = ppService.getAvailableProductsByOwner(user.getUser_id());
		assertEquals("redirect:/home-after-login", result);
		
	}


}

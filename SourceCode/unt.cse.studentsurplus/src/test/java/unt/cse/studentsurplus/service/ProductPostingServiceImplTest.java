package unt.cse.studentsurplus.service;

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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import unt.cse.studentsurplus.dao.ProductPostingDAO;
import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;
import unt.cse.studentsurplus.model.Search;

@RunWith(MockitoJUnitRunner.class)
public class ProductPostingServiceImplTest {

	@Mock
	ProductPostingDAO ppDao;

	@InjectMocks
	ProductPostingServiceImpl ppService;

	private Product product;
	private List<Product> list;
	private ProductImage pImage;
	private List<ProductImage> listImages;

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

		pImage = new ProductImage();
		pImage.setImageId(0);
		pImage.setProductId(0);
		pImage.setImageName("chair");

		listImages = new ArrayList<ProductImage>();
		listImages.add(pImage);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddProduct() {
		when(ppDao.addProduct(product)).thenReturn(true);
		boolean result = ppService.addProduct(product);
		verify(ppDao).addProduct(product);

		assertEquals(true, result);
	}

	@Test
	public void testGetAvailableProducts() {
		when(ppDao.getAvailableProducts()).thenReturn(list);

		assertEquals(list, ppService.getAvailableProducts());

		verify(ppDao).getAvailableProducts();
	}

	@Test
	public void testGetProduct() {
		when(ppDao.getProduct(0)).thenReturn(product);

		assertEquals(product, ppService.getProduct(0));

		verify(ppDao).getProduct(0);
	}

	@Test
	public void testGetAvailableProductsByOwner() {
		when(ppDao.getAvailableProductsByOwner(1)).thenReturn(list);
		when(ppService.setProductsImage(list)).thenReturn(list);

		assertEquals(list, ppService.getAvailableProductsByOwner(1));

		verify(ppDao).getAvailableProductsByOwner(1);
	}

	@Test
	public void testGetProductImages() {
		when(ppDao.getProductImages(0)).thenReturn(listImages);

		assertEquals(listImages, ppService.getProductImages(0));

		verify(ppDao).getProductImages(0);
	}

	@Test
	public void testAddProductImage() {
		when(ppDao.addProductImage(pImage)).thenReturn(true);

		assertEquals(true, ppService.addProductImage(pImage));

		verify(ppDao).addProductImage(pImage);
	}

	@Test
	public void testGetSoldProductsByOwner() {
		List<Product> newList = new ArrayList<Product>();
		Product p = product;
		p.setIsAvailable(0);
		newList.add(p);
		when(ppDao.getSoldProductsByOwner(1)).thenReturn(newList);
		when(ppService.setProductsImage(newList)).thenReturn(newList);

		assertEquals(newList, ppService.getSoldProductsByOwner(1));

		verify(ppDao).getSoldProductsByOwner(1);
	}

	@Test
	public void testGetAllProductsByOwner() {
		when(ppDao.getAllProductsByOwner(1)).thenReturn(list);
		when(ppService.setProductsImage(list)).thenReturn(list);

		assertEquals(list, ppService.getAllProductsByOwner(1));

		verify(ppDao).getAllProductsByOwner(1);
	}

	@Test
	public void testGetProductsBySearchString() {
		String searchString = "chair";
		when(ppDao.getProductsBySearchString(searchString)).thenReturn(list);
		when(ppService.setProductsImage(list)).thenReturn(list);

		assertEquals(list, ppService.getProductsBySearchString(searchString));

		verify(ppDao).getProductsBySearchString(searchString);
	}

	@Test
	public void testSetProductsImage() {

	}

}

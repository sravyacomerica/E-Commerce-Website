package unt.cse.studentsurplus.controller;
/**
 * @author Aboubakar Mountapmbeme
 *
 *         
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;
import unt.cse.studentsurplus.model.Search;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.ProductPostingService;
import unt.cse.studentsurplus.service.RegistrationService;

@Controller
public class ProductPostingController {

	@Autowired
	private ProductPostingService productPostingService;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	FileUploadHelper fileUploadHelper;

	@RequestMapping("/postProductForm")
	public String showPostProductForm(ModelMap modelMap) {

		Product prod = new Product();

		modelMap.addAttribute("Product", prod);

		return "post-product";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Product") Product product, HttpSession httpSession,
			HttpServletRequest request) {

		String email = (String) httpSession.getAttribute("login_id");
		User user = registrationService.getByEmail(email);
		product.setUserId(user.getUser_id());
		product.setIsAvailable(1);
		// product.setCategory("catplaceholder");
		// product.setNegotiable("no");
		System.out.println("DASH: Product: " + product.toString());
		boolean val = false;
		try {
			val = productPostingService.addProduct(product);
		} catch (Exception e) {

			System.out.println("DASH: Exception adding caught");
			return "post-product";
		}

		if (val) {
			System.out.println("DASH: product added successfully");
			String imgName = "img" + product.getProductId() + product.getUserId();
			// saving product picture
			if (product.getPicture() != null && !product.getPicture().isEmpty()) {
				System.out.println("\nDASH:Picture is available\n");

				val = fileUploadHelper.uploadProductPicture(request, product.getPicture(), imgName);

				if (val) {
					ProductImage img = new ProductImage();

					img.setProductId(product.getProductId());
					img.setImageName(imgName);

					val = productPostingService.addProductImage(img);

					if (val) {
						System.out.println("DASH: pdt image added successfully");
					} else {
						System.out.println("DASH: pdt image add failed");
					}
				} else {
					System.out.println("DASH: Error writing image to file: img null or empty");
				}

			} else {
				System.out.println("DASH: image is null or empty");
			}

		} else {
			System.out.println("DASH: product add failed");

			return "post-product";
		}

		System.out.println("DASH: Success adding pdt and image");
		return "posting-success";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "email-sent";
		
	}
	
	/**
	 * removes a product posted by the user. after executing this function, product will not appear on 
	 * home page or search results. 
	 * @param pid
	 * @return
	 */
	
	@RequestMapping(value = "/removeProduct/{id}", method = RequestMethod.GET)
	public String removeProduct(@PathVariable("id") int pid) {
		
		Product prod = productPostingService.getProduct(pid);
		
		prod.setIsAvailable(0);
		
		
		boolean val = false;
		try {
			val = productPostingService.addProduct(prod);
		} catch (Exception e) {

			System.out.println("DASH: Exception updating product in remove function caught");
			return "redirect:/my-product-details";
		}
		
		//debug
		
		System.out.println("DASH: product removed successfully");
		
		return "redirect:/allProductsByUser";
		
	}
	
	

	/*
	 * 
	 * Returns a product with full details to be shown on view
	 */
	@RequestMapping(value = "/productDetail/{id}", method= RequestMethod.GET)
	public String showProductDetail(@PathVariable("id") int pid, Model model) {

		System.out.println(pid);
		Product prod = productPostingService.getProduct(pid);
		List<Product> DetailList = new ArrayList();
		DetailList.add(prod);
        
		// debug
		System.out.println(prod);

		model.addAttribute("product", DetailList);

		return "product-detail";
	}

	/*
	 * 
	 * productId param passed from view via link
	 * 
	 * call form with product to be updated
	 */

	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.GET)
	public String showUpdateProductForm(@PathVariable("id") int pid, Model model) {

		Product prod = productPostingService.getProduct(pid);

		// debug
		// System.out.println(prod);

		model.addAttribute("Product", prod);

		return "update-product";
	}

	/*
	 * returns all the products posted by a user for display in view
	 */

	@RequestMapping("/allProductsByUser")
	public String showAllProductsPostedByUser(Model model, HttpSession httpSession) {
		List<Product> productList = new ArrayList();

		User user = getCurrentSessionUser(httpSession);

		try {
			productList = productPostingService.getAvailableProductsByOwner(user.getUser_id());

			/*
			  debugg // just to print on console and make sure list is returned in order
			  int i = 1;
			 
			  for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			  i++; }
			 */

		} catch (Exception e) {

			return "home-after-login";
		}

		model.addAttribute("productList", productList);
		return "my-product-details";
	}

	
	/*
	 * searches the products table to find products whose name or description match with searchString
	 * returns the list of product to be displayed in the view
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome(@ModelAttribute("Search") Search searchString, ModelAndView model) {
		
		List<Product> availableProducts = productPostingService.getAvailableProducts();
		/*debugg
		// just to print on console and make sure list is returned in order
		int i = 1;
		
		for(Product pdt : availableProducts) {
			System.out.println("DASH: " +  " :" + pdt);
			i++;
		}
		*/
		
		
		model.addObject("productList", availableProducts);
		model.setViewName("home");
		return model;
	}
	
	@PostMapping("/home")
	public String showSearchProductResult(@ModelAttribute("Search") Search searchString, Model model) {
		List<Product> productList = new ArrayList();


		try {
			productList = productPostingService.getProductsBySearchString(searchString.getSearchString());
             
			
			// just to print on console and make sure list is returned in order
			  int i = 1;
			 
			 for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			  i++; }
			

		} catch (Exception e) {

			System.out.println("failed!");
			return "redirect:/home";
		}

		model.addAttribute("productList", productList);

		return "home-after-search";
	}

	@PostMapping("/home-after-search")
	public String showSearchedProduct(@ModelAttribute("Search") Search searchString, Model model){

		List<Product> productList = new ArrayList();


		try {
			productList = productPostingService.getProductsBySearchString(searchString.getSearchString());
             
			
			// just to print on console and make sure list is returned in order
			  int i = 1;
			 
			 for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			  i++; }
			

		} catch (Exception e) {

			System.out.println("failed!");
			return "redirect:/home";
		}

		model.addAttribute("productList", productList);

		return "home-after-search";
	}
	
	@RequestMapping("/home-after-search")
	public String showSearchedProducts(@ModelAttribute("Search") Search searchString, Model model){
		
		return "home-after-search";
	}
	
	@PostMapping("/home-after-login")
	public String showSearchProductResultAfterLogin(@ModelAttribute("Search") Search searchString, Model model) {
		List<Product> productList = new ArrayList();


		try {
			productList = productPostingService.getProductsBySearchString(searchString.getSearchString());
             
			
			// just to print on console and make sure list is returned in order
			  int i = 1;
			 
			 for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			  i++; }
			

		} catch (Exception e) {

			System.out.println("failed!");
			return "redirect:/home";
		}

		model.addAttribute("productList", productList);

		return "home-after-login-search";
	}

	@PostMapping("/home-after-login-search")
	public String showSearchedProductAfterLogin(@ModelAttribute("Search") Search searchString, Model model){

		List<Product> productList = new ArrayList();


		try {
			productList = productPostingService.getProductsBySearchString(searchString.getSearchString());
             
			
			// just to print on console and make sure list is returned in order
			  int i = 1;
			 
			 for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			  i++; }
			

		} catch (Exception e) {

			System.out.println("failed!");
			return "redirect:/home";
		}

		model.addAttribute("productList", productList);

		return "home-after-login-search";
	}
	
	@RequestMapping("/home-after-login-search")
	public String showSearchedProductsAfterLogin(@ModelAttribute("Search") Search searchString, Model model){
		
		return "home-after-login-search";
	}
	/*
	 * returns available to buy products posted by a user for display in view
	 */

	@RequestMapping("/availableProductsByUser")
	public String showavailableProductsPostedByUser(Model model, HttpSession httpSession) {
		List<Product> productList = new ArrayList();

		User user = getCurrentSessionUser(httpSession);

		try {
			productList = productPostingService.getAvailableProductsByOwner(user.getUser_id());

			/*
			 * // just to print on console and make sure list is returned in order int i =
			 * 1;
			 * 
			 * for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			 * i++; }
			 */

		} catch (Exception e) {

			return "redirect:/home-after-login";
		}

		model.addAttribute("productList", productList);
		return "available-product-user";
	}

	/*
	 * returns only sold products of a user for show in view
	 */

	@RequestMapping("/soldProductsByUser")
	public String showSoldProductsPostedByUser(Model model, HttpSession httpSession) {
		List<Product> productList = new ArrayList();

		User user = getCurrentSessionUser(httpSession);

		try {
			productList = productPostingService.getSoldProductsByOwner(user.getUser_id());

			/*
			 * debugg // just to print on console and make sure list is returned in order
			 * int i = 1;
			 * 
			 * for(Product pdt : productList) { System.out.println("DASH: " + " :" + pdt);
			 * i++; }
			 */

		} catch (Exception e) {

			return "redirect:/home-after-login";
		}

		model.addAttribute("productList", productList);
		return "sold-product-user";
	}

	/*
	 * get the user of the current session from email
	 */
	public User getCurrentSessionUser(HttpSession httpSession) {

		String email = (String) httpSession.getAttribute("login_id");
		User user = registrationService.getByEmail(email);

		return user;
	}

	// this is just a dummy method to test the productPostingService methods
	/*
	 * @RequestMapping("test") public String callMethods() {
	 * 
	 * System.out.println(""); Product p = new Product();
	 * 
	 * p.setName("jacket"); p.setCategory("cloth"); p.setPrice(new BigDecimal("0"));
	 * p.setMonthsUsed(6); p.setUserId(1);
	 * p.setDescription("still testing addd product"); p.setIsAvailable(1);
	 * p.setNegotiable("no"); boolean val = productPostingService.addProduct(p);
	 * 
	 * if(val) { System.out.println("DASH: product added successfully");
	 * ProductImage img = new ProductImage();
	 * 
	 * img.setProductId(p.getProductId()); img.setImageName("img" + p.getProductId()
	 * + p.getUserId());
	 * 
	 * val = productPostingService.addProductImage(img);
	 * 
	 * if(val) { System.out.println("DASH: pdt image added successfully"); } else {
	 * System.out.println("DASH: pdt image add failed"); }
	 * 
	 * 
	 * } else { System.out.println("DASH: product add failed"); }
	 * 
	 * 
	 * 
	 * return "test"; }
	 */
}

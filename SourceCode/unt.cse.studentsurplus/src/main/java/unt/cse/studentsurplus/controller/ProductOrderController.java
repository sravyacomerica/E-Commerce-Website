package unt.cse.studentsurplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.dao.LoginDAO;
import unt.cse.studentsurplus.dao.ProductPostingDAO;
import unt.cse.studentsurplus.model.Email;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.MailSenderService;
import unt.cse.studentsurplus.service.ProductPostingService;
import unt.cse.studentsurplus.service.RegistrationService;

/**
 * 
 * @author haidi chen component: ProductOrderController purpose: deal with
 *         transactions related to orders
 *
 */

@Controller
public class ProductOrderController {

	@Autowired
	MailSenderService mailSenderService;

	@Autowired
	ProductPostingDAO ppDao;

	@Autowired
	LoginDAO logDao;

	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private ProductPostingService productPostingService;

	/**
	 * Handles adding a product into the shopping cart of the current user Creates
	 * an array that contains the productIds of the items selected by the user array
	 * is keep a session variable generates a list of product objects added to the
	 * car so far and adds this list to the model
	 * 
	 * @param pid
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") int pid, Model model, HttpSession session) {
		List<Integer> cart = null; // array holds the id of products added to cart

		List<Product> cartProductList = new ArrayList<>();
		Product pdt = new Product();

		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
		} else {
			cart = (ArrayList<Integer>) session.getAttribute("cart");
		}

		if (!(cart.contains(pid))) {

			cart.add(pid);
		}

		session.setAttribute("cart", cart);

		cartProductList = this.getProductsFromCart(cart, session);

		model.addAttribute("cartProductList", cartProductList);

		System.out.println("DASH: added to cart");

		return "cart";

	}

	/**
	 * pass the list of products in the shopping cart for display generates a list
	 * of product objects added to the cart and adds this list to the model
	 * 
	 */

	@RequestMapping(value = "/viewWishList", method = RequestMethod.GET)
	public String showCart(Model model, HttpSession session) {

		List<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
		List<Product> cartProductList = new ArrayList<>();

		try {
			cartProductList = this.getProductsFromCart(cart, session);

			model.addAttribute("cartProductList", cartProductList);

			return "cart";
		}

		catch (Exception e) {
			return "cart-empty";
		}
	}

	/**
	 * Removes an element from the shopping cart generates new list of products in
	 * cart and adds to model
	 * 
	 * @param pid
	 * @param session
	 */
	@RequestMapping(value = "/removeFromWishList/{id}", method = RequestMethod.GET)
	public String removeFromCart(@PathVariable("id") int pid, Model model, HttpSession session) {

		List<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
		List<Product> cartProductList = new ArrayList<>();

		if (cart.contains(pid)) {

			int i = cart.indexOf(pid);

			cart.remove(i);
		}
		session.setAttribute("cart", cart);

		cartProductList = this.getProductsFromCart(cart, session);

		model.addAttribute("cartProductList", cartProductList);

		return "redirect:/viewWishList";
	}

	/**
	 * this function should be called when user clicks on send message on a products
	 * creates model attributes for seller email, buyer email and product to buy and
	 * sends to the view
	 * 
	 * @param pid
	 * @param model
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "/sendEmail/{id}", method = RequestMethod.GET)
	public String callSendEmail(@PathVariable("id") int pid, @ModelAttribute("Email") Email email, Model model,
			HttpSession session) {
		Product prod = productPostingService.getProduct(pid);

		User buyer = this.getCurrentSessionUser(session);
		String buyerEmail = buyer.getEmail();
		User seller = this.getSellerOfProduct(pid);
		String sellerEmail = seller.getEmail();
		session.setAttribute("buyeremail", buyerEmail);
		session.setAttribute("sellerEmail", sellerEmail);
		model.addAttribute("Email", new Email());
		return "send-email";
	}

	@RequestMapping(value = "/sendEmail/{id}", method = RequestMethod.POST)
	public String SendEmail(@ModelAttribute("Email") Email email, Model model, HttpSession session) {

		String text = email.getText();
		String sellerEmail = (String) session.getAttribute("sellerEmail");
		String buyeremail = (String) session.getAttribute("buyeremail");
		String subject = "Notification regarding your product on Student Surplus";
		String modified_text = "Greetings,\n"
				+ "We hope you are doing well, This email is to inform you that there is a customer who is interested in your product and is trying to reach you, Below is the message from the user.\n "
				+ "Message: \"" + text + "\"\n"

				+ "If you are intrested in selling the product to the customer please contact him/her at \n" + "Email: "
				+ buyeremail
				+ " \n If the product is already sold, please set it's status to sold on our site to avoid getting further emails regarding this product."
				+ "\nWe hope you have a great day! \n\n\n Thanks,\n Team Student Surplus.";
		mailSenderService.sendMail(sellerEmail, subject, modified_text);

		return "email-sent";
	}

	/**
	 * Handles checkout by user get the list of products in the cart and creates
	 * order for each product sends email to each product owner and the buyer of the
	 * product
	 * 
	 * @param session
	 * @return
	 */

	/**
	 * returns the list of all product objects in the cart
	 * 
	 * @param cart
	 * @return
	 */
	public List<Product> getProductsFromCart(List<Integer> cart, HttpSession session) {
		List<Product> cartProducts = new ArrayList<>();
		Product pdt = new Product();
		List<Integer> removedItems = new ArrayList<>();

		for (Integer pid : cart) {
			pdt = productPostingService.getProduct(pid);

			if (pdt.getIsAvailable() == 1) { // add product to cart only if it is still available
				cartProducts.add(pdt);
			} else {

				removedItems.add(pid);

			}

			System.out.println("DASH: " + pdt);
		}

		for (Integer p : removedItems) {
			int i = cart.indexOf(p);
			cart.remove(i);
		}

		session.setAttribute("cart", cart);

		return cartProducts;
	}

	/*
	 * get the user of the current session from email
	 */
	public User getCurrentSessionUser(HttpSession httpSession) {

		String email = (String) httpSession.getAttribute("login_id");
		User user = registrationService.getByEmail(email);

		return user;
	}

	/**
	 * helper get user who posted a product
	 * 
	 */

	public User getSellerOfProduct(int productId) {
		Product prod = productPostingService.getProduct(productId);
		User seller = registrationService.getUser(prod.getUserId());

		return seller;
	}

}

package unt.cse.studentsurplus.controller;
/**
 * @author Haidi Chen
 *
 *         
 */
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.dao.LoginDAO;
import unt.cse.studentsurplus.dao.RegistrationDAO;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.Search;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.LoginService;
import unt.cse.studentsurplus.service.ProductPostingService;
import unt.cse.studentsurplus.service.RegistrationService;

@Controller
public class LoginController {

	private static final Object NULL = null;
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private ProductPostingService productPostingService;
	
	@Autowired
	LoginDAO loginDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		LoginCredential lc = new LoginCredential();
		model.addObject("login",lc);
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/home-after-login", method = RequestMethod.GET)
	public ModelAndView afterlogin(@ModelAttribute("Search") Search searchString,ModelAndView model) {
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
		model.setViewName("home-after-login-search");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@ModelAttribute("login") LoginCredential login, ModelAndView model, HttpSession session) {
		session.setAttribute("login_id", null);
		session.setAttribute("name",null);
		session.setAttribute("cart", new ArrayList<>());
		return "login";
	}
	
	@RequestMapping(value = "/login_do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCredential login, ModelMap model, HttpSession session) {
		Boolean t =  loginService.findUser(login.getLogin_id(), login.getPassword());
		if (t) {
			try {
				User user = new User();
				LoginCredential lc = loginDao.getLoginCredential(login.getLogin_id());
				session.setAttribute("login_id", login.getLogin_id());
				user = registrationService.getUser(lc.getUid());
				session.setAttribute("name",user.getFirst_name());
				return "redirect:/home-after-login";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return "redirect:/home-after-login";
		}
		else {
			try {
				session.setAttribute("errorMessage", "Invalid Username or Password");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return "login";
		}
		
	}

}
package unt.cse.studentsurplus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;
import unt.cse.studentsurplus.service.RegistrationService;

/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 *         Creates Mapping registration form and edit user form
 */

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	FileUploadHelper fileUploadHelper;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("logincred", new LoginCredential());
		model.addAttribute("address", new Address());
		return "user-registration-form";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String submit(@ModelAttribute("user") User user, @ModelAttribute("logincred") LoginCredential login,
			@ModelAttribute("address") Address address, HttpServletRequest request, HttpSession session) {

		try {
		boolean result = registrationService.add(user);
		if (result == false) {
			session.setAttribute("Msg", "Email Already Exists!");
			return "user-registration-form";
		} else if (result == true) {
			login.setLogin_id(user.getEmail());
			login.setUid(user.getUser_id());
			registrationService.addLogin_Cred(login);
			session.setAttribute("Error_message", "");
			address.setUser_id(user.getUser_id());
			registrationService.addAddress(address);
			session.setAttribute("login_id", login.getLogin_id());
			// saving profile picture
			if (user.getPicture() != null && !user.getPicture().isEmpty()) {
				System.out.println("\nDASH:Picture is available\n");
				fileUploadHelper.uploadPicture(request, user.getPicture(), user.getUser_id());
				return "registration-success";
			}
		}
		}
		catch(Exception e) {
		System.out.println("\nDASH: Picture is not available + Picture name: " + user.getPicture() + "\n");
		session.setAttribute("Error_message", "Email already exists!");
		return "user-registration-form";
		}
		session.setAttribute("Error_message", "");
		return "registration-success";
	}

	// call update user info form
	@PostMapping("/editUserForm")
	public String callEditUserForm(@RequestParam("userId") int userId, Model model) {

		User user = registrationService.getUser(userId);
		model.addAttribute("user", user);

		return "update-user-info-form";
	}

	// call update user address form
	@PostMapping("/editUserAddressForm")
	public String callEditUserAddressForm(@RequestParam("addressId") int addressId, Model model) {

		Address address = registrationService.getAddress(addressId);

		model.addAttribute("address", address);

		return "update-user-address-form";
	}

	// call user profile view page
	@RequestMapping("/myProfile")
	public String showUserProfile(@ModelAttribute("address") Address address, @ModelAttribute("user") User user,
			Model model, HttpSession session) {

		String email = (String) session.getAttribute("login_id");
		System.out.println(email);
		user = registrationService.getByEmail(email);
		address = registrationService.getAddressofUser(user.getUser_id());
		model.addAttribute("address", address);
		model.addAttribute("user", user);
		return "user-profile";
	}

	@PostMapping("/updateUserInfo")
	public String callUpdateUserInfoForm(@ModelAttribute("user") User user1, Model model, HttpSession session) {
		String email = (String) session.getAttribute("login_id");
		User user = registrationService.getByEmail(email);
		user1.setUser_id(user.getUser_id());
		user1 = registrationService.edit(user1);
		Address address = registrationService.getAddressofUser(user1.getUser_id());
		model.addAttribute("address", address);
		model.addAttribute("user", user);
		return "redirect:/myProfile";
	}

	@PostMapping("/updateAddress")
	public String callUpdateAddressInfoForm(@ModelAttribute("user") User user,
			@ModelAttribute("address") Address address, Model model, HttpSession session) {
		String email = (String) session.getAttribute("login_id");
		user = registrationService.getByEmail(email);
		address.setUser_id(user.getUser_id());
		address = registrationService.editAddress(address);
		model.addAttribute("address", address);
		model.addAttribute("user", user);
		return "user-profile";
	}

}

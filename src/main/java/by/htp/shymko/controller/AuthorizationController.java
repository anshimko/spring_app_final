package by.htp.shymko.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.shymko.entity.Customer;
import by.htp.shymko.service.CustomerService;

@Controller
public class AuthorizationController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String showLogin() {
		return "redirect:/login";
	}

	@GetMapping("/sign_up")
	public String getSignUp(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "sign_up";
	}

	@PostMapping("/sign_up")
	public String signUp(@ModelAttribute @Valid Customer theCustomer, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "sign_up";
		} else {
			customerService.saveCustomer(theCustomer);
			return "redirect:/customer/list/1";
		}
	}

	@GetMapping("/login")
	public String login(@RequestParam(name = "error", required = false) Boolean error, Model model) {
		if (Boolean.TRUE.equals(error)) {
			model.addAttribute("error", true);
		}
		return "sign_in";
	}

}

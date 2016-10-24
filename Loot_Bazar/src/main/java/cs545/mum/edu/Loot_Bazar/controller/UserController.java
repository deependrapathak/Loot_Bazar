package cs545.mum.edu.Loot_Bazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs545.mum.edu.Loot_Bazar.model.Customer;
import cs545.mum.edu.Loot_Bazar.model.Role;
import cs545.mum.edu.Loot_Bazar.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String signUp(@ModelAttribute("user") Customer customer){
		return "signUp";
	}
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String afterSignUp(@ModelAttribute("user") Customer customer,RedirectAttributes redirectAttributes,BindingResult result ){
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if(result.hasErrors()){
			return "signUp";
		}
		userService.save(customer);
		redirectAttributes.addFlashAttribute("customer",customer);
		return "redirect:/index";
	}

}

package cs545.mum.edu.Loot_Bazar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
 		return "redirect:/index";
 	}
}

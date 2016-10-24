package cs545.mum.edu.Loot_Bazar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value={"/","/index"})
	public String welcome(){
		return "welcome";
	}
	
	@RequestMapping(value="/signUp")
	public String signUp(){
		return "signUp";
	}
}

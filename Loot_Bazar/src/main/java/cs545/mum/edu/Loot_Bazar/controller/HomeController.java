package cs545.mum.edu.Loot_Bazar.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	@RequestMapping(value={"/","/index"})
	public String welcome(Model model){
		List<Product> productList= productService.getAll();
 		model.addAttribute("products", productList);
		return "welcome";
	}
	
	@RequestMapping(value="/signUp")
	public String signUp(){
		return "signUp";
	}
	@RequestMapping(value="/thankYou")
	public String thankYou(){
		return "thankYou";
	}
	
}

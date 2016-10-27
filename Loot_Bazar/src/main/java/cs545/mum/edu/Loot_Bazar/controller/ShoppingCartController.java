package cs545.mum.edu.Loot_Bazar.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.model.ShoppingCart;
import cs545.mum.edu.Loot_Bazar.service.OrderDetailsService;
import cs545.mum.edu.Loot_Bazar.service.ProductService;
import cs545.mum.edu.Loot_Bazar.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;
	
	
	@RequestMapping(value= "/cartList", method= RequestMethod.GET)
	public String getCartList(Model model){
		List<ShoppingCart> shoppingCart = shoppingCartService.getAll();
		model.addAttribute("shoppingCarts", shoppingCart);
		//model.addAttribute("shoppingCart", shoppingCartService.findByTotalPrice());
		double totalPrice = shoppingCartService.findTotalCharCost(shoppingCart);
		model.addAttribute("totalPrice", totalPrice);
		return "cartList";
	}
	
	@RequestMapping(value = "/addShoppingCart/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCart(@PathVariable Long productId) {
		 
		shoppingCartService.saveShoppingCart(productId);
		 
	}
	
	@RequestMapping(value = "/removeShoppingCart/{shoppingCartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCart(@PathVariable Long shoppingCartId ) {
		System.out.println(shoppingCartId);
		ShoppingCart shoppingCart =shoppingCartService.getById(shoppingCartId);
		//Long orderDetailsId = shoppingCart.getOrderDetails().getId();
		
		shoppingCartService.deletShoppingCart(shoppingCart);
		 
	}
	

	@RequestMapping(value = "/removeAllShoppingCart", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCart( ) {
		 
		shoppingCartService.deletAllChart();
	}
	
	 
}

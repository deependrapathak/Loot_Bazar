package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.ShoppingCart;

public interface ShoppingCartService {
	public ShoppingCart getById(Long Id);
	public List<ShoppingCart> getAll();
	public void saveShoppingCart(Long productId);
	public void deletShoppingCart(ShoppingCart shoppingCart);
	public ShoppingCart findByTotalPrice();
	public ShoppingCart findByOrderId(Long id);
	
	public void deletAllChart();
	public double findTotalCharCost(List<ShoppingCart> shoppingCarts);
}

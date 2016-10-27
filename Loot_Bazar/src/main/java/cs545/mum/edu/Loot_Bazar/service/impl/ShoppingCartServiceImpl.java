package cs545.mum.edu.Loot_Bazar.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.model.ShoppingCart;
import cs545.mum.edu.Loot_Bazar.repository.OrderDetailsRepository;
import cs545.mum.edu.Loot_Bazar.repository.ProductRepository;
import cs545.mum.edu.Loot_Bazar.repository.ShoppingCartRepository;
import cs545.mum.edu.Loot_Bazar.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired 
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	@Autowired
	ProductRepository productRepository;
	
 
	public ShoppingCart getById(Long Id) {
		 
		return shoppingCartRepository.findOne(Id);
		 
	}

	public List<ShoppingCart> getAll() {
		 
		return (List<ShoppingCart>) shoppingCartRepository.findAll();
	}
	 
	public void saveShoppingCart(Long productId) {
		 
		 Product product = productRepository.findOne(productId);
		 OrderDetails odr =orderDetailsRepository.findByProductId(productId);
		 if(odr!=null){
			 odr.setQuantity(odr.getQuantity() + 1);
			 odr.setSubTotal( odr.getUnitCost() * odr.getQuantity());
			 orderDetailsRepository.save(odr); 
		  
		 ShoppingCart sc = shoppingCartRepository.findByOrderId(odr.getId());
		 if(sc!=null){
			 sc.setQuantity(odr.getQuantity());
			 sc.setTotalPrice(odr.getSubTotal());
			 sc.setOrderDetails(odr);
			 shoppingCartRepository.save(sc);
		 	} 
		 }
		 else{
			 OrderDetails orderDetails = new OrderDetails();
			 orderDetails.setProducts(product);
		 
			 orderDetails.setQuantity(1);
			 orderDetails.setUnitCost(product.getUnitPrice());
			 orderDetails.setSubTotal( orderDetails.getQuantity() * orderDetails.getUnitCost() );
			 
			 ShoppingCart shoppingCart = new ShoppingCart();
			 shoppingCart.setDateAdded( LocalDate.now());
			 shoppingCart.setOrderDetails(orderDetails);
			 shoppingCart.setQuantity(1);
			 shoppingCart.setTotalPrice(orderDetails.getSubTotal());
			 shoppingCartRepository.save(shoppingCart);
			// shoppingCart.getTotalPrice() + 
			System.out.println("saved");
			 //shoppingCartRepository.save(shoppingCart);
			//addCart(shoppingCart);
			 orderDetailsRepository.save(orderDetails);
		 
			 
			
		 }
		 	
	}
	@Transactional
	public void addCart(ShoppingCart shoppingCart){
		shoppingCartRepository.save(shoppingCart);
	}
	public void deletShoppingCart(ShoppingCart shoppingCart) {
		//Long oredrDetailsId = shoppingCart.getOrderDetails().getId();
	//	orderDetailsRepository.delete(oredrDetailsId);
		shoppingCartRepository.delete(shoppingCart);
		
	}
 
	public ShoppingCart findByTotalPrice() {
		// TODO Auto-generated method stub
		return shoppingCartRepository.findByTotalPrice();
	}

	@Override
	public ShoppingCart findByOrderId(Long id) {
		 
		return  shoppingCartRepository.findByOrderId(id);
	}

	@Override
	public void deletAllChart() {
	  
		shoppingCartRepository.deleteAll();
	}

	@Override
	public double findTotalCharCost(List<ShoppingCart> shoppingCarts) {
		 
		double totalPrice = 0;
		for(ShoppingCart sc : shoppingCarts){
			totalPrice += sc.getTotalPrice();
		}
		return totalPrice;
	}

	 
}

package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.Review;

public interface OrderDetailsService {

	public void addOrderDetails(OrderDetails orderDetails);
	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails getOrderDetailsById(Long id);
	public void removeOrderDetails(Long id);
	
	public OrderDetails findByProductId(long id);
}

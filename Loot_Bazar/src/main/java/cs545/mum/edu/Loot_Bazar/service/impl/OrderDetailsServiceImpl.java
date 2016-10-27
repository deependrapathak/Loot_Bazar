package cs545.mum.edu.Loot_Bazar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.Review;
import cs545.mum.edu.Loot_Bazar.repository.OrderDetailsRepository;
import cs545.mum.edu.Loot_Bazar.service.OrderDetailsService;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public void addOrderDetails(OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
		
	}

	public List<OrderDetails> getAllOrderDetails() {
		 
		return (List<OrderDetails>) orderDetailsRepository.findAll();
	}

	public OrderDetails getOrderDetailsById(Long id) {
		 
		return orderDetailsRepository.findOne(id);
	}

	public void removeOrderDetails(Long id) {
		orderDetailsRepository.delete(id);
		
	}

	public OrderDetails findByProductId(long id) {
		 
		return orderDetailsRepository.findByProductId(id);
	}

}

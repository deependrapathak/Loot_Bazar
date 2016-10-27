package cs545.mum.edu.Loot_Bazar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.OrderDetails;
import cs545.mum.edu.Loot_Bazar.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{
	
	@Query(value="SELECT s FROM ShoppingCart s")
	public ShoppingCart findByTotalPrice();
	
	@Query("select sc from ShoppingCart sc where sc.orderDetails.id = :id")
	ShoppingCart findByOrderId(@Param("id") long id);
}

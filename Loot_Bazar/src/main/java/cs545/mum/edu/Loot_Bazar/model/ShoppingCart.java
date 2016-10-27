package cs545.mum.edu.Loot_Bazar.model;

import java.math.BigDecimal;
import java.time.LocalDate; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {
	@javax.persistence.Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;
	private long quantity;
	private LocalDate dateAdded;
	private double totalPrice;
	/*@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> product;*/
	@OneToOne( fetch= FetchType.EAGER, cascade = CascadeType.ALL )
	private OrderDetails orderDetails;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate localDate) {
		this.dateAdded = localDate;
	}
	/*public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}*/
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}

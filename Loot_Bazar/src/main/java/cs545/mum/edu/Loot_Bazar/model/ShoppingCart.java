package cs545.mum.edu.Loot_Bazar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	@javax.persistence.Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;
	private long quantity;
	private Date dateAdded;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Product> product;
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	

}

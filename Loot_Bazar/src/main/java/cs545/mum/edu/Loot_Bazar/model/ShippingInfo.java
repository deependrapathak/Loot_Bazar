package cs545.mum.edu.Loot_Bazar.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ShippingInfo {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	@Enumerated(EnumType.STRING)
	private ShippingType shippingType;
	private double shippingCost;
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
}

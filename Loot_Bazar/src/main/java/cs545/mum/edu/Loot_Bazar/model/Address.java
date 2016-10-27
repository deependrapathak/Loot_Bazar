package cs545.mum.edu.Loot_Bazar.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="{NotEmpty}")
	private String street;
	@NotEmpty(message="{NotEmpty}")
	private String city;
	@NotEmpty(message="{NotEmpty}")
	@Size(min=2,max=2,message="{phone.size}")
	private String state;
	@NotEmpty
	@Digits(integer=5,fraction=0,message="{digit}")
	@Size(min=5,max=5,message="{phone.size}")
	private String zip;
	@NotEmpty(message="{NotEmpty}")
	private String country;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		 
		return street+" "+city+","+city+" "+zip;
	}
	
}

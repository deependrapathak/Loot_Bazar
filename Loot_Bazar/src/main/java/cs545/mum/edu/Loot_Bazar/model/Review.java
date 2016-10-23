package cs545.mum.edu.Loot_Bazar.model;

import javax.persistence.Entity;

@Entity
public class Review {
	@javax.persistence.Id
	private Long Id;
	private String description;
	private String name;
	private String email;
	private String rate;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

}

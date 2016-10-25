package cs545.mum.edu.Loot_Bazar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class User {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotEmpty(message="{NotEmpty}")
	@Size(min=5,max=20,message="{phone.size}")
	@Column(unique=true)
	private String username;
	@NotEmpty(message="{NotEmpty}")
	@Size(min=5,max=20,message="{phone.size}")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role hasRole;
	private boolean enabled;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getHasRole() {
		return hasRole;
	}
	public void setHasRole(Role hasRole) {
		this.hasRole = hasRole;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}

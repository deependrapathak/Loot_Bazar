package cs545.mum.edu.Loot_Bazar.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Entity
public class User {
	@javax.persistence.Id
	private Long Id;
	private String username;
	private String password;
	@Enumerated(EnumType.ORDINAL)
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

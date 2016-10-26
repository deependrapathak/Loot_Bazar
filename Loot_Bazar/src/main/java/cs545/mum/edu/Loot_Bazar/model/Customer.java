package cs545.mum.edu.Loot_Bazar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Customer {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotEmpty(message="{NotEmpty}")
	private String fName;
	private String lName;
	@NotEmpty(message="{NotEmpty}")
	@Size(min=10,max=10,message="{phone.size}")
	private String phone;
	@Email(message="{email}")
	private String email;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="{NotNull}")
	@Temporal(TemporalType.DATE)
	@Past(message="past")
	private Date dob;
	@NotEmpty(message="{NotEmpty}")
	private String identificationNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private User user;
	/*@OneToMany(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Order> orders;*/
	/*@Transient
	private MultipartFile multipartfile;
	public MultipartFile getMultipartfile() {
		return multipartfile;
	}
	public void setMultipartfile(MultipartFile multipartfile) {
		this.multipartfile = multipartfile;
	}*/
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", email=" + email
				+ ", dob=" + dob + ", identificationNumber=" + identificationNumber + ", address=" + address + ", user="
				+ user + ", orders=" + orders + "]";
	}*/
	
}

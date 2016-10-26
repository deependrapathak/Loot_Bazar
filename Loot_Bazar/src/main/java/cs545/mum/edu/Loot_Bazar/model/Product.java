package cs545.mum.edu.Loot_Bazar.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;



@Entity
public class Product {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotEmpty
	@Size(min=2,message="{Size.Product.pName.validation}")
	private String pName;
	@NotNull
	@Min(value=1, message="{Size.Product.unitPrice.validation}" )
	private double unitPrice;
	@NotEmpty
	private String description;
	@NotNull
	private int unitsInStock;	
	private boolean discount = true;
	@NotEmpty
	@Size(min=2,message="{Size.Product.conditioned.validation}")
	private String conditioned;
	@OneToOne
	private Category category;
	/*@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews;*/
	@Transient
	private MultipartFile productImage;
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	public Long getId() {
		return Id;
	}
	public Category getCategory() {
		return category;
	}
	public void setConditioned(String conditioned) {
		this.conditioned = conditioned;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	public String getConditioned() {
		return conditioned;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	/*public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}*/
	
	
}

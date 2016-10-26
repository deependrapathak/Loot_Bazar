package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import cs545.mum.edu.Loot_Bazar.model.Product;

public interface ProductService {
	public List <Product> getAll();
	public Product getProductById(Long key);
	public void delete(Long id);
	public void addProduct(Product product);	
	//public void updateProduct(Long key);


}

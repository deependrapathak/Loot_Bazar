package cs545.mum.edu.Loot_Bazar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.Product;

@Repository
public interface ProductRepository extends  CrudRepository<Product, Long>{

	//void updateProduct();
	/*@Query("SELECT p FROM Product p")
	public List <Product> findAllProduct();
	public Product getProductById(Long key);
	public List<Product> getProductsByCategory(String category);
	public void delete(Long id);
	public void addProduct(Product product);	*/
	
	

}

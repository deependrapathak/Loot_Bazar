package cs545.mum.edu.Loot_Bazar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.repository.ProductRepository;
import cs545.mum.edu.Loot_Bazar.service.ProductService;

@Service
@Transactional

public class ProdcutServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	

	@Override
	public Product getProductById(Long key) {
		return productRepository.findOne(key);
	}

	
	@Override
	public void delete(Long id) {
		productRepository.delete(id);
		
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		
		return (List<Product>) productRepository.findAll();
	}


	/*@Override
	public void updateProduct(Long key) {
		productRepository.updateProduct();
	}*/

}

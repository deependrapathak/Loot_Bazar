package cs545.mum.edu.Loot_Bazar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs545.mum.edu.Loot_Bazar.model.Category;
import cs545.mum.edu.Loot_Bazar.repository.CategoryRepository;
import cs545.mum.edu.Loot_Bazar.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long key) {
		return categoryRepository.findOne(key);
	}

	@Override
	public void add(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
		
	}

}

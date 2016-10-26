package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import cs545.mum.edu.Loot_Bazar.model.Category;

public interface CategoryService {
	public List<Category> getAll();
	public Category getCategoryById(Long key);
	public void add(Category category);
	public void delete(Long id);

}

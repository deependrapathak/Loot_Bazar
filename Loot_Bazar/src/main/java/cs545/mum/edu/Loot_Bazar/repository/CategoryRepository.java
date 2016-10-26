package cs545.mum.edu.Loot_Bazar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.Category;


@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long>{
		/*public void saveCategory(Category category);
		public List<Category>getAll();
		public List<Category> getByName(String name);*/
}

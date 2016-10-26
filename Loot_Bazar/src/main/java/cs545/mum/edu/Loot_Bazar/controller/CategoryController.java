package cs545.mum.edu.Loot_Bazar.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs545.mum.edu.Loot_Bazar.model.Category;
import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	ServletContext 	servletContext;
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value={"","/categories"})
	public String listEmployees(Model model) {
 	
 		List<Category> categoryList= categoryService.getAll();
 		model.addAttribute("categories", categoryList);
 		return "categories";
	}
	@RequestMapping("/category{id}")
	public String getCategoryById(@RequestParam("id") Long categoryId, Model model) {

  		Category category = categoryService.getCategoryById(categoryId);
  		
  		model.addAttribute("category",category);
		return "category";
	}
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addNewEmployee(@ModelAttribute("newCategory") Category newCategory) {
	   return "addCategories";
	}
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String processAddNewEmployee(@Valid @ModelAttribute("newCategory") Category categoryToBeAdded, BindingResult result,RedirectAttributes redirect) {
		
		if(result.hasErrors()){
			 return "addCategories";
		}
		else
		{
			categoryService.add(categoryToBeAdded);
			redirect.addFlashAttribute("categories", categoryToBeAdded);
			return "redirect:/categories";
		}
	}
	@RequestMapping(value="/category/update{id}")
	public String updateCategoryById(@RequestParam("id") Long categoryId,@ModelAttribute("updatedCategory")Category updatedCategory, Model model) {

  		Category category = categoryService.getCategoryById(categoryId);
  		model.addAttribute("category", category);
		return "updateCategory";
	}
  	@RequestMapping(value="/category/update{id}", method=RequestMethod.POST)
  	public String updateCategory(@RequestParam("id") Long categoryId,@ModelAttribute("updatedCategory")Category updatedCategory, Model model){
  		updatedCategory.setId(categoryId);
  		categoryService.add(updatedCategory);
  		return "categories";
  	}
  	@RequestMapping("/category/delete{id}")
	public String deleteCategoryById(@RequestParam("id") Long categoryId, Model model) {
  		categoryService.delete(categoryId);
		return "redirect:/categories";
	}

}

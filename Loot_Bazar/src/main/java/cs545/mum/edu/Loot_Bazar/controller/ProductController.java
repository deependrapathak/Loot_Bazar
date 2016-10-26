package cs545.mum.edu.Loot_Bazar.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs545.mum.edu.Loot_Bazar.model.Category;
import cs545.mum.edu.Loot_Bazar.model.Customer;
import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.service.CategoryService;
import cs545.mum.edu.Loot_Bazar.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ServletContext servletContext;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "", "/products" })
	public String listProducts(Model model) {

		List<Product> productList = productService.getAll();
		model.addAttribute("products", productList);

		return "welcome";
	}

	@RequestMapping("/product{id}")
	public String getProductById(@RequestParam("id") Long productId, Model model) {

		Product product = productService.getProductById(productId);

		model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping("/product/delete{id}")
	public String deleteProductById(@RequestParam("id") Long productId, Model model) {
		productService.delete(productId);
		return "redirect:/products";
	}

	@RequestMapping(value = "/product/update{id}")
	public String updateProductById(@RequestParam("id") Long productId,
			@ModelAttribute("updatedProduct") Product updatedProduct, Model model) {

		Product product = productService.getProductById(productId);
		List<Category> category = categoryService.getAll();
		model.addAttribute("product", product);
		model.addAttribute("categories", category);
		return "updateProduct";
	}

	@RequestMapping(value = "/product/update{id}", method = RequestMethod.POST)
	public String updateProduct(@RequestParam("id") Long productId,
			@ModelAttribute("updatedProduct") Product updatedProduct, Model model) {
		updatedProduct.setId(productId);
		productService.addProduct(updatedProduct);
		return "products";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String addNewProduct(@ModelAttribute("newProduct") Product newProduct, Model model) {
		List<Category> category = categoryService.getAll();
		model.addAttribute("categories", category);
		return "addProduct";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String processAddNewProduct(@Valid @ModelAttribute("newProduct") Product productToBeAdded,
			BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "addProduct";
		} else {
			/*MultipartFile productImage = productToBeAdded.getProductImage();
			String rootDirectory = servletContext.getRealPath("/");
			System.out.println(rootDirectory);
			if (productImage != null && !productImage.isEmpty()) {
				try {
					System.out.println(rootDirectory + "\\resources\\images\\" + productToBeAdded.getpName() + ".png");
					productImage.transferTo(new File(rootDirectory + "\\resources\\images\\" + productToBeAdded.getpName() + ".png"));
				} catch (Exception e) {
					// throw new RuntimeException("Student Image saving failed",
					// e);
					throw new RuntimeException(e.toString());
				}
			} else {
				throw new RuntimeException("error");
			}*/
			productService.addProduct(productToBeAdded);
			redirect.addFlashAttribute("product", productToBeAdded);
			return "redirect:/products";
		}
	}

}

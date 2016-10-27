package cs545.mum.edu.Loot_Bazar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
import cs545.mum.edu.Loot_Bazar.model.Product;
import cs545.mum.edu.Loot_Bazar.model.Review;
import cs545.mum.edu.Loot_Bazar.model.ShoppingCart;
import cs545.mum.edu.Loot_Bazar.service.ProductService;
import cs545.mum.edu.Loot_Bazar.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	private ProductService productService;
 
	@RequestMapping(value="/addReview" , method=RequestMethod.GET)
	String getReviewForm(@ModelAttribute("newReview") Review review, Model model ){
		List<Review> reviews = reviewService.getAllReview();
		model.addAttribute("reviews", reviews);
		return "review/reviewList";
		//return "review/addReview";
	}
	@RequestMapping(value="/addReview{id}", method= RequestMethod.POST)
	String addReview(@RequestParam("id") Long productId, Review review){
		
			Product product = productService.getProductById(productId);
			//System.out.println(product.getpName());
			//product.getReviews().add(review);
			review.setProduct(product);
			System.out.println(product.getpName());
			System.out.println();
			reviewService.addReview(review);
			return "redirect:product?id="+productId;
		   
	}
	
	@RequestMapping(value = "/removeReviewById/{rewiewId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeReview(@PathVariable Long rewiewId ) {
		
		reviewService.removeReview(rewiewId);
	}

}

package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import cs545.mum.edu.Loot_Bazar.model.Review;

public interface ReviewService {

	public void addReview(Review review);
	public List<Review> getAllReview();
	public Review getReviewById(Long id);
	public void removeReview(Long id);
	//public void updateReview(Review review);
	public List<Review> findReviewByProductId(Long productId);
}

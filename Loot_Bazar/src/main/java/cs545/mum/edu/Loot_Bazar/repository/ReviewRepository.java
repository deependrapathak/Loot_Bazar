package cs545.mum.edu.Loot_Bazar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

	/*@Query(value="UPDATE Review set ")*/
	//public void updateReview(Review review);
}

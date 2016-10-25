package cs545.mum.edu.Loot_Bazar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.Customer;
@Repository
public interface UserRepository extends CrudRepository<Customer, Long>{
	@Query("select c from Customer c where c.user.username=:username")
	public Customer findOneWithName(@Param("username")String username);
}

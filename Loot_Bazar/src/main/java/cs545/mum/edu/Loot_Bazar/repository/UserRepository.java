package cs545.mum.edu.Loot_Bazar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs545.mum.edu.Loot_Bazar.model.Customer;
@Repository
public interface UserRepository extends CrudRepository<Customer, Long>{

}

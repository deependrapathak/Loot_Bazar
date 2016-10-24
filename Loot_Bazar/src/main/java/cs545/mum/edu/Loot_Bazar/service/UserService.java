package cs545.mum.edu.Loot_Bazar.service;

import java.util.List;

import cs545.mum.edu.Loot_Bazar.model.Customer;

public interface UserService {
public Customer save(Customer customer);
public List<Customer> findAll();
public Customer findOne(Long cId);
public void delete(Customer customer);
}

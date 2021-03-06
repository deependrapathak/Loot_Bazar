package cs545.mum.edu.Loot_Bazar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs545.mum.edu.Loot_Bazar.model.Customer;
import cs545.mum.edu.Loot_Bazar.repository.UserRepository;
import cs545.mum.edu.Loot_Bazar.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		customer.getUser().setPassword(encoder.encode(customer.getUser().getPassword()));
		userRepository.save(customer);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) userRepository.findAll();
	}

	@Override
	public Customer findOne(Long cId) {
		// TODO Auto-generated method stub
		return userRepository.findOne(cId);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	
		
	}

	@Override
	public void edit(Customer customer) {
		// TODO Auto-generated method stub
		userRepository.save(customer);
		
	}

	@Override
	public Customer findOneWithName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findOneWithName(name);
	}

}

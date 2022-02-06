package com.user.service;

import com.user.dao.CustomerRepository;
import com.user.dao.UserRepository;
import com.user.exception.ResourceNotFoundException;
import com.user.model.CustomerModel;
import com.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public void registerCustomer(CustomerModel customer)
	{
		customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
	}
	
	public CustomerModel getCustomerById(String id) {
		Optional<CustomerModel> customer = customerRepository.findById(id);
		
		if(!customer.isPresent())
		{
			throw new ResourceNotFoundException("user not found with id = "+id);
		}

		return customer.get();
	}
	

	public List<CustomerModel> getAllCustomer() {
		List<CustomerModel> customers = (List<CustomerModel>) customerRepository.findAll();	
		return customers;
	}
	
	public void deleteCustomerById(String id) {
		
		try {
			customerRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("user not found with id = "+id);
		}
	}


	public UserModel getUserById(String id) {
		Optional<UserModel> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new ResourceNotFoundException("user not found with id = " + id);
		}

		return user.get();
	}
}

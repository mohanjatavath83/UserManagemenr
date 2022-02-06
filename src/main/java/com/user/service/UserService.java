package com.user.service;

import java.util.List;

import com.user.model.CustomerModel;
import com.user.model.UserModel;

public interface UserService {
	void registerCustomer(CustomerModel customer);
	CustomerModel getCustomerById(String id);
	List<CustomerModel> getAllCustomer();
	void deleteCustomerById(String id);
	UserModel getUserById(String id);
}

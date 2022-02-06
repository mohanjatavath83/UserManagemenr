package com.user.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.data.CustomerData;
import com.user.model.CustomerModel;
import com.user.populator.CustomerPopulator;
import com.user.populator.CustomerReversePopulator;
import com.user.service.UserService;

@Component
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerPopulator customerPopulator;
	
	@Autowired
	private CustomerReversePopulator customerReversePopulator;
	
	@Override
	public CustomerModel registerCustomer(CustomerData userData) {
		CustomerModel customer = customerReversePopulator.populate(userData);
		userService.registerCustomer(customer);
		return customer;

	}

	@Override
	public List<CustomerData> getCustomers() {
		List<CustomerModel> customers = userService.getAllCustomer();
		System.out.println("facade customers size = " + customers.size());
		List<CustomerData> customersData = new ArrayList<>();
		CustomerData customerData = null;
		for (CustomerModel customer : customers) {
			customerData = customerPopulator.populate(customer);
			customersData.add(customerData);
		}

		return customersData;

	}
	
	@Override
	public CustomerData getCustomerById(String id)
	{
		CustomerModel customer = userService.getCustomerById(id);
		return customerPopulator.populate(customer);		
	}
	
	public void deleteCustomerById(String id)
	{
		userService.deleteCustomerById(id);
	}
}

package com.user.facade;

import java.util.List;

import com.user.data.CustomerData;
import com.user.model.CustomerModel;

public interface UserFacade {
	
	CustomerModel registerCustomer(CustomerData customerData);
	List<CustomerData> getCustomers();
	CustomerData getCustomerById(String id);
	void deleteCustomerById(String id);

}

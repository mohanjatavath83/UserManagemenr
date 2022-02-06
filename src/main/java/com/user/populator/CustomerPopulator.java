package com.user.populator;

import org.springframework.stereotype.Component;

import com.user.data.CustomerData;
import com.user.model.CustomerModel;

@Component
public class CustomerPopulator implements Populator<CustomerModel,CustomerData>{

	@Override
	public CustomerData populate(CustomerModel customer) 
	{
		CustomerData userData = new CustomerData();
		userData.setUid(customer.getMobileNumber());
		userData.setFirstName(customer.getFirstName());
		userData.setLastName(customer.getLastName());
		userData.setEmail((customer.getEmail()));
		//userData.setPassword((customer.getPassword()));
		userData.setMobileNumber((customer.getMobileNumber()));
		return userData;
			
	}

}

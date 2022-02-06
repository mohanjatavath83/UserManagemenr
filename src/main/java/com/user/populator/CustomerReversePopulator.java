package com.user.populator;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.user.data.CustomerData;
import com.user.model.CustomerModel;
import com.user.model.RoleModel;
import com.user.model.RoleType;

@Component
public class CustomerReversePopulator implements Populator<CustomerData,CustomerModel> {

	@Override
	public CustomerModel populate(CustomerData userData) {
		CustomerModel customer = new CustomerModel();
		customer.setFirstName(userData.getFirstName());
		customer.setLastName(userData.getLastName());
		customer.setEmail((userData.getEmail()));
		customer.setUid(userData.getMobileNumber());
		customer.setPassword((userData.getPassword()));
		customer.setMobileNumber((userData.getMobileNumber()));
		Set<RoleModel> roles = new HashSet<RoleModel>();
		
		if (CollectionUtils.isNotEmpty(userData.getRoles())) 
		{
			for (String code : userData.getRoles()) {
				try {
					RoleType roleType = RoleType.getRoleType(code);
					RoleModel role = new RoleModel();
					role.setRoleType(roleType);
					roles.add(role);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
		
		return customer;
	}

}

package com.user.model;

import javax.persistence.Entity;

@Entity
public class EmployeeModel extends UserModel
{
	private boolean isManager;

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}	
}

package com.user.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.user.model.EmployeeModel;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeModel, String> {

}

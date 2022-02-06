package com.user.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.user.model.CustomerModel;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerModel, String> {
}

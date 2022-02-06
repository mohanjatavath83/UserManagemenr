package com.user.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.user.model.RoleModel;

@Repository
public interface RoleRepository  extends PagingAndSortingRepository<RoleModel, Long> {

}

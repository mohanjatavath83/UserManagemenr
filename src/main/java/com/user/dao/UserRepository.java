package com.user.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.user.model.UserModel;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel,String>  {

}

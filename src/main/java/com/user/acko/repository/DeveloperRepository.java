package com.user.acko.repository;

import com.user.acko.model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository  extends PagingAndSortingRepository<Developer, String> {
}

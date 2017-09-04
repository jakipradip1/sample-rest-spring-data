package com.cubic.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cubic.entity.CustomerEntity;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {

	List<CustomerEntity> findByFNameIgnoreCaseStartingWith(String fName);
}

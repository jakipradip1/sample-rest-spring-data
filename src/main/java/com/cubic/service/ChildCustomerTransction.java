package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;

@Service("cTrans")
@Transactional(propagation = Propagation.SUPPORTS) // by default requires new
public class ChildCustomerTransction implements CustomerTransction {

	@Autowired
	private CustomerRepo repo;

	@Transactional(propagation = Propagation.NEVER)
	public void createCustomer() {
		save("Child", "Transction");
		throw new RuntimeException("Roll Back");

	}

	private void save(final String firstName, final String lastName) {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName(firstName);
		entity.setlName(lastName);
		repo.save(entity);
	}

}

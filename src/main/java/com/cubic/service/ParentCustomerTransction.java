package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ParentCustomerTransction implements CustomerTransction {

	@Autowired
	private CustomerRepo repo;

	@Autowired
	@Qualifier("cTrans")
	private CustomerTransction child;

	@Transactional(propagation = Propagation.REQUIRED)
	public void createCustomer() {
		save("Parent", "Transction");
		child.createCustomer();

	}

	private void save(final String firstName, final String lastName) {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName(firstName);
		entity.setlName(lastName);
		repo.save(entity);
	}

}

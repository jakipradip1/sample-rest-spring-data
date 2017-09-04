package com.cubic.service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import com.cubic.entity.CustomerEntity;

public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImplementation csImpl;

	@Mock
	private EntityManager em;

	@Spy
	private CustomerMapper mapper;

	@Test
	public void testUpdate() {

	}

}

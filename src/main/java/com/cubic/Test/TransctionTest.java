package com.cubic.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.service.CustomerTransction;

public class TransctionTest {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringJPA.xml");
		CustomerTransction pt = context.getBean("parentCustomerTransction", CustomerTransction.class);
		// ChildCustomerTransction ct = context.getBean("cTrans",
		// ChildCustomerTransction.class);
		pt.createCustomer();

	}
}

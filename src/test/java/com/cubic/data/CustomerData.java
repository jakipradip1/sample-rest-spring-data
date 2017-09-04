package com.cubic.data;

import com.cubic.entity.CustomerEntity;
import com.cubic.vo.CustomerVO;

public class CustomerData {
	public static CustomerEntity createCUstomerENtity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName("mock");
		entity.setlName("mocklast");
		return entity;
	}

	public static CustomerVO createCUstomerVO() {
		CustomerVO vo = new CustomerVO();
		vo.setfName("mock");
		vo.setlName("mocklast");
		return vo;
	}
}

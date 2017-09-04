package com.cubic.service;

import java.util.List;

import com.cubic.vo.CustomerVO;

public interface CustomerService {
	CustomerVO create(CustomerVO vo);

	CustomerVO update(CustomerVO vo);

	void delete(Long id);

	CustomerVO find(Long id);

	List<CustomerVO> findAll();

	List<CustomerVO> findByName(String name);

}

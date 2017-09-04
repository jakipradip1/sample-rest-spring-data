package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;
import com.cubic.vo.CustomerVO;

@Service("csSData")
@Transactional
public class CusImplSData implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private CustomerMapper mapper;

	public CustomerVO create(CustomerVO vo) {
		CustomerEntity entity = mapper.mapToEntity(new CustomerEntity(), vo);
		return mapper.mapToVO(custRepo.save(entity));
	}

	public CustomerVO update(CustomerVO vo) {
		CustomerEntity entity = custRepo.findOne(vo.getId());
		entity = mapper.mapToEntity(entity, vo);
		return mapper.mapToVO(custRepo.save(entity));
	}

	public void delete(Long id) {
		custRepo.delete(id);
	}

	public CustomerVO find(Long id) {
		return mapper.mapToVO(custRepo.findOne(id));
	}

	public List<CustomerVO> findAll() {
		return mapper.mapToListVO((List<CustomerEntity>) custRepo.findAll());
	}

	@SuppressWarnings("unchecked")
	public List<CustomerVO> findByName(String name) {
		return mapper.mapToListVO(custRepo.findByFNameIgnoreCaseStartingWith(name));
	}

}

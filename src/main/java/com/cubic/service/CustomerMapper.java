package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.CustomerEntity;
import com.cubic.vo.CustomerVO;

@Component
public class CustomerMapper {
	public CustomerEntity mapToEntity(final CustomerEntity entity, final CustomerVO vo) {
		entity.setfName(vo.getfName());
		entity.setId(vo.getId());
		entity.setlName(vo.getlName());
		entity.setSnn(vo.getSnn());
		return entity;
	}

	public CustomerVO mapToVO(final CustomerEntity entity) {
		CustomerVO vo = new CustomerVO();
		vo.setfName(entity.getfName());
		vo.setlName(vo.getlName());
		vo.setId(entity.getId());
		vo.setSnn(entity.getSnn());
		return vo;
	}

	public List<CustomerVO> mapToListVO(final List<CustomerEntity> entityList) {
		List<CustomerVO> listVo = new ArrayList<CustomerVO>();
		for (CustomerEntity entity : entityList) {
			listVo.add(mapToVO(entity));
		}
		return listVo;

	}
}

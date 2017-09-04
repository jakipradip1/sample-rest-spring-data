package com.cubic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;
import com.cubic.exception.ValidationException;
import com.cubic.vo.CustomerVO;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {

	@PersistenceContext
	private EntityManager em;

	private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImplementation.class);

	@Autowired
	private CustomerMapper mapper;

	public CustomerVO create(CustomerVO vo) {
		logger.debug("Entering CustomerServiceImplemenation.create");
		logger.debug("CustomerVO = {}", vo);

		if (vo.getfName() == null) {
			logger.debug("Couldnot validate. Throwing error");
			throw new ValidationException("first name required");
		}
		logger.debug("Validation CustomerVO sucessful");

		CustomerEntity entity = mapper.mapToEntity(new CustomerEntity(), vo);
		logger.debug("Sucessfully Maped VO to Entity");

		em.persist(entity);
		logger.debug("Persist sucessful = {}", entity);
		vo.setId(entity.getId());

		logger.debug("Exiting CustomerServiceImplemenation.create");
		return vo;
	}

	public CustomerVO update(CustomerVO vo) {
		CustomerEntity entity = em.find(CustomerEntity.class, vo.getId());
		entity = mapper.mapToEntity(entity, vo);
		em.persist(entity);
		return vo;
	}

	public void delete(Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		em.remove(entity);

	}

	public CustomerVO find(Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		CustomerVO vo = mapper.mapToVO(entity);

		return vo;
	}

	public List<CustomerVO> findAll() {
		TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.FIND_ALL, CustomerEntity.class);
		List<CustomerEntity> results = query.getResultList();
		return mapper.mapToListVO(results);
	}

	public List<CustomerVO> findByName(String name) {
		String trimedName = name.trim() + "%";
		TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.FIND_BY_NAME, CustomerEntity.class);
		query.setParameter("fName", trimedName);
		List<CustomerEntity> results = query.getResultList();

		return mapper.mapToListVO(results);
	}

}

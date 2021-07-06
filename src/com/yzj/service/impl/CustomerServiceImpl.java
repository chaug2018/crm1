package com.yzj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yzj.dao.BaseDictDao;
import com.yzj.dao.CustomerDao;
import com.yzj.domain.BaseDict;
import com.yzj.domain.Customer;
import com.yzj.service.CustomerService;

@Service("customerService")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {
	
	@Resource(name="customerDao")
	CustomerDao customerDao;
	
	@Resource(name="baseDictDao")
	BaseDictDao  baseDictDao;
	@Override
	public List<Customer> findAll(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return customerDao.findAll(criteria);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Override
	public List<BaseDict> findAllCustomerSource() {
		// TODO Auto-generated method stub
		return baseDictDao.findBaseDictByTypeCode("002");
	}

	@Override
	public List<BaseDict> findAllCustomerLevel() {
		// TODO Auto-generated method stub
		return baseDictDao.findBaseDictByTypeCode("006");
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void deleteCustomer(Long custId) {
		customerDao.deletCustomerById(custId);
		
	}
/**
 * 查询出一个客户
 */
	@Override
	public Customer findById(Long custId) {
		
		return customerDao.findById(custId);
	}



}

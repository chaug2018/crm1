package com.yzj.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yzj.dao.CustomerDao;
import com.yzj.domain.Customer;


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao  {

	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Customer> findAll(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return (List<Customer>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(customer);
	}
	@Override
	public Customer findById(Long custId) {
		
		return hibernateTemplate.get(Customer.class, custId);
	}
	

	@Override
	public void deletCustomerById(Long custId) {
//	Customer customer=findById(custId);
	hibernateTemplate.delete(findById(custId));
	}

	
}

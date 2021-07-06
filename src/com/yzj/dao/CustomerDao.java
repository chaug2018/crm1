package com.yzj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.yzj.domain.Customer;



public interface CustomerDao {

	List<Customer> findAll(DetachedCriteria criteria);

	void save(Customer customer);

	void deletCustomerById(Long custId);
	
	Customer findById(Long custId);

}

package com.yzj.text;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzj.domain.Customer;
import com.yzj.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class CustomerTest {	
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void findAll() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		List<Customer> all=customerService.findAll(criteria);
		for (Object o:all) {
			System.out.println(o);
		}
	}
	
	@Test
	public void save() {
	
		Customer customer=new Customer();
		customer.setCustName("欧辰");
		customer.setCustAddress("湖南");
//		customer.setCustLevel("23");
//		customer.setCustPhone("12221");
//		customer.setCustSource("34");
		customerService.save(customer);
		
	}
	

}

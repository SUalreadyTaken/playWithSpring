package com.su.crmrest.dao;

import com.su.crmrest.entity.Customer;

import java.util.List;



public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}

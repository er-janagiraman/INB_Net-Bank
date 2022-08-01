package com.inb.main.service;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.LoginDetails;

public interface CustomerDetailsServiceInterface {

	public CustomerDetails validateCustomer(CustomerDetails customerDetails);

	boolean addNewCustomerdetails(CustomerDetails customerDetails);

	List<CustomerDetails> getAllCustomerDetails();

	CustomerDetails getCustomerDetailsByCustomerId(String customerId);

	public CustomerDetails getCustomerDetailsByUserId(String userId);

	List<AccountDetails> getAllAccountsByStatus();

	public List<CustomerDetails> getAllCustomerByStatus();

	boolean updateCustomerStatus(CustomerDetails putCustomeStatus);;
}

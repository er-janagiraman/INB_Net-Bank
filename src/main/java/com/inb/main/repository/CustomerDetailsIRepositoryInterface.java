package com.inb.main.repository;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.LoginDetails;

public interface CustomerDetailsIRepositoryInterface {

	public CustomerDetails validateCustomer(CustomerDetails customerDetails);

	boolean addNewCustomerdetails(CustomerDetails customerDetails);

	List<CustomerDetails> getAllCustomerDetails();

	CustomerDetails getCustomerDetailsByCustomerId(String userId);

	public CustomerDetails getCustomerDetailsByUserId(String userId);

	List<CustomerDetails> getAllCustomerByStatus();

	public boolean updateCustomerStatus(CustomerDetails putCustomeStatus);
}

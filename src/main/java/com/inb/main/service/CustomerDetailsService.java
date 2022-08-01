package com.inb.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.repository.CustomerDetailsIRepositoryInterface;

@Service
public class CustomerDetailsService implements CustomerDetailsServiceInterface {

	@Autowired
	CustomerDetailsIRepositoryInterface customerDetailsIRepositoryInterface;

	public CustomerDetails validateCustomer(CustomerDetails customerDetails) {

		return customerDetailsIRepositoryInterface.validateCustomer(customerDetails);

	}

	@Override
	public boolean addNewCustomerdetails(CustomerDetails customerDetails) {

		return customerDetailsIRepositoryInterface.addNewCustomerdetails(customerDetails);
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return customerDetailsIRepositoryInterface.getAllCustomerDetails();
	}

	@Override
	public CustomerDetails getCustomerDetailsByCustomerId(String customerId) {

		return customerDetailsIRepositoryInterface.getCustomerDetailsByCustomerId(customerId);
	}

	@Override
	public CustomerDetails getCustomerDetailsByUserId(String userId) {

		return customerDetailsIRepositoryInterface.getCustomerDetailsByUserId(userId);
	}

	@Override
	public List<AccountDetails> getAllAccountsByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDetails> getAllCustomerByStatus() {

		return customerDetailsIRepositoryInterface.getAllCustomerByStatus();
	}

	@Override
	public boolean updateCustomerStatus(CustomerDetails putCustomeStatus) {

		System.out.println("from service");
		return customerDetailsIRepositoryInterface.updateCustomerStatus(putCustomeStatus);
	}

}

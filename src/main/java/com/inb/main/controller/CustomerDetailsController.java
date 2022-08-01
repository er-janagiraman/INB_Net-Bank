package com.inb.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.LoginDetails;
import com.inb.main.service.CustomerDetailsServiceInterface;
import com.inb.main.service.EmailNotificationService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsServiceInterface customerDetailsServiceInterface;

	@Autowired
	private EmailNotificationService emailNotificationService;

	@RequestMapping(value = "customerdetails", method = RequestMethod.POST)
	public CustomerDetails Customer(@RequestBody CustomerDetails customerDetails) {
		return customerDetailsServiceInterface.validateCustomer(customerDetails);

	}

	@RequestMapping(value = "customerdetails/addnew", method = RequestMethod.POST)
	public boolean NewloginDetails(@RequestBody CustomerDetails customerDetails) {

		return customerDetailsServiceInterface.addNewCustomerdetails(customerDetails);
	}

	@RequestMapping(value = "customerdetails/getall", method = RequestMethod.GET)
	public List<CustomerDetails> getAllCustomerDetails() {
		return customerDetailsServiceInterface.getAllCustomerDetails();
	}

	@RequestMapping(value = "customerdetails/{customerId}", method = RequestMethod.GET)
	public CustomerDetails getCustomerDetailsByCustomerId(@PathVariable String customerId) {
		return customerDetailsServiceInterface.getCustomerDetailsByCustomerId(customerId);
	}

	@RequestMapping(value = "customerdetailsbyuserid/{userId}", method = RequestMethod.GET)
	public CustomerDetails getCustomerDetailsByUserId(@PathVariable String userId) {
		return customerDetailsServiceInterface.getCustomerDetailsByUserId(userId);
	}

	@RequestMapping(value = "customerdetails/getbystatus", method = RequestMethod.GET)
	public List<CustomerDetails> getAllCustomerByStatus() {

		return customerDetailsServiceInterface.getAllCustomerByStatus();
	}

	@RequestMapping(value = "customerdetails/updatestatus", method = RequestMethod.PUT)
	public boolean updateCustomerStatus(@RequestBody CustomerDetails putCustomeStatus) {

		return customerDetailsServiceInterface.updateCustomerStatus(putCustomeStatus);
	}

}

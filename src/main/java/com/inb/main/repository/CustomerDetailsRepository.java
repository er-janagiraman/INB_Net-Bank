package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.LoginDetails;

@Repository
public class CustomerDetailsRepository implements CustomerDetailsIRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String GET_CUSTOMER_DETAILS = "select * from Customer_details where user_id=?";

	private static final String GET_CUSTOMER_DETAILS_BY_USERID = "select * from Customer_details where user_id=?";

	private static final String ADD_NEW_LOGIN_DETAILS = "INSERT INTO Customer_details VALUES ('C'||customer_id_sequence.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String GET_ALL_CUSTOMER_DETAILS = "select * from Customer_details ";

	private static final String GET_CUSTOMER_DETAILS_BY_CUSTOMERID = " SELECT * FROM Customer_details WHERE customer_id=?";

	private static final String GET_CUSTOMER_BY_STATUS = "select * from customer_details where customer_status='pending'";

	private static final String PUT_CUSTOMER_STATUS = "update customer_details set customer_status =? where customer_id = ?";

	@Override
	public CustomerDetails validateCustomer(CustomerDetails customerDetails) {
		Object args[] = { customerDetails.getLoginDetails().getUserId() };

		customerDetails = jdbc.queryForObject(GET_CUSTOMER_DETAILS, new CustomerDetailsRowMapper(), args);

		return customerDetails;
	}

	@Override
	public boolean addNewCustomerdetails(CustomerDetails customerDetails) {
		System.err.println(customerDetails);

		Object args[] = { customerDetails.getLoginDetails().getUserId(), customerDetails.getFirstName(),
				customerDetails.getLastName(), customerDetails.getAddressLine1(), customerDetails.getAddressLine2(),
				customerDetails.getAddressLine3(), customerDetails.getCity(), customerDetails.getState(),
				customerDetails.getZipcode(), customerDetails.getLandLine(), customerDetails.getMobileNumber(),
				customerDetails.getEmailId(), customerDetails.getCustomerStatus() };

		int count = jdbc.update(ADD_NEW_LOGIN_DETAILS, args);

		if (count > 0)
			return true;
		return false;
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {

		return jdbc.query(GET_ALL_CUSTOMER_DETAILS, new CustomerDetailsRowMapper());

	}

	@Override
	public CustomerDetails getCustomerDetailsByCustomerId(String customerId) {

		Object args[] = { customerId };
		return jdbc.queryForObject(GET_CUSTOMER_DETAILS_BY_CUSTOMERID, new CustomerDetailsRowMapper(), args);

	}

	@Override
	public CustomerDetails getCustomerDetailsByUserId(String userId) {

		Object args[] = { userId };
		return jdbc.queryForObject(GET_CUSTOMER_DETAILS_BY_USERID, new CustomerDetailsRowMapper(), args);

	}

	@Override
	public List<CustomerDetails> getAllCustomerByStatus() {

		return jdbc.query(GET_CUSTOMER_BY_STATUS, new CustomerDetailsRowMapper());
	}

	@Override
	public boolean updateCustomerStatus(CustomerDetails putCustomeStatus) {

		Object args[] = { putCustomeStatus.getCustomerStatus(), putCustomeStatus.getCustomerId() };

		int count = jdbc.update(PUT_CUSTOMER_STATUS, args);

		if (count > 0)
			return true;

		return false;

	}

}

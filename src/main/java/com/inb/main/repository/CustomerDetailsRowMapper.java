package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.LoginDetails;

public class CustomerDetailsRowMapper implements RowMapper<CustomerDetails> {

	@Override
	public CustomerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
//		LoginDetails loginDetails= new LoginDetails();
		CustomerDetails customerDetails = new CustomerDetails();

		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserId(rs.getString("user_id"));
		customerDetails.setLoginDetails(loginDetails);

		customerDetails.setCustomerId(rs.getString("customer_id"));
		customerDetails.setFirstName(rs.getString("first_name"));
		customerDetails.setLastName(rs.getString("last_name"));
		customerDetails.setAddressLine1(rs.getString("address_line_1"));
		customerDetails.setAddressLine2(rs.getString("address_line_2"));
		customerDetails.setAddressLine3(rs.getString("address_line_3"));
		customerDetails.setCity(rs.getString("city"));
		customerDetails.setState(rs.getString("state"));
		customerDetails.setZipcode(rs.getInt("zipcode"));
		customerDetails.setLandLine(rs.getInt("landLine"));
		customerDetails.setMobileNumber(rs.getLong("mobile"));
		customerDetails.setEmailId(rs.getString("email"));
		customerDetails.setCustomerStatus(rs.getString("customer_status"));
		return customerDetails;

	}

}

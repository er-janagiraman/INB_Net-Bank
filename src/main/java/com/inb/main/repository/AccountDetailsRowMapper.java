package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;

public class AccountDetailsRowMapper implements RowMapper<AccountDetails> {

	@Override
	public AccountDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomerDetails customerDetails = new CustomerDetails();

		AccountDetails accountDetails = new AccountDetails();

		accountDetails.setAccountId(rs.getInt("account_id"));
		customerDetails.setCustomerId(rs.getString("customer_id"));
		accountDetails.setCustomerDetails(customerDetails);
		accountDetails.setTypeOfAccount(rs.getString("type_of_account"));
		accountDetails.setAccountStatus(rs.getString("account_status"));
		accountDetails.setCurrentBalance(rs.getDouble("current_balance"));
		accountDetails.setMinimumBalance(rs.getDouble("minimum_balance"));
		accountDetails.setRateOfInterest(rs.getDouble("rate_of_interest"));
		accountDetails.setOverDraft(rs.getDouble("overdraft"));
		accountDetails.setOpeningDate(rs.getDate("opening_date").toLocalDate());

		return accountDetails;

	}

}

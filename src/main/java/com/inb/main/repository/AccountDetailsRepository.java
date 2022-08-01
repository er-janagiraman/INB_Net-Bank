package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.service.AccountDetailsService;

@Repository
public class AccountDetailsRepository implements AccountDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String GET_ACCOUNT_DETAILS = "select * from account_details where customer_id=?";

	private static final String ADD_NEW_ACCOUNT_DETAILS = "INSERT INTO account_details VALUES(?,?,?,?,?,?,?,?,?)";

	private static final String GET_ALL_ACCOUNTS = "select * from account_details ";

	private static final String GET_ACCOUNT_DETAILS_BY_CUSTOMER_ID = "SELECT * FROM account_details WHERE customer_id=? and account_status='approved'";

	private static final String DELETE_ACCOUNT = "delete account_details where customer_id =?";

	private static final String GET_PENDING_ACCOUNTS = "select * from account_details where account_status='pending'";

	private static final String GET_DECLINED_ACCOUNTS = "select * from account_details where account_status='Declined'";

	private static final String PUT_ACCOUNT_STATUS = "update account_details set account_status =? where customer_id = ?";

	private static final String OBJ_USERDATA = "select * from account_details where customer_id=?";

	private static final String ACCOUNTDETAILS_BY_ACCOUNTID = "select * from account_details where account_id=?";

	private static final String ADD_ACCOUNT_FOR_EXISTING_CUSTOMER = "INSERT INTO account_details VALUES(account_details_sequences.nextval,?,?,?,?,?,?,?,?)";

	private static final String UPDATE_ACCOUNT_BALANCE = "UPDATE account_details set current_balance = ? where account_id = ?";

	private static final String GET_ACCOUNT_NUMBER = "SELECT account_details_sequences.NEXTVAL FROM DUAL";

	@Override
	public AccountDetails validateAccount(AccountDetails accountDetails) {
		Object args[] = { accountDetails.getCustomerDetails().getCustomerId() };

		accountDetails = jdbc.queryForObject(GET_ACCOUNT_DETAILS, new AccountDetailsRowMapper(), args);

		return accountDetails;

	}

	@Override
	public boolean addNewAccountDetails(AccountDetails accountDetails) {

		Object args[] = { accountDetails.getAccountId(), accountDetails.getCustomerDetails().getCustomerId(),
				accountDetails.getTypeOfAccount(), accountDetails.getAccountStatus(),
				accountDetails.getCurrentBalance(), accountDetails.getMinimumBalance(),
				accountDetails.getRateOfInterest(), accountDetails.getOverDraft(), accountDetails.getOpeningDate() };
		int count = jdbc.update(ADD_NEW_ACCOUNT_DETAILS, args);
		if (count > 0)
			return true;
		return false;

	}

	@Override
	public List<AccountDetails> getAllAccountDetails() {

		return jdbc.query(GET_ALL_ACCOUNTS, new AccountDetailsRowMapper());
	}

	@Override
	public List<AccountDetails> getAccountDetailsByCustomerId(String customerId) {

		Object args[] = { customerId };
		return jdbc.query(GET_ACCOUNT_DETAILS_BY_CUSTOMER_ID, new AccountDetailsRowMapper(), args);

	}

	@Override
	public boolean deleteAccount(String customerId) {

		Object args[] = { customerId };

		int count = jdbc.update(DELETE_ACCOUNT, args);

		if (count > 0)
			return true;
		return false;

	}

	@Override
	public boolean updateAccountDetails(AccountDetails accountDetails) {
		Object args[] = { accountDetails.getCurrentBalance(), accountDetails.getAccountId() };

		int count = jdbc.update(UPDATE_ACCOUNT_BALANCE, args);

		if (count > 0)
			return true;
		return false;
	}

	@Override
	public List<AccountDetails> getPendingAccounts() {

		return jdbc.query(GET_PENDING_ACCOUNTS, new AccountDetailsRowMapper());
	}

	@Override
	public List<AccountDetails> getDeclinedAccounts() {

		return jdbc.query(GET_DECLINED_ACCOUNTS, new AccountDetailsRowMapper());

	}

	@Override
	public int getAccountId() {
		return jdbc.queryForObject(GET_ACCOUNT_NUMBER, Integer.class);
	}

	@Override
	public boolean updateAccountStatus(AccountDetails putAccountStatus) {
	

		Object args[] = { putAccountStatus.getAccountStatus(), putAccountStatus.getCustomerDetails().getCustomerId() };

		int count = jdbc.update(PUT_ACCOUNT_STATUS, args);

		if (count > 0)
			return true;
		
		return false;
	}

	@Override
	public AccountDetails getAccountDetailsByAccountId(int accountId) {
	
		Object args[] = { accountId };
		return jdbc.queryForObject(ACCOUNTDETAILS_BY_ACCOUNTID, new AccountDetailsRowMapper(), args);
	}

	

}

package com.inb.main.service;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;

public interface AccountDetailsServiceInterface {

	public AccountDetails validateAccount(AccountDetails accountDetails);

	boolean addNewAccountDetails(AccountDetails accountDetails);

	boolean deleteAccount(String customerId);

	List<AccountDetails> getAllAccountDetails();

	List<AccountDetails> getPendingAccounts();

	List<AccountDetails> getDeclinedAccounts();

	List<AccountDetails> getAccountDetailsByCustomerId(String customerId);

	boolean updateAccountDetails(AccountDetails accountDetails);

	public boolean updateAccountStatus(AccountDetails putAccountStatus);

	AccountDetails getAccountDetailsByAccountId(int accountId);

	int getAccountId();


}

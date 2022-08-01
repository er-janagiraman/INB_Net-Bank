package com.inb.main.repository;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;

public interface AccountDetailsRepositoryInterface {

	public AccountDetails validateAccount(AccountDetails accountDetails);

	boolean addNewAccountDetails(AccountDetails accountDetails);

	boolean deleteAccount(String customerId);

	List<AccountDetails> getAllAccountDetails();

	public List<AccountDetails> getAccountDetailsByCustomerId(String customerId);

	boolean updateAccountDetails(AccountDetails accountDetails);

	List<AccountDetails> getPendingAccounts();

	List<AccountDetails> getDeclinedAccounts();

	public boolean updateAccountStatus(AccountDetails putAccountStatus);

	AccountDetails getAccountDetailsByAccountId(int accountId);

	int getAccountId();

}

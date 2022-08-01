package com.inb.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.ChequeDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.repository.AccountDetailsRepositoryInterface;

@Service
public class AccountDetailsService implements AccountDetailsServiceInterface {

	@Autowired
	AccountDetailsRepositoryInterface accountDetailsRepositoryInterface;

	@Autowired
	ChequeDetailsServiceInterface chequeDetailsServiceInterface;

	@Override
	public AccountDetails validateAccount(AccountDetails accountDetails) {
		// TODO Auto-generated method stub

		return accountDetailsRepositoryInterface.validateAccount(accountDetails);

	}

	@Override
	public boolean addNewAccountDetails(AccountDetails accountDetails) {
		boolean status = false;
		if (accountDetails.getTypeOfAccount().equals("fd")) {
			status = accountDetailsRepositoryInterface.addNewAccountDetails(accountDetails);
		} else {
			int accountNumber = accountDetailsRepositoryInterface.getAccountId();
			accountDetails.setAccountId(accountNumber);
			status = accountDetailsRepositoryInterface.addNewAccountDetails(accountDetails);
			if (status) {
				for (int i = 0; i < 10; i++) {
					ChequeDetails chequeDetails = new ChequeDetails(accountDetails);
					chequeDetailsServiceInterface.addChequeDetails(chequeDetails);
				}
			}
		}
		return status;
	}

	@Override
	public List<AccountDetails> getAllAccountDetails() {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.getAllAccountDetails();
	}

	@Override
	public List<AccountDetails> getAccountDetailsByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.getAccountDetailsByCustomerId(customerId);
	}

	@Override
	public boolean deleteAccount(String customerId) {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.deleteAccount(customerId);
	}

	@Override
	public boolean updateAccountDetails(AccountDetails accountDetails) {
		return accountDetailsRepositoryInterface.updateAccountDetails(accountDetails);
	}

	@Override
	public List<AccountDetails> getPendingAccounts() {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.getPendingAccounts();
	}

	@Override
	public List<AccountDetails> getDeclinedAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountStatus(AccountDetails putAccountStatus) {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.updateAccountStatus(putAccountStatus);
	}

	@Override
	public AccountDetails getAccountDetailsByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.getAccountDetailsByAccountId(accountId);
	}

	@Override
	public int getAccountId() {
		// TODO Auto-generated method stub
		return accountDetailsRepositoryInterface.getAccountId();
	}

}

package com.inb.main.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.repository.AccountDetailsRowMapper;
import com.inb.main.service.AccountDetailsServiceInterface;
import com.inb.main.service.ChequeDetailsServiceInterface;
import com.inb.main.service.TransactionServiceInterface;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class AccountDetailsController {
	@Autowired
	AccountDetailsServiceInterface accountDetailsServiceInterface;

	@Autowired
	TransactionServiceInterface transactionServiceInterface;

	@RequestMapping(value = "accountdetails", method = RequestMethod.POST)
	public AccountDetails validateAccount(@RequestBody AccountDetails accountDetails) {

		return accountDetailsServiceInterface.validateAccount(accountDetails);

	}

	@RequestMapping(value = "accountdetails/addnew", method = RequestMethod.POST)
	public boolean addNewAccountDetails(@RequestBody AccountDetails accountDetails) {

		if (accountDetails.getTypeOfAccount().equals("fd")) {
			int fromAccountId = accountDetails.getAccountId();
			int accountId = accountDetailsServiceInterface.getAccountId();
			accountDetails.setAccountId(accountId);

			boolean fdAccountCreationStatus = accountDetailsServiceInterface.addNewAccountDetails(accountDetails);
			if (fdAccountCreationStatus) {
				TransactionDetails transactionDetails = new TransactionDetails();
				transactionDetails
						.setAccountId(accountDetailsServiceInterface.getAccountDetailsByAccountId(fromAccountId));
				transactionDetails
						.setAccountIdTo(accountDetailsServiceInterface.getAccountDetailsByAccountId(accountId));
				transactionDetails.setTransactionAmount(accountDetails.getCurrentBalance());
				transactionDetails.setTransactionDate(LocalDate.now());
				transactionDetails.setTransactionTime(LocalTime.now());
				transactionDetails.setTransactionType("fd");
				transactionServiceInterface.accountTransferTransaction(transactionDetails);
				return true;
			}
		} else {
			return accountDetailsServiceInterface.addNewAccountDetails(accountDetails);
		}
		return false;

	}

	@RequestMapping(value = "accountdetails/getall", method = RequestMethod.GET)
	public List<AccountDetails> getAllAccountDetails() {
		return accountDetailsServiceInterface.getAllAccountDetails();
	}

	@RequestMapping(value = "accountdetails/{customerId}", method = RequestMethod.GET)
	public List<AccountDetails> getAccountDetailsByCustomerId(@PathVariable String customerId) {
		return accountDetailsServiceInterface.getAccountDetailsByCustomerId(customerId);
	}

	@RequestMapping(value = "deleteaccount/{customerId}", method = RequestMethod.DELETE)
	public boolean deleteeAccount(@PathVariable String customerId) {
		return accountDetailsServiceInterface.deleteAccount(customerId);
	}

	@RequestMapping(value = "accountdetails/pendingaccounts", method = RequestMethod.GET)
	public List<AccountDetails> getPendingAccounts() {

		return accountDetailsServiceInterface.getPendingAccounts();
	}

	@RequestMapping(value = "accountdetails/declinedaccounts", method = RequestMethod.GET)
	public List<AccountDetails> getDeclinedAccounts() {

		return accountDetailsServiceInterface.getDeclinedAccounts();
	}

	@RequestMapping(value = "accountdetails/updatestatus", method = RequestMethod.PUT)
	public boolean updateAccountStatus(@RequestBody AccountDetails putAccountStatus) {

		return accountDetailsServiceInterface.updateAccountStatus(putAccountStatus);
	}

	@RequestMapping(value = "accountdetail/{accountId}", method = RequestMethod.GET)
	public AccountDetails getAccountDetailsByAccountId(@PathVariable int accountId) {

		return accountDetailsServiceInterface.getAccountDetailsByAccountId(accountId);
	}

}

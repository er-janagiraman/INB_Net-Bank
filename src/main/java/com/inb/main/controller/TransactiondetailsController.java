package com.inb.main.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.service.AccountDetailsServiceInterface;
import com.inb.main.service.TransactionServiceInterface;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class TransactiondetailsController {
	@Autowired
	TransactionServiceInterface transactionServiceInterface;
	@Autowired
	AccountDetailsServiceInterface accountDetailsServiceInterface;

	@RequestMapping(value = "transactiondetails/addnew", method = RequestMethod.POST)
	boolean addTransactionDetails(TransactionDetails transactionDetails) {
		return transactionServiceInterface.addTransactionDetails(transactionDetails);

	}

	@RequestMapping(value = "transactiondetails/getall", method = RequestMethod.GET)
	List<TransactionDetails> getAllTransactionDetails() {
		return transactionServiceInterface.getAllTransactionDetails();

	}

	@RequestMapping(value = "transactiondetails/{accountId}", method = RequestMethod.GET)
	public List<TransactionDetails> transactionDetailsByAccountId(@PathVariable String accountId) {
		return transactionServiceInterface.transactionDetailsByAccountId(accountId);
	}

	@RequestMapping(value = "transactiondetail/{transactionId}", method = RequestMethod.GET)
	public List<TransactionDetails> transactionDetailsByTransactiontId(@PathVariable int transactionId) {
		Object args[] = { transactionId };

		return transactionServiceInterface.transactionDetailsByTransactiontId(transactionId);
	}

	@RequestMapping(value = "transactiondetail/transfer", method = RequestMethod.PUT)
	public boolean accountTransferTransaction(@RequestBody TransactionDetails transactionDetails)

	{

		return transactionServiceInterface.accountTransferTransaction(transactionDetails);

	}

	@RequestMapping(value = "transactiondetail/fixeddeposite", method = RequestMethod.PUT)
	public boolean fixedDepositeTransaction(@RequestBody TransactionDetails transactionDetails) {

		return transactionServiceInterface.fixedDepositeTransaction(transactionDetails);

	}

}

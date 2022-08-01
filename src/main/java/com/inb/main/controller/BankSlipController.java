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
import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.ChequeDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.repository.BankSlipRowMapper;
import com.inb.main.service.AccountDetailsServiceInterface;
import com.inb.main.service.BankSlipService;
import com.inb.main.service.ChequeDetailsServiceInterface;
import com.inb.main.service.TransactionServiceInterface;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class BankSlipController {
	@Autowired
	BankSlipService bankSlipService;
	@Autowired
	AccountDetailsServiceInterface accountDetailsServiceInterface;
	@Autowired
	TransactionServiceInterface transactionServiceInterface;
	@Autowired
	ChequeDetailsServiceInterface chequeDetailsServiceInterface;

	@RequestMapping(value = "bankslip/addnew", method = RequestMethod.POST)
	public boolean addBankSlipDetails(@RequestBody BankSlipDetails bankSlipDetails) {
		return bankSlipService.addBankSlipDetails(bankSlipDetails);

	}

	@RequestMapping(value = "bankslip/getall", method = RequestMethod.GET)
	public List<BankSlipDetails> getAllBankSlipDetails() {

		return bankSlipService.getAllBankSlipDetails();
	}

	@RequestMapping(value = "bankslips/{chequeNo}", method = RequestMethod.GET)
	public BankSlipDetails getBankSlipByChequeNo(@PathVariable int chequeNo) {
		return bankSlipService.getBankSlipByChequeNo(chequeNo);

	}

	@RequestMapping(value = "bankslip/{accountId}", method = RequestMethod.GET)
	public List<BankSlipDetails> getBankSlipByAccountId(@PathVariable int accountId) {

		return bankSlipService.getBankSlipByAccountId(accountId);
	}

	@RequestMapping(value = "bankslip/chequedeposit", method = RequestMethod.PUT)
	public boolean chequeDepositTransaction(@RequestBody BankSlipDetails bankSlipDetails) {

		return bankSlipService.chequeDepositTransaction(bankSlipDetails);

	}

}

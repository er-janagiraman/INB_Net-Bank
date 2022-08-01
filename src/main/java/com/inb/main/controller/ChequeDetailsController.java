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
import com.inb.main.pojo.ChequeDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.repository.ChequeDetailsRowMapper;
import com.inb.main.service.AccountDetailsServiceInterface;
import com.inb.main.service.ChequeDetailsServiceInterface;
import com.inb.main.service.TransactionServiceInterface;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class ChequeDetailsController {

	@Autowired
	ChequeDetailsServiceInterface ChequeDetailsServiceInterface;
	@Autowired
	AccountDetailsServiceInterface accountDetailsServiceInterface;
	@Autowired
	TransactionServiceInterface transactionServiceInterface;

	@RequestMapping(value = "chequedetails/addnew", method = RequestMethod.POST)
	public boolean addChequeDetails(ChequeDetails chequeDetails) {

		return ChequeDetailsServiceInterface.addChequeDetails(chequeDetails);
	}

	@RequestMapping(value = "chequedetail/getall", method = RequestMethod.GET)
	public List<ChequeDetails> getAllChequeDetails() {

		return ChequeDetailsServiceInterface.getAllChequeDetails();
	}

	@RequestMapping(value = "chequedetails/{chequeNo}", method = RequestMethod.GET)
	public ChequeDetails getChequeDetailsByChequeNo(@PathVariable int chequeNo) {

		return ChequeDetailsServiceInterface.getChequeDetailsByChequeNo(chequeNo);
	}

	@RequestMapping(value = "cheque/{accountId}", method = RequestMethod.GET)
	public List<ChequeDetails> getChequeDetailsByAccountId(@PathVariable int accountId) {

		return ChequeDetailsServiceInterface.getChequeDetailsByAccountId(accountId);

	}

	@RequestMapping(value = "chequedetails/chequedeposite", method = RequestMethod.PUT)
	public boolean chequeDetailsUpdate(@RequestBody ChequeDetails chequeDetails) {

		return ChequeDetailsServiceInterface.chequeDetailsUpdate(chequeDetails);
	}

	@RequestMapping(value = "chequedetails/chequestatus", method = RequestMethod.GET)
	public List<ChequeDetails> getPendingCheque() {

		return ChequeDetailsServiceInterface.getPendingCheque();

	}

	@RequestMapping(value = "chequedetails/updatestatusbychequeno", method = RequestMethod.PUT)
	public boolean updateChequeStatus(@RequestBody ChequeDetails chequeDetails) {
		return ChequeDetailsServiceInterface.updateChequeStatus(chequeDetails);

	}

	@RequestMapping(value = "chequedetails/updatestatustoapproved", method = RequestMethod.PUT)
	public boolean updateChequeToApproved(@PathVariable int chequeNo) {
		// TODO Auto-generated method stub
		return ChequeDetailsServiceInterface.updateChequeToApproved(chequeNo);
	}

	@RequestMapping(value = "chequedetails/updatestatustobounced", method = RequestMethod.PUT)
	public boolean updateChequeToDeclined(@PathVariable int chequeNo) {
		// TODO Auto-generated method stub
		return ChequeDetailsServiceInterface.updateChequeToDeclined(chequeNo);
	}
}

package com.inb.main.service;

import java.util.List;

import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.ChequeDetails;
import com.inb.main.pojo.TransactionDetails;

public interface ChequeDetailsServiceInterface {

	boolean addChequeDetails(ChequeDetails chequeDetails);

	List<ChequeDetails> getAllChequeDetails();

	ChequeDetails getChequeDetailsByChequeNo(int chequeNo);

	List<ChequeDetails> getChequeDetailsByAccountId(int accountId);

	boolean chequeDetailsUpdate(ChequeDetails chequeDetails);

	List<ChequeDetails> getPendingCheque();

	boolean updateChequeDetails(ChequeDetails chequeDetails);

	boolean updateChequeStatus(ChequeDetails chequeDetails);

	boolean updateChequeToApproved(int chequeNo);

	boolean updateChequeToDeclined(int chequeNo);

}

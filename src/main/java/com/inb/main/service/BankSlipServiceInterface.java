package com.inb.main.service;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.TransactionDetails;

public interface BankSlipServiceInterface {
	
	boolean addBankSlipDetails(BankSlipDetails bankSlipDetails);

	List<BankSlipDetails> getAllBankSlipDetails();

	BankSlipDetails getBankSlipByChequeNo(int chequeNo);
	
	List<BankSlipDetails> getBankSlipByAccountId(int accountId);
	
	boolean chequeDepositTransaction(BankSlipDetails  bankSlipDetails);


}

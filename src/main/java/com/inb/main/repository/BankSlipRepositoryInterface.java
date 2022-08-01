package com.inb.main.repository;

import java.util.List;

import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.ChequeDetails;

public interface BankSlipRepositoryInterface {
	boolean addBankSlipDetails(BankSlipDetails bankSlipDetails);

	List<BankSlipDetails> getAllBankSlipDetails();

	BankSlipDetails getBankSlipByChequeNo(int chequeNo);

	List<BankSlipDetails> getBankSlipByAccountId(int accountId);

	boolean chequeDepositTransaction(BankSlipDetails bankSlipDetails);

}

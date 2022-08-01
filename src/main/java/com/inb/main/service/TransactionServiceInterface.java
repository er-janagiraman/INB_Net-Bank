package com.inb.main.service;

import java.util.List;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.TransactionDetails;

public interface TransactionServiceInterface {

	boolean addTransactionDetails(TransactionDetails transactionDetails);

	List<TransactionDetails> getAllTransactionDetails();

	List<TransactionDetails> transactionDetailsByAccountId(String accountId);

	List<TransactionDetails> transactionDetailsByTransactiontId(int transactionId);

	boolean accountTransferTransaction(TransactionDetails transactionDetails);

	boolean fixedDepositeTransaction(TransactionDetails transactionDetails);

}

package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.TransactionDetails;

@Repository
public class TransactiondetailsRepository implements TransactiondetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbc;
	private static final String ADD_NEW_TRANSACTION_DETAILS = "insert into transaction_details VALUES (TRANSACTION_ID_SEQUENCES.nextval,?,?,?,?,?,?)";

	private static final String GET_ALL_TRANSACTIONDETAILS = "select * from transaction_details";

	private static final String TRANSACTION_DETAILS_BY_ACCOUNTID = "select * from transaction_details where account_id > (SELECT MAX(transaction_id) - 5 FROM transaction_details) and  account_id=?  ORDER BY transaction_id ASC";

	private static final String TRANSACTION_DETAILS_BY_TRANSACTIONID = "select * from transaction_details where transaction_id=?";

	@Override
	public boolean addTransactionDetails(TransactionDetails transactionDetails) {
		Object args[] = { transactionDetails.getAccountId().getAccountId(),
				transactionDetails.getAccountIdTo().getAccountId(), transactionDetails.getTransactionAmount(),
				transactionDetails.getTransactionDate(), transactionDetails.getTransactionTime(),
				transactionDetails.getTransactionType() };
		int count = jdbc.update(ADD_NEW_TRANSACTION_DETAILS, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public List<TransactionDetails> getAllTransactionDetails() {

		return jdbc.query(GET_ALL_TRANSACTIONDETAILS, new TransactiondetailsRowMapper());
	}

	@Override
	public List<TransactionDetails> transactionDetailsByAccountId(String accountId) {

		Object args[] = { accountId };

		return jdbc.query(TRANSACTION_DETAILS_BY_ACCOUNTID, new TransactiondetailsRowMapper(), args);

	}

	@Override
	public List<TransactionDetails> transactionDetailsByTransactiontId(int transactionId) {
		Object args[] = { transactionId };

		return jdbc.query(TRANSACTION_DETAILS_BY_TRANSACTIONID, new TransactiondetailsRowMapper(), args);
	}

	@Override
	public boolean accountTransferTransaction(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fixedDepositeTransaction(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}

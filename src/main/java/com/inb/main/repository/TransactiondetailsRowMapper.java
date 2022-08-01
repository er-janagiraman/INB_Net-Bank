package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.TransactionDetails;

public class TransactiondetailsRowMapper implements RowMapper<TransactionDetails> {

	@Override
	public TransactionDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TransactionDetails transactionDetails = new TransactionDetails();

		transactionDetails.setTransactionId(rs.getInt("Transaction_id"));
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountId(rs.getInt("account_id"));

		AccountDetails accountDetailsTo = new AccountDetails();
		accountDetailsTo.setAccountId(rs.getInt("account_id_to"));

		transactionDetails.setAccountId(accountDetails);
		transactionDetails.setAccountIdTo(accountDetailsTo);

		transactionDetails.setTransactionAmount(rs.getDouble("transaction_amount"));
		transactionDetails.setTransactionDate(rs.getDate("transaction_date").toLocalDate());
		transactionDetails.setTransactionTime(rs.getTime("transaction_time").toLocalTime());
		transactionDetails.setTransactionType(rs.getString("transaction_type"));
		return transactionDetails;
	}

}

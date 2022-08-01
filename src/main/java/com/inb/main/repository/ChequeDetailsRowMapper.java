package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.ChequeDetails;

public class ChequeDetailsRowMapper implements RowMapper<ChequeDetails> {

	@Override
	public ChequeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		ChequeDetails ChequeDetails = new ChequeDetails();

		ChequeDetails.setChequeNo(rs.getInt("cheque_no"));
		AccountDetails accountDetails = new AccountDetails();

		accountDetails.setAccountId(rs.getInt("account_id"));
		ChequeDetails.setAccountId(accountDetails);

		AccountDetails accountDetailsTo = new AccountDetails();
		accountDetailsTo.setAccountId(rs.getInt("account_id_to"));
		ChequeDetails.setAccountIdTo(accountDetailsTo);

		ChequeDetails.setDepositeAmount(rs.getDouble("deposit_amount"));

		if (rs.getDate("cheque_date") != null) {
			ChequeDetails.setChequeDate(rs.getDate("cheque_date").toLocalDate());
		}
		ChequeDetails.setChequeStatus(rs.getString("cheque_status"));

		return ChequeDetails;
	}

}

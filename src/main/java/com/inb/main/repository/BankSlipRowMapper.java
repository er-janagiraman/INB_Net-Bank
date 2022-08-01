package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.ChequeDetails;

public class BankSlipRowMapper implements RowMapper<BankSlipDetails> {

	@Override
	public BankSlipDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		BankSlipDetails bankSlipDetails = new BankSlipDetails();

		bankSlipDetails.setBankSlipId(rs.getInt("bank_slip_id"));

		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountId(rs.getInt("account_id"));

		AccountDetails accountDetailsTo = new AccountDetails();
		accountDetailsTo.setAccountId(rs.getInt("account_id_to"));

		bankSlipDetails.setAccountId(accountDetails);
		bankSlipDetails.setAccountIdTo(accountDetailsTo);

		bankSlipDetails.setChequeNo(rs.getInt("cheque_no"));

		ChequeDetails chequeDetails = new ChequeDetails();
		chequeDetails.setDepositeAmount(rs.getDouble("deposit_amount"));
		bankSlipDetails.setChequeDetails(chequeDetails);

		return bankSlipDetails;
	}

}

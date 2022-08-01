package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.BankSlipDetails;

@Repository
public class BankSlipRepository implements BankSlipRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String ADD_BANKSLIP_DETAILS = "insert into bank_slip values (?,?,?,?,?)";

	private static final String GET_ALL_BANKSLIP = "select*from bank_slip ";

	private static final String GET_BANKSLIP_BY_CHEQUE_NO = "select*from bank_slip where cheque_no=?";

	private static final String GET_BANKSLIP_BY_ACCOUNT_ID = "select*from bank_slip where account_id=?";

	@Override
	public boolean addBankSlipDetails(BankSlipDetails bankSlipDetails) {
		Object args[] = { bankSlipDetails.getBankSlipId(), bankSlipDetails.getAccountId(),
				bankSlipDetails.getAccountIdTo(), bankSlipDetails.getChequeNo(),
				bankSlipDetails.getChequeDetails().getDepositeAmount() };
		int count = jdbc.update(ADD_BANKSLIP_DETAILS, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public List<BankSlipDetails> getAllBankSlipDetails() {

		return jdbc.query(GET_ALL_BANKSLIP, new BankSlipRowMapper());
	}

	@Override
	public BankSlipDetails getBankSlipByChequeNo(int chequeNo) {

		Object args[] = { chequeNo };
		return jdbc.queryForObject(GET_BANKSLIP_BY_CHEQUE_NO, new BankSlipRowMapper(), args);

	}

	@Override
	public List<BankSlipDetails> getBankSlipByAccountId(int accountId) {

		Object args[] = { accountId };

		return jdbc.query(GET_BANKSLIP_BY_ACCOUNT_ID, new BankSlipRowMapper(), args);
	}

	@Override
	public boolean chequeDepositTransaction(BankSlipDetails bankSlipDetails) {

		return false;
	}

}

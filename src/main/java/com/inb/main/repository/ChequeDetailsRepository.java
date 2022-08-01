package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.ChequeDetails;

@Repository
public class ChequeDetailsRepository implements ChequeDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String ADD_CHEQUE_DETAILS = "insert into cheque_details(cheque_no ,account_id , cheque_status) values(cheque_no_sequence.nextval,?,'new')";

	private static final String GET_ALL_CHEQUE_DETAILS = "select * from cheque_details";

	private static final String GET_CHEQUE_DETAILS_BY_CHEQUE_NO = "select * from cheque_details where cheque_no=?";

	private static final String GET_CHEQUE_DETAILS_BY_ACCOUNT_ID = "select * from cheque_details where account_id=? and cheque_status='new'";

	private static final String GET_CHEQUE_DETAILS_BY_CHEQUESTATUS = "select * from cheque_details where cheque_status='pending'";

	private static final String UPDATE_CHEQUE_DETAILS = "update cheque_details set account_id_to=? ,deposit_amount=?, cheque_date=?,cheque_status=? where cheque_no =?";

	private static final String UPDATE_CHEQUE_STATUS = "update cheque_details set cheque_status=? where cheque_no=? ";

	private static final String UPDATE_CHEQUE_STATUS_TO_APPROVED = "update cheque_details set cheque_status='cleared' where cheque_no=? ";

	private static final String UPDATE_CHEQUE_STATUS_TO_DECLINED = "update cheque_details set cheque_status='bounced' where cheque_no=? ";

	@Override
	public boolean addChequeDetails(ChequeDetails chequeDetails) {
		System.out.println(chequeDetails);
		Object[] args = { chequeDetails.getAccountId().getAccountId() };
		int count = jdbc.update(ADD_CHEQUE_DETAILS, args);

		if (count > 0)
			return true;

		return false;
	}

	@Override
	public List<ChequeDetails> getAllChequeDetails() {

		return jdbc.query(GET_ALL_CHEQUE_DETAILS, new ChequeDetailsRowMapper());
	}

	@Override
	public ChequeDetails getChequeDetailsByChequeNo(int chequeNo) {

		Object[] args = { chequeNo };

		return jdbc.queryForObject(GET_CHEQUE_DETAILS_BY_CHEQUE_NO, new ChequeDetailsRowMapper(), args);
	}

	@Override
	public List<ChequeDetails> getChequeDetailsByAccountId(int accounId) {

		Object[] args = { accounId };

		return jdbc.query(GET_CHEQUE_DETAILS_BY_ACCOUNT_ID, new ChequeDetailsRowMapper(), args);
	}

	@Override
	public boolean chequeDetailsUpdate(ChequeDetails chequeDetails) {

		return false;
	}

	@Override
	public List<ChequeDetails> getPendingCheque() {

		return jdbc.query(GET_CHEQUE_DETAILS_BY_CHEQUESTATUS, new ChequeDetailsRowMapper());
	}

	@Override
	public boolean updateChequeDetails(ChequeDetails chequeDetails) {
		Object args[] = { chequeDetails.getAccountIdTo().getAccountId(), chequeDetails.getDepositeAmount(),
				chequeDetails.getChequeDate(), chequeDetails.getChequeStatus(), chequeDetails.getChequeNo() };

		int count = jdbc.update(UPDATE_CHEQUE_DETAILS, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateChequeStatus(ChequeDetails chequeDetails) {

		Object args[] = { chequeDetails.getChequeStatus(), chequeDetails.getChequeNo() };

		int count = jdbc.update(UPDATE_CHEQUE_STATUS, args);

		if (count > 0)
			return true;
		return false;

	}

	@Override
	public boolean updateChequeToApproved(int chequeNo) {

		Object[] args = { chequeNo };

		int count = jdbc.update(UPDATE_CHEQUE_STATUS_TO_APPROVED, args);

		if (count > 0)

			return true;

		return false;
	}

	@Override
	public boolean updateChequeToDeclined(int chequeNo) {
		Object[] args = { chequeNo };

		int count = jdbc.update(UPDATE_CHEQUE_STATUS_TO_DECLINED, args);

		if (count > 0)

			return true;

		return false;
	}

}

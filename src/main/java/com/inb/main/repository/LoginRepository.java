package com.inb.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inb.main.pojo.LoginDetails;

@Repository
public class LoginRepository implements LoginRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbc;

	private static final String VALIDATE_LOGIN = "select* from login_details where user_id=? and password=?";
	private static final String ADD_NEW_LOGIN_DETAILS = "INSERT INTO login_details VALUES (?,?,?)";
	private static final String GET_ALL_LOGIN_DETAILS = " SELECT * FROM login_details";
	private static final String GET_LOGIN_DETAILS_BY_USERID = " SELECT * FROM login_details WHERE user_id=?";
	private static final String GET_NEXT_USER_ID = "SELECT user_id_sequence.nextval FROM dual";

	@Override
	public LoginDetails validUser(LoginDetails loginDetails) {

	
		Object args[] = { loginDetails.getUserId(), loginDetails.getPassword() };

		loginDetails = jdbc.queryForObject(VALIDATE_LOGIN, new LoginRowMapper(), args);

	

		return loginDetails;

	}

	public boolean addNewLogindetails(LoginDetails loginDetails) {
		Object args[] = {loginDetails.getUserId(), loginDetails.getPassword(), loginDetails.getRole() };

		int count = jdbc.update(ADD_NEW_LOGIN_DETAILS, args);

		if (count > 0)

			return true;

		return false;

	}

	public List<LoginDetails> getAllLoginDetails() {

		return jdbc.query(GET_ALL_LOGIN_DETAILS, new LoginRowMapper());
	}

	public LoginDetails getLoginDetailsByuserId(String customerId) {
		Object args[] = { customerId };
		return jdbc.queryForObject(GET_LOGIN_DETAILS_BY_USERID, new LoginRowMapper(), args);
	}

	@Override
	public LoginDetails generateNextLoginDetails() {
		LoginDetails loginDetails = new LoginDetails();
		int nextuserId = jdbc.queryForObject(GET_NEXT_USER_ID, Integer.class);
		loginDetails.setUserId("INB" + nextuserId);
		return loginDetails;
	}

}

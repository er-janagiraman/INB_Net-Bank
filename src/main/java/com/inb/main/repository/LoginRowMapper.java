package com.inb.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inb.main.pojo.LoginDetails;

public class LoginRowMapper implements RowMapper<LoginDetails> {

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		LoginDetails logindetails = new LoginDetails();
		logindetails.setUserId(rs.getString("user_id"));
		logindetails.setPassword(rs.getString("password"));
		logindetails.setRole(rs.getString("role"));
		return logindetails;
	}

}

package com.inb.main.repository;

import java.util.List;

import com.inb.main.pojo.LoginDetails;

public interface LoginRepositoryInterface {

	public LoginDetails validUser(LoginDetails loginDetails);

	boolean addNewLogindetails(LoginDetails loginDetails);

	List<LoginDetails> getAllLoginDetails();

	LoginDetails getLoginDetailsByuserId(String userId);

	LoginDetails generateNextLoginDetails();
}

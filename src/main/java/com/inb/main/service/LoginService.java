package com.inb.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.LoginDetails;
import com.inb.main.repository.LoginRepositoryInterface;

@Service
public class LoginService implements LoginInterfaceService {

	@Autowired
	LoginRepositoryInterface loginRepository;

	public LoginDetails validUser(LoginDetails loginDetails) {
		System.out.println("in service");

		return loginRepository.validUser(loginDetails);
	}

	public boolean addNewLogindetails(LoginDetails loginDetails) {
		return loginRepository.addNewLogindetails(loginDetails);
	}

	public List<LoginDetails> getAllLoginDetails() {
		return loginRepository.getAllLoginDetails();
	}

	public LoginDetails getLoginDetailsByuserId(String userId) {
		return loginRepository.getLoginDetailsByuserId(userId);
	}

	@Override
	public LoginDetails generateNextLoginDetails() {
		return loginRepository.generateNextLoginDetails();
	}

}

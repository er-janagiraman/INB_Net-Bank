package com.inb.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inb.main.pojo.LoginDetails;
import com.inb.main.service.LoginInterfaceService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("netbankingapi")
public class LoginDetailsController {

	@Autowired
	LoginInterfaceService loginInterfaceService;

	@RequestMapping(value = "logindetails", method = RequestMethod.POST)
	public LoginDetails login(@RequestBody LoginDetails loginDetails) {

		return loginInterfaceService.validUser(loginDetails);
	}

	@RequestMapping(value = "logindetails/addnew", method = RequestMethod.POST)
	public boolean NewloginDetails(@RequestBody LoginDetails loginDetails) {

		return loginInterfaceService.addNewLogindetails(loginDetails);
	}

	@RequestMapping(value = "logindetails/getall", method = RequestMethod.GET)
	public List<LoginDetails> getAllLoginDetails() {
		return loginInterfaceService.getAllLoginDetails();
	}

	@RequestMapping(value = "logindetails/{userId}", method = RequestMethod.GET)
	public LoginDetails getLoginDetailsByuserId(@PathVariable String userId) {
		return loginInterfaceService.getLoginDetailsByuserId(userId);
	}

	@RequestMapping(value = "logindetails/getnextuserid", method = RequestMethod.GET)
	public LoginDetails getNewUserId() {

		return loginInterfaceService.generateNextLoginDetails();
	}

}

package com.inb.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inb.main.pojo.CustomerDetails;
import com.inb.main.service.AccountDetailsServiceInterface;
import com.inb.main.service.EmailNotificationService;

@CrossOrigin("http://localhost:4200")
@RequestMapping("netbankingapi")
@RestController
public class EmailController {

	@Autowired
	private EmailNotificationService emailNotificationService;
	@Autowired
	AccountDetailsServiceInterface accountDetailsServiceInterface;

	@RequestMapping(value = "sendmail", method = RequestMethod.POST)
	public boolean sendMail(@RequestBody CustomerDetails customerDetails) {

		emailNotificationService.sendMail(customerDetails);
		return true;
	}

}

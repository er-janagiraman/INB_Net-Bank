package com.inb.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.CustomerDetails;

@Service
public class EmailNotificationService {

	@Autowired
	private JavaMailSender javaMailSender;

	public SimpleMailMessage sendMail(CustomerDetails customerDetails) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("mahaboomech@gmail.com");
		mailMessage.setTo(customerDetails.getEmailId());
		mailMessage.setSubject("Account Activated");
		mailMessage.setText("Congratulations!!"
				+ "Dear customer,your account has been activated successfully .You may check the details on INB NETBANKING .");
		javaMailSender.send(mailMessage);
		return mailMessage;

	}

}

package com.inb.main.pojo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDetails {
	private int transactionId;
	private AccountDetails accountId;
	private AccountDetails accountIdTo;
	private double transactionAmount;
	private LocalDate transactionDate;
	private LocalTime transactionTime;
	private String transactionType;

	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails(int transactionId, AccountDetails accountId, AccountDetails accountIdTo,
			double transactionAmount, LocalDate transactionDate, LocalTime transactionTime, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.accountIdTo = accountIdTo;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.transactionType = transactionType;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public AccountDetails getAccountId() {
		return accountId;
	}

	public void setAccountId(AccountDetails accountId) {
		this.accountId = accountId;
	}

	public AccountDetails getAccountIdTo() {
		return accountIdTo;
	}

	public void setAccountIdTo(AccountDetails accountIdTo) {
		this.accountIdTo = accountIdTo;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", accountId=" + accountId + ", accountIdTo="
				+ accountIdTo + ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionTime=" + transactionTime + ", transactionType=" + transactionType + "]";
	}

}

package com.inb.main.pojo;

import java.time.LocalDate;

public class ChequeDetails {

	private int chequeNo;
	private AccountDetails accountId;
	private AccountDetails accountIdTo;
	private double depositeAmount;
	private LocalDate chequeDate = LocalDate.now();
	private String chequeStatus;

	public ChequeDetails() {
		// TODO Auto-generated constructor stub
	}

	public ChequeDetails(AccountDetails accountId) {
		super();
		this.accountId = accountId;

	}

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
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

	public double getDepositeAmount() {
		return depositeAmount;
	}

	public void setDepositeAmount(double depositeAmount) {
		this.depositeAmount = depositeAmount;
	}

	public LocalDate getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	@Override
	public String toString() {
		return "ChequeDetails [chequeNo=" + chequeNo + ", accountId=" + accountId + ", accountIdTo=" + accountIdTo
				+ ", depositeAmount=" + depositeAmount + ", chequeDate=" + chequeDate + ", chequeStatus=" + chequeStatus
				+ "]";
	}

}

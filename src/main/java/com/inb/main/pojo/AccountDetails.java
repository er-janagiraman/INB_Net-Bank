package com.inb.main.pojo;

import java.time.LocalDate;

public class AccountDetails {
	private int accountId;
	private CustomerDetails customerDetails;
	private String typeOfAccount;
	private String accountStatus;
	private double currentBalance;
	private double minimumBalance;
	private double rateOfInterest;
	private double overDraft;
	private LocalDate openingDate;

	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}

	public AccountDetails(int accountId) {
		super();
		this.accountId = accountId;
	}

	public AccountDetails(int accountId, CustomerDetails customerDetails, String typeOfAccount, String accountStatus,
			double currentBalance, double minimumBalance, double rateOfInterest, double overDraft,
			LocalDate openingDate) {
		super();
		this.accountId = accountId;
		this.customerDetails = customerDetails;
		this.typeOfAccount = typeOfAccount;
		this.accountStatus = accountStatus;
		this.currentBalance = currentBalance;
		this.minimumBalance = minimumBalance;
		this.rateOfInterest = rateOfInterest;
		this.overDraft = overDraft;
		this.openingDate = openingDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountId=" + accountId + ", customerDetails=" + customerDetails + ", typeOfAccount="
				+ typeOfAccount + ", accountStatus=" + accountStatus + ", currentBalance=" + currentBalance
				+ ", minimumBalance=" + minimumBalance + ", rateOfInterest=" + rateOfInterest + ", overDraft="
				+ overDraft + ", openingDate=" + openingDate + "]";
	}

}

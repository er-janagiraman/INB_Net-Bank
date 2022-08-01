package com.inb.main.pojo;

public class BankSlipDetails {
	private int bankSlipId;
	private AccountDetails accountId;
	private AccountDetails accountIdTo;
	private int chequeNo;
	private ChequeDetails chequeDetails;

	public BankSlipDetails() {
		// TODO Auto-generated constructor stub
	}

	public BankSlipDetails(int bankSlipId, AccountDetails accountId, AccountDetails accountIdTo, int chequeNo,
			ChequeDetails chequeDetails) {
		super();
		this.bankSlipId = bankSlipId;
		this.accountId = accountId;
		this.accountIdTo = accountIdTo;
		this.chequeNo = chequeNo;
		this.chequeDetails = chequeDetails;
	}

	public int getBankSlipId() {
		return bankSlipId;
	}

	public void setBankSlipId(int bankSlipId) {
		this.bankSlipId = bankSlipId;
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

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public ChequeDetails getChequeDetails() {
		return chequeDetails;
	}

	public void setChequeDetails(ChequeDetails chequeDetails) {
		this.chequeDetails = chequeDetails;
	}

	@Override
	public String toString() {
		return "BankSlipDetails [bankSlipId=" + bankSlipId + ", accountId=" + accountId + ", accountIdTo=" + accountIdTo
				+ ", chequeNo=" + chequeNo + ", chequeDetails=" + chequeDetails + "]";
	}

}

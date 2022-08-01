package com.inb.main.pojo;

public class CustomerDetails {
	private String customerId;
	private LoginDetails loginDetails;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private int zipcode;
	private int landLine;
	private long mobileNumber;
	private String emailId;
	private String customerStatus;

	public CustomerDetails() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDetails(String customerId, LoginDetails loginDetails, String firstName, String lastName,
			String addressLine1, String addressLine2, String addressLine3, String city, String state, int zipcode,
			int landLine, long mobileNumber, String emailId, String customerStatus) {
		super();
		this.customerId = customerId;
		this.loginDetails = loginDetails;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.landLine = landLine;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.customerStatus = customerStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getLandLine() {
		return landLine;
	}

	public void setLandLine(int landLine) {
		this.landLine = landLine;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", loginDetails=" + loginDetails + ", firstName="
				+ firstName + ", lastName=" + lastName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", addressLine3=" + addressLine3 + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", landLine=" + landLine + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", customerStatus=" + customerStatus + "]";
	}

}

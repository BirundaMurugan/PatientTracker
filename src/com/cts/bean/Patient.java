package com.cts.bean;

public class Patient {
	
	private String patientId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String dob;
	private long contactNo;
	private long altContactNo;
	private String emailID;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private long zipCode;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public long getAltContactNo() {
		return altContactNo;
	}
	public void setAltContactNo(long altContactNo) {
		this.altContactNo = altContactNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipcode() {
		return zipCode;
	}
	public void setZipcode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	public String toString()
	{
		return patientId + " "+ firstName + " " +lastName ;
		
	}
	

}

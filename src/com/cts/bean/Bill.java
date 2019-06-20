package com.cts.bean;

public class Bill {
	 private int bill_id;
	 private String patient_id;
	 private String doctor_id;
	 private String bill_date;
	 private int medicine_id;
	 private int quantity;
	 private int amount;
	 private int total_Amount;
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal_Amount() {
		return total_Amount;
	}
	public void setTotal_Amount(int total_Amount) {
		this.total_Amount = total_Amount;
	}
	public Bill(int bill_id, String patient_id, String doctor_id, String bill_date, int medicine_id, int quantity,
			int amount) {
		super();
		this.bill_id = bill_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.bill_date = bill_date;
		this.medicine_id = medicine_id;
		this.quantity = quantity;
		this.amount = amount;
	}
	 
}


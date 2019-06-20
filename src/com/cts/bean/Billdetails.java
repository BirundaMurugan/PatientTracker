package com.cts.bean;

public class Billdetails {
	private int medicineId;
	private String medicineName;
	private int amount;
	private int quantity;
	private int total;
	public Billdetails()
	{
		
	}
	public Billdetails(int medicineId, String medicineName, int amount, int quantity, int total) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.amount = amount;
		this.quantity = quantity;
		this.total = total;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

}

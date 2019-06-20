package com.cts.bean;

public class Prescription {
	private int requestId;
	private String patientId;
	private String doctorId;
	private String requestdate;
	private int medicineId1;
	private int quantity1;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	public int getMedicineId1() {
		return medicineId1;
	}
	public void setMedicineId1(int medicineId1) {
		this.medicineId1 = medicineId1;
	}
	public int getQuantity1() {
		return quantity1;
	}
	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}
	public Prescription(int requestId, String patientId, String doctorId, String requestdate, int medicineId1,
			int quantity1,String status) {
		super();
		this.requestId = requestId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.requestdate = requestdate;
		this.medicineId1 = medicineId1;
		this.quantity1 = quantity1;
		this.status = status;
	}
}

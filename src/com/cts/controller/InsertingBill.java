package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.MedicineDao;
import com.cts.bean.Medicine;
import com.cts.bean.Prescription;

/**
 * Servlet implementation class InsertingBill
 */
@WebServlet("/InsertingBill")
public class InsertingBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertingBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String ButtonData = request.getParameter("Button1");
		System.out.println("Button Data "+ButtonData);
		PrintWriter out = response.getWriter();
		com.cts.Dao.PrescriptionDAO prescriptionDAO = new com.cts.Dao.PrescriptionDAO();
		Prescription prescription = null;
		MedicineDao medicineDAO = new MedicineDao();
		Medicine medicine = null;
		List<Prescription> prescriptionList = null;
		try {
			prescription = prescriptionDAO.read(request.getParameter("presid"));
			 medicine = medicineDAO.read(prescription.getMedicineId1());
			 prescriptionList = prescriptionDAO.readall();
			 request.setAttribute("prescriptionList", prescriptionList);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
			String sql = "insert into bill(Patient_ID, Doctor_ID, Bill_Date, Medicine_ID, Quantity, Amount,total_amount) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, prescription.getPatientId());
			ps.setString(2, prescription.getDoctorId());
			ps.setString(3, prescription.getRequestdate());
			ps.setInt(4, prescription.getMedicineId1());
			ps.setInt(5, prescription.getQuantity1());
			ps.setInt(6, medicine.getAmount());
			ps.setInt(7, 0);
			int insertStatus = ps.executeUpdate();
			request.setAttribute("patient_id", prescription.getPatientId());
			request.setAttribute("Doctor_id", prescription.getDoctorId());
			
			System.out.println(prescription.getRequestId());
			if(insertStatus!=0)
			{
				if(ButtonData.equals("Edit Details"))
				{
					System.out.println(prescription.getRequestId());
					request.setAttribute("presId", prescription.getRequestId());
					RequestDispatcher rq = request.getRequestDispatcher("/EditBillDetailsForm");
					rq.forward(request, response);
				}
				out.println("SuccessFully Registered");
				RequestDispatcher rq = request.getRequestDispatcher("BillTable");
				rq.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

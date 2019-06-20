package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.MedicineDao;
import com.cts.bean.Medicine;


/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertMedicine")
public class InsertMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMedicine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		MedicineDao medDAO = new MedicineDao();
		try {
			Medicine m = new Medicine();
			String desc = request.getParameter("desc");
			String purpose= request.getParameter("purpose");
			String mancomp = request.getParameter("mancomp");
			int dosage =Integer.parseInt( request.getParameter("dosage"));
			String presc = request.getParameter("presc");
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			
			m.setDescription(desc);
			m.setPurpose(purpose);
			m.setManufacturingCompany(mancomp);
			m.setDosage(dosage);
			m.setPrescription(presc);
			m.setAmount(amount);
			
			int insertStatus = 0;
			insertStatus= medDAO.insert(m);		
			if(insertStatus!=0) {
				response.sendRedirect("DisplayMedicineDetails");
			}
			else
			{
				out.print("Unable to insert data! Recheck!!!");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

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

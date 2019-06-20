package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.BillDAO;
import com.cts.Dao.PrescriptionDAO;
import com.cts.bean.Bill;

/**
 * Servlet implementation class EditBillDetailsForm
 */
@WebServlet("/EditBillDetailsForm")
public class EditBillDetailsForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBillDetailsForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
		String p_id = null;
		Bill bill = null;
		try {
			p_id = prescriptionDAO.read(request.getAttribute("presId").toString()).getPatientId();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BillDAO billDAO = new BillDAO();
		try {
			 bill = billDAO.readByPID(p_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("billObj", bill);
		RequestDispatcher rq = request.getRequestDispatcher("/EditBillDetailsjsp.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

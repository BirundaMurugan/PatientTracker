package com.cts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cts.bean.Prescription;

/**
 * Servlet implementation class ReturningPerscriptionListToJSP
 */
@WebServlet("/ReturningPerscriptionListToJSP")
public class ReturningPerscriptionListToJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturningPerscriptionListToJSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		com.cts.Dao.PrescriptionDAO prescriptionDAO = new com.cts.Dao.PrescriptionDAO();
		List<Prescription> prescriptionList = null;
		try {
			prescriptionList = prescriptionDAO.readall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prescriptionList",prescriptionList);
		RequestDispatcher rd = request.getRequestDispatcher("/ToGenerateBill.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

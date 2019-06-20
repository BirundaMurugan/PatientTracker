package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.PatientDao;
import com.cts.bean.Patient;

/**
 * Servlet implementation class ViewPatientData
 */
@WebServlet("/ViewPatientData")
public class ViewPatientData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewPatientData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		PatientDao pd = new PatientDao();
		List<Patient> patients = null;
		try {
			patients = pd.readAll();
			request.setAttribute("PatientData", patients);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewPatientData.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.AdminDao;
import com.cts.Dao.PatientDao;
import com.cts.bean.Admin;
import com.cts.bean.Patient;

/**
 * Servlet implementation class InsertAdminData
 */
@WebServlet("/InsertAdminData")
public class InsertAdminData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertAdminData() {
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
		AdminDao ad = new AdminDao();
		try {
			int insertStatus=0;
			Admin a = new Admin();
			String adminId = request.getParameter("Admin_Id");
			String firstName = request.getParameter("First_Name");
			String lastName = request.getParameter("Last_name");
			int age = Integer.parseInt(request.getParameter("Age"));
			System.out.println(request.getParameter("Age"));
			String gender = request.getParameter("Gender");
			String dob = request.getParameter("DOB");
			long contactNo = Long.parseLong(request.getParameter("Contact_Number"));
			long altConatactNo = Long.parseLong(request.getParameter("Alt_No"));
			String emailId = request.getParameter("Email_Id");
			String password = request.getParameter("Password");
			a.setAdminId(adminId);
			a.setFirstName(firstName);
			a.setLastName(lastName);
			a.setAge(age);
			a.setGender(gender);
			a.setDob(dob);
			a.setContactNo(contactNo);
			a.setAltContactNo(altConatactNo);
			a.setEmailId(emailId);
			a.setPassword(password);
			
			insertStatus = ad.insert(a);

			if (insertStatus != 0) {
				response.sendRedirect("index.html");
			} else {
				out.print("unable to Insert...Data");
			}

			//System.out.println("Successfully Inserted");
		} catch (Exception e) {
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

package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.ClerkDAO;
import com.cts.bean.Clerk;

/**
 * Servlet implementation class UpdateClerkData
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateClerkData")
public class UpdateClerkData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateClerkData() {
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
		ClerkDAO clerkDAO = new ClerkDAO();
		try {
			Clerk c = new Clerk();
            int clerkId = Integer.parseInt(request.getParameter("clerkId"));
            System.out.println(request.getParameter("clerkId"));
			String First_Name = request.getParameter("First_Name");
			String Last_Name = request.getParameter("Last_Name");
			int Age = Integer.parseInt(request.getParameter("Age"));
			String Gender = request.getParameter("Gender");
			String DOB = request.getParameter("DOB");
			Long Contact_No = Long.parseLong(request.getParameter("Contact_No"));
			Long Alt_Contact_No = Long.parseLong(request.getParameter("Alt_Contact_No"));
			String Email_id = request.getParameter("Email_id");
			String Address_Line1 = request.getParameter("Address_Line1");
			String Address_Line2 = request.getParameter("Address_Line2");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			int ZipCode = Integer.parseInt(request.getParameter("ZipCode"));
			
            c.setClerkId(clerkId);
			c.setFirst_Name(First_Name);
			c.setLast_Name(Last_Name);
			c.setAge(Age);
			c.setDOB(DOB);
			c.setContact_No(Contact_No);
			c.setAlt_Contact_No(Alt_Contact_No);
			c.setEmail_id(Email_id);
			c.setAddress_Line1(Address_Line1);
			c.setAddress_line2(Address_Line2);
			c.setCity(City);
			c.setState(State);
			c.setZipCode(ZipCode);
			int UpdateStatus = 0;
			UpdateStatus = clerkDAO.update(c);
			if (UpdateStatus != 0) {
				response.sendRedirect("ViewClerkData");

			} else
				out.println("Unable to Update Data");

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

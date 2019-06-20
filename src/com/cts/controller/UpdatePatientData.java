package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.PatientDao;
import com.cts.bean.Patient;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdatePatientData")
public class UpdatePatientData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePatientData() {
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
		try {
			int updateStatus = 0;

			Patient pt = new Patient();

			String patientId = request.getParameter("Patient_Id");
			String firstName = request.getParameter("First_Name");
			String lastName = request.getParameter("Last_Name");
			int age = Integer.parseInt(request.getParameter("Age"));
			//System.out.println(request.getParameter("Age"));
			String gender = request.getParameter("Gender");
			String dob = request.getParameter("DOB");
			long contactNo = Long.parseLong(request.getParameter("Contact_Number"));
			long altConatactNo = Long.parseLong(request.getParameter("Alt_No"));
			String emailId = request.getParameter("Email_Id");
			String addressLine1 = request.getParameter("Address_Line1");
			String addressLine2 = request.getParameter("Address_Line2");
			String city = request.getParameter("City");
			String state = request.getParameter("State");
			long zipcode = Long.parseLong(request.getParameter("zipcode"));
			
			
			
			pt.setPatientId(patientId);
			pt.setFirstName(firstName);
			pt.setLastName(lastName);
			pt.setAge(age);
			pt.setGender(gender);
			pt.setDob(dob);
			pt.setContactNo(contactNo);
			pt.setAltContactNo(altConatactNo);
			pt.setEmailID(emailId);
			pt.setAddressLine1(addressLine1);
			pt.setAddressLine2(addressLine2);
			pt.setCity(city);
			pt.setState(state);
			pt.setZipcode(zipcode);

		 
			
			updateStatus=pd.update(pt);
			if (updateStatus != 0) {
				response.sendRedirect("ViewPatientData");
			} else {
				out.print("unable to Update...Data");
			}

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

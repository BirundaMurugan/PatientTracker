package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.DoctorDAO;
import com.cts.bean.Doctor;

/**
 * Servlet implementation class UpdateDoctorData
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
@WebServlet("/UpdateDoctorData")
public class UpdateDoctorData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		DoctorDAO doctorDAO = new DoctorDAO();
		try {
			Doctor d = new Doctor();
			//String docid = request.getParameter("Doctor_Id");
			//System.out.println("Doctor ID"+docid);
            int Doctor_Id = Integer.parseInt(request.getParameter("Doctor_Id"));
			String First_Name = request.getParameter("First_Name");
			String Last_Name = request.getParameter("Last_Name");
			int Age = Integer.parseInt(request.getParameter("Age"));
			String Gender = request.getParameter("Gender");
			String Date_Of_Birth = request.getParameter("Date_Of_Birth");
			Long Contact_No = Long.parseLong(request.getParameter("Contact_No"));
			Long Alternate_Contact_No = Long.parseLong(request.getParameter("Alternate_Contact_No"));
			String Email_Id = request.getParameter("Email_Id");
			String Address_Line1 = request.getParameter("Address_Line1");
			String Address_Line2 = request.getParameter("Address_Line2");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			//System.out.println(request.getParameter("Zip_Code"));
			int Zip_Code = Integer.parseInt(request.getParameter("Zip_Code"));
			
			String Degree=request.getParameter("Degree");
			String Speciaility=request.getParameter("Speciality");
			String Work_Hours=request.getParameter("Work_Hours");
			String Hospital_Name=request.getParameter("Hospital_Name");
            d.setDoctor_Id(Doctor_Id);
			d.setFirst_Name(First_Name);
			d.setLast_Name(Last_Name);
			d.setAge(Age);
			d.setGender(Gender);
			d.setDate_Of_Birth(Date_Of_Birth);
			d.setContact_No(Contact_No);
			d.setAlternate_Contact_No(Alternate_Contact_No);
			d.setEmail_Id(Email_Id);
			d.setAddress_Line1(Address_Line1);
			d.setAddress_Line2(Address_Line2);
			d.setCity(City);
			d.setState(State);
			d.setZip_Code(Zip_Code);
			d.setDegree(Degree);
			d.setSpeciality(Speciaility);
			d.setWork_Hours(Work_Hours);
			d.setHospital_Name(Hospital_Name);
			int UpdateStatus = 0;
			UpdateStatus = doctorDAO.update(d);
			if (UpdateStatus != 0) {
				response.sendRedirect("ViewDoctorData");

			} else
				out.println("Unable to Update Data");

		} catch (Exception e) {
			e.printStackTrace();

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

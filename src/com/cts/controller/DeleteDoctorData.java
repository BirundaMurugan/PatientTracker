package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.ClerkDAO;
import com.cts.Dao.DoctorDAO;
import com.cts.bean.Doctor;
import com.cts.bean.Medicine;

/**
 * Servlet implementation class DeleteDoctorData
 */
@WebServlet("/DeleteDoctorData")
public class DeleteDoctorData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctorData() {
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
		DoctorDAO da=new DoctorDAO();
		try
		{
			Doctor d=new Doctor();
			int id = Integer.parseInt(request.getParameter("Doctor_Id"));
			//f.setFlowerId(id);
			int deleteStatus = 0;
			deleteStatus = da.delete(id);
			if(deleteStatus!=0)
			{
				response.sendRedirect("ViewDoctorData");
			}
			else
			{
				out.print("Unable to delete...Recheck!!");
			}
			
		}catch (Exception e)
		{
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

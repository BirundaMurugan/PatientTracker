package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertingPrescriptionDetails
 */
@WebServlet("/InsertingPrescriptionDetails")
public class InsertingPrescriptionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertingPrescriptionDetails() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
			String sql = "insert into prescription(Patient_ID,Doctor_ID,Request_date,Medicine_ID,Quantity,Status) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
//			int rid=Integer.parseInt(request.getParameter("rid"));
			String pid=request.getParameter("pid");
			String did=request.getParameter("did");
			String date=request.getParameter("date");
			request.setAttribute("p_id", pid);
			request.setAttribute("d_id", did);
			request.setAttribute("date_", date);
			int mid=Integer.parseInt(request.getParameter("mid"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			request.setAttribute("m_id", mid);
			request.setAttribute("quantity_",quantity);
			String status = "NO";
//			ps.setInt(1, rid);
            ps.setString(1, pid);
			ps.setString(2, did);
			ps.setString(3, date);
			ps.setInt(4, mid);
			ps.setInt(5,quantity);
			ps.setString(6,status);
			int excutionStatus = ps.executeUpdate();
			if(excutionStatus!=0)
			{
				
					out.println("Your details are submitted successfully.");
					RequestDispatcher rd=null;
					
					if (ButtonData.equals("Create Bill"))
						rd = request.getRequestDispatcher("ReturningPerscriptionListToJSP");
					else
					   rd = request.getRequestDispatcher("ToAddMoreMedicine.jsp");
				rd.forward(request, response);
			}
			else
				out.print("Unable to add data");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

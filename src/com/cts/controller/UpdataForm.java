package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdataForm
 */
@WebServlet("/UpdataForm")
public class UpdataForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker","root","root");
			String sql = "update bill set Patient_ID =?, Doctor_ID =?, Bill_Date =?, Medicine_ID =?, Quantity =?, Amount =?,total_amount =? where bill_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			 
			int bid = Integer.parseInt(request.getParameter("bid"));
			String pid = request.getParameter("pid");
			String did = request.getParameter("did");
			String date = request.getParameter("date");
			int mid = Integer.parseInt(request.getParameter("mid"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			ps.setString(1, pid);
			ps.setString(2, did);
			ps.setString(3, date);
			ps.setInt(4, mid);
			ps.setInt(5, quantity);
			ps.setInt(6, amount);
			ps.setInt(7, 0);
			ps.setInt(8, bid);
			int insertStatus = ps.executeUpdate();
			if(insertStatus!=0)
			{
				response.sendRedirect("ReturningPerscriptionListToJSP");
			}
			else
				out.print("Unable to add data");
		}
		catch(Exception e)
		{
			
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

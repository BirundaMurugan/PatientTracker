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
 * Servlet implementation class DisplayDoctorById
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DisplayClerkById
 */
@WebServlet("/DisplayDoctorById")
public class DisplayDoctorById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDoctorById() {
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
        DoctorDAO doctorDAO = new DoctorDAO();
        int id = Integer.parseInt(request.getParameter("Doctor_Id"));
        try
        {
                        Doctor d = doctorDAO.read(id);
                        request.setAttribute("DoctorList", d);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("DisplayDoctorById.jsp");
                        rd.forward(request, response);
        
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

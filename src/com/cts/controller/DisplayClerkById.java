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
 * Servlet implementation class DisplayClerkById
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
@WebServlet("/DisplayClerkById")
public class DisplayClerkById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayClerkById() {
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
        ClerkDAO clerkDAO = new ClerkDAO();
        int id = Integer.parseInt(request.getParameter("clerkid"));
        try
        {
                        Clerk c = clerkDAO.read(id);
                        request.setAttribute("clerkList", c);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("DisplayClerkById.jsp");
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

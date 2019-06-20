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
 * Servlet implementation class SelectClerkById
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SelectClerkById
 */
@WebServlet("/SelectClerkById")
public class SelectClerkById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClerkById() {
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
        List<Clerk> clist = null;
        try {
                        
                        clist = clerkDAO.readAll();
                        request.setAttribute("clerkList",clist);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("SelectClerkById.jsp");
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
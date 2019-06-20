package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.MedicineDao;
import com.cts.bean.Medicine;


/**
 * Servlet implementation class DisplayMedicineById
 */
@WebServlet("/DisplayMedicineById")
public class DisplayMedicineById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMedicineById() {
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
		MedicineDao medDAO = new MedicineDao();
		int id = Integer.parseInt(request.getParameter("id"));
		try
		{
			Medicine m = medDAO.read(id);
			request.setAttribute("MedicineDetails", m);
			
			RequestDispatcher rd = request.getRequestDispatcher("DisplayMedicineById.jsp");
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

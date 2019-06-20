package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.MedicineDao;
import com.cts.bean.Medicine;

/**
 * Servlet implementation class SelectMedicineById
 */
@WebServlet("/SelectMedicineById")
public class SelectMedicineById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMedicineById() {
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
		MedicineDao  medDAO = new MedicineDao();
		List<Medicine> medicine = null;
		try {
			
			medicine = medDAO.readAll();
			request.setAttribute("MedicineDetails", medicine);
			
			RequestDispatcher rd = request.getRequestDispatcher("SelectMedicineById.jsp");
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

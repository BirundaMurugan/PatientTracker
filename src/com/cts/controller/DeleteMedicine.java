package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.MedicineDao;
import com.cts.bean.Medicine;

/**
 * Servlet implementation class DeleteMedicine
 */
@WebServlet("/DeleteMedicine")
public class DeleteMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMedicine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		MedicineDao  medDAO = new MedicineDao();
		try
		{
			Medicine m = new Medicine();
			int id = Integer.parseInt(request.getParameter("id"));
			//f.setFlowerId(id);
			int deleteStatus = 0;
			deleteStatus = medDAO.delete(id);
			if(deleteStatus!=0)
			{
				response.sendRedirect("DisplayMedicineDetails");
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

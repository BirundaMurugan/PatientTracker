package com.cts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.DoctorDAO;
import com.cts.Dao.MedicineDao;
import com.cts.Dao.PatientDao;
import com.cts.bean.Doctor;
import com.cts.bean.Medicine;
import com.cts.bean.Patient;

/**
 * Servlet implementation class ReturnPatientListToJSP
 */
@WebServlet("/ReturnPatientListToJSP")
public class ReturnPatientListToJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnPatientListToJSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientDao patientdao = new PatientDao();
		DoctorDAO doctordao = new DoctorDAO();
		MedicineDao medicinedao = new MedicineDao();
		try {
			List<Patient> patientList  = patientdao.readAll();
			request.setAttribute("patientList",patientList);
			List<Doctor> doctorList = doctordao.readAll();
			request.setAttribute("doctorList",doctorList);
			List<Medicine> medicineList = medicinedao.readAll();
			request.setAttribute("medicineList", medicineList);
			RequestDispatcher rq = request.getRequestDispatcher("/createPrescription.jsp");
			//response.sendRedirect("createPrescription.jsp");
			rq.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

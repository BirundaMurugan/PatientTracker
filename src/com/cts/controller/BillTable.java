package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.DoctorDAO;
import com.cts.Dao.MedicineDao;
import com.cts.Dao.PatientDao;
import com.cts.bean.Billdetails;
import com.cts.bean.Doctor;
import com.cts.bean.Patient;
import com.cts.bean.Prescription;

/**
 * Servlet implementation class BillTable
 */
@WebServlet("/BillTable")
public class BillTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PatientDao pd=new PatientDao();
		DoctorDAO da=new DoctorDAO();
		MedicineDao md=new MedicineDao();
		
		
		List<Billdetails> billDetails=new ArrayList<Billdetails>();
		try {
			Patient pt=pd.read(request.getAttribute("patient_id").toString());
			Doctor dc=da.read((Integer.parseInt(request.getAttribute("Doctor_id").toString())));
			List<Prescription> list=(ArrayList<Prescription>)request.getAttribute("prescriptionList");
			String name=pt.getFirstName()+" "+pt.getLastName();
			request.setAttribute("patientName", name);
			String docname=dc.getFirst_Name()+" "+dc.getLast_Name();
			request.setAttribute("doctorname", docname);
			for(Prescription li:list)
			{
				if(li.getPatientId().equals(request.getAttribute("patient_id").toString()))
				{
					Billdetails bd=new Billdetails();
					int medicineId=li.getMedicineId1();
					String medicineName=md.read(medicineId).getDescription();
					int cost=md.read(medicineId).getAmount();
					int quantity=li.getQuantity1();
					int total=cost * quantity;
					bd.setMedicineId(medicineId);
					bd.setMedicineName(medicineName);
					bd.setAmount(cost);
					bd.setQuantity(quantity);
					bd.setTotal(total);
				System.out.println(cost+" "+quantity+" "+total);	
				billDetails.add(bd);
				}
				
				
			}
			request.setAttribute("billdetails", billDetails);
			
			for(Billdetails p : billDetails)
			{
				
				
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/GenerateBill.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

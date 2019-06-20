package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cts.bean.Patient;
import com.cts.bean.Prescription;

public class PrescriptionDAO {

	private static Connection con = null;
	private ResultSet rs = null;
	private Statement st = null;
	private PreparedStatement pstmt = null;

//	public int insert(Prescription pt) throws Exception {
//		int insertStatus = 0;
//		try {
//			PrescriptionDAO.connect();
//			pstmt = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
//			insertStatus = pstmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (con != null)
//				con.close();
//		}
//
//		return insertStatus;
//
//	}
//	
	public List<Prescription> readall() throws Exception {
		List<Prescription> prescriptionList = new ArrayList<>();
		Prescription p = null;
		try {
			PrescriptionDAO.connect();
			String sql = "select * from prescription";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
			p = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
			prescriptionList.add(p);
			}
		}
		catch(Exception e)
		{
			
		}
		return prescriptionList;
	}

	public Prescription read(String id) throws SQLException
	{
		Prescription p = null;
		try {
			PrescriptionDAO.connect();
			String sql = "select * from prescription where request_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
			p = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
			}
		}
		catch(Exception e)
		{
			
		}
		return p;
	}
	public int delete(String id) throws SQLException
	{
		int deleteStatus=0;
		try {
			PatientDao.connect();
			pstmt = con.prepareStatement("delete from patient where id=?");
			pstmt.setString(1, id);
			deleteStatus = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return 0;
	}
	
	public static Connection connect() throws  Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
		return con;
	}

}

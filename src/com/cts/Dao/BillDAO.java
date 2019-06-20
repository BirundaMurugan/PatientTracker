package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.bean.Bill;
import com.cts.bean.Patient;

public class BillDAO {

	private static Connection con = null;
	private ResultSet rs = null;
	private Statement st = null;
	private PreparedStatement pstmt = null;

	public List<Bill> readAll() throws Exception {
		List<Bill> bills=new ArrayList<Bill>();
		try {
			BillDAO.connect();
			pstmt = con.prepareStatement("select * from bill");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bill p=new Bill(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				bills.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return bills;
	}
	public Bill readByPID(String p_id) throws Exception {
		Bill bill = null;
		try {
			BillDAO.connect();
			pstmt = con.prepareStatement("select * from bill where patient_id=?");
			pstmt.setString(1, p_id);
			System.out.println("Sql : " + pstmt.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bill=new Bill(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return bill;
	}
	public static Connection connect() throws  Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
		return con;
	}
}

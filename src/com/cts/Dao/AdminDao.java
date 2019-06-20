package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.bean.Admin;

public class AdminDao {
	private static Connection con = null;
	private ResultSet rs = null;
	private Statement st = null;
	private PreparedStatement pstmt = null;

	public int insert(Admin ad) throws Exception {
		int insertStatus = 0;
		try {
			AdminDao.connect();
			pstmt = con.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, ad.getAdminId());
			pstmt.setString(2, ad.getFirstName());
			pstmt.setString(3, ad.getLastName());
			pstmt.setInt(4, ad.getAge());
			pstmt.setString(5, ad.getGender());
			pstmt.setString(6, ad.getDob());
			pstmt.setLong(7, ad.getContactNo());
			pstmt.setLong(8, ad.getAltContactNo());
			pstmt.setString(9, ad.getEmailId());
			pstmt.setString(10, ad.getPassword());
			insertStatus = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return insertStatus;

	}
	public boolean check(String id,String password)
	{
		int flag=0;
		try {
			//Admin am=new Admin();
			AdminDao.connect();
			pstmt=con.prepareStatement("select * from admin where AdminId=? and Password=? ");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			System.out.println(pstmt.toString());
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				flag=1;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1)
		{
			return true;
		}
		
		
			return false;
		
		
	}

	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
		return con;
	}

}

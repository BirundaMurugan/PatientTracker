package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cts.bean.Doctor;

public class DoctorDAO {
	private static Connection con=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
public int insert(Doctor d) throws Exception {
	connect();
	pstmt=con.prepareStatement("insert into doctor values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	int insertStatus=0;
	pstmt.setInt(1,d.getDoctor_Id());
	pstmt.setString(2, d.getFirst_Name());
	pstmt.setString(3, d.getLast_Name());
	pstmt.setInt(4, d.getAge());
	pstmt.setString(5, d.getGender());
	pstmt.setString(6, d.getDate_Of_Birth());
	pstmt.setLong(7, d.getContact_No());
	pstmt.setLong(8, d.getAlternate_Contact_No());
	pstmt.setString(9, d.getEmail_Id());
	pstmt.setString(10, d.getAddress_Line1());
	pstmt.setString(11, d.getAddress_Line2());
	pstmt.setString(12, d.getCity());
	pstmt.setString(13, d.getState());
	pstmt.setInt(14, d.getZip_Code());
	pstmt.setString(15, d.getDegree());
	pstmt.setString(16, d.getSpeciality());
	pstmt.setString(17, d.getWork_Hours());
	pstmt.setString(18, d.getHospital_Name());

	insertStatus=pstmt.executeUpdate();
	return insertStatus;
	
}


public ArrayList<Doctor> readAll() throws Exception {
	  ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	  try {
		connect();
		stmt=con.createStatement();
		 rs=stmt.executeQuery("select * from doctor");
		 while(rs.next()) {
			 Doctor d=new Doctor();
			  d.setDoctor_Id(rs.getInt(1));
			  d.setFirst_Name(rs.getString(2));
			  d.setLast_Name(rs.getString(3));
			  d.setAge(rs.getInt(4));
			  d.setGender(rs.getString(5));
			  d.setDate_Of_Birth(rs.getString(6));
			  d.setContact_No(rs.getLong(7));
			  d.setAlternate_Contact_No(rs.getLong(8));
			  d.setEmail_Id(rs.getString(9));
			  d.setAddress_Line1(rs.getString(10));
			  d.setAddress_Line2(rs.getString(11));
			  d.setCity(rs.getString(12));
			  d.setState(rs.getString(13));
			  d.setZip_Code(rs.getInt(14));
			  d.setDegree(rs.getString(15));
			  d.setSpeciality(rs.getString(16));
			  d.setWork_Hours(rs.getString(17));
			  d.setHospital_Name(rs.getString(18));
		  
			  doctors.add(d);
		 }
	  }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  finally{
				  if(con!=null) {
				  con.close();
				  }
	  }
	return doctors;
}



public Doctor read(int id) throws Exception {
	   Doctor d=new Doctor();
	   connect();
		  stmt=con.createStatement();
		 rs=stmt.executeQuery("select * from doctor where Doctor_Id="+id);
		 if(rs.next()) {
			 d.setDoctor_Id(rs.getInt(1));
			  d.setFirst_Name(rs.getString(2));
			  d.setLast_Name(rs.getString(3));
			  d.setAge(rs.getInt(4));
			  d.setGender(rs.getString(5));
			  d.setDate_Of_Birth(rs.getString(6));
			  d.setContact_No(rs.getLong(7));
			  d.setAlternate_Contact_No(rs.getLong(8));
			  d.setEmail_Id(rs.getString(9));
			  d.setAddress_Line1(rs.getString(10));
			  d.setAddress_Line2(rs.getString(11));
			  d.setCity(rs.getString(12));
			  d.setState(rs.getString(13));
			  d.setZip_Code(rs.getInt(14));
			  d.setDegree(rs.getString(15));
			  d.setSpeciality(rs.getString(16));
			  d.setWork_Hours(rs.getString(17));
			  d.setHospital_Name(rs.getString(18));
			 
			  con.close();
		 }
		return d;
}
	

public int update(Doctor d) throws Exception {
	   int updatestatus=0;
	   connect();
		pstmt=con.prepareStatement("update doctor set First_Name=?,Last_Name=?,Age=?,Gender=?,Date_Of_Birth=?,Contact_No=?,Alt_Contact_No=?,EmailId=?,AddressLine1=?,AddressLine2=?,City=?,State=?,Zipcode=?,Degree=?,Speciality=?,Work_Hours=?,Hospital_Name=? where Doctor_Id=?");
		
		
		pstmt.setString(1, d.getFirst_Name());
		pstmt.setString(2, d.getLast_Name());
		pstmt.setInt(3, d.getAge());
		pstmt.setString(4, d.getGender());
		pstmt.setString(5, d.getDate_Of_Birth());
		pstmt.setLong(6, d.getContact_No());
		pstmt.setLong(7, d.getAlternate_Contact_No());
		pstmt.setString(8, d.getEmail_Id());
		pstmt.setString(9, d.getAddress_Line1());
		pstmt.setString(10, d.getAddress_Line2());
		pstmt.setString(11, d.getCity());
		pstmt.setString(12, d.getState());
		pstmt.setInt(13, d.getZip_Code());
		pstmt.setString(14, d.getDegree());
		pstmt.setString(15, d.getSpeciality());
		pstmt.setString(16, d.getWork_Hours());
		pstmt.setString(17, d.getHospital_Name());
		pstmt.setInt(18,d.getDoctor_Id());
		updatestatus=pstmt.executeUpdate();
		con.close();
		
	return updatestatus;
}
public int delete(int id) throws Exception {
	   int deletestatus=0;
	   connect();
	   stmt=con.createStatement();
		deletestatus=stmt.executeUpdate("delete from doctor where Doctor_Id="+id);
		con.close();
		 
	return deletestatus;
	   
  }
		 
public static Connection connect() throws Exception {
	   Class.forName("com.mysql.jdbc.Driver");
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
	return con;
	   
}
}

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

public class PatientDao {

	private static Connection con = null;
	private ResultSet rs = null;
	private Statement st = null;
	private PreparedStatement pstmt = null;

	public int insert(Patient pt) throws Exception {
		int insertStatus = 0;
		try {
			PatientDao.connect();
			pstmt = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, pt.getPatientId());
			pstmt.setString(2, pt.getFirstName());
			pstmt.setString(3, pt.getLastName());
			pstmt.setInt(4, pt.getAge());
			pstmt.setString(5, pt.getGender());
			pstmt.setString(6, pt.getDob());
			pstmt.setLong(7, pt.getContactNo());
			pstmt.setLong(8, pt.getAltContactNo());
			pstmt.setString(9, pt.getEmailID());
			pstmt.setString(10, pt.getAddressLine1());
			pstmt.setString(11, pt.getAddressLine2());
			pstmt.setString(12, pt.getCity());
			pstmt.setString(13, pt.getState());
			pstmt.setLong(14, pt.getZipcode());

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

	public List<Patient> readAll() throws Exception {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			PatientDao.connect();
			pstmt = con.prepareStatement("select * from patient");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Patient p = new Patient();
				p.setPatientId(rs.getString(1));
				p.setFirstName(rs.getString(2));
				p.setLastName(rs.getString(3));
				p.setAge(rs.getInt(4));
				p.setGender(rs.getString(5));
				p.setDob(rs.getString(6));
				p.setContactNo(rs.getLong(7));
				p.setAltContactNo(rs.getLong(8));
				p.setEmailID(rs.getString(9));
				p.setAddressLine1(rs.getString(10));
				p.setAddressLine2(rs.getString(11));
				p.setCity(rs.getString(12));
				p.setState(rs.getString(13));
				p.setZipcode(rs.getLong(14));
				patients.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return patients;
	}

	public Patient read(String id) throws SQLException {
		Patient p = new Patient();
		try {

			PatientDao.connect();
			pstmt = con.prepareStatement("select * from patient where PatientId=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				p.setPatientId(rs.getString(1));
				p.setFirstName(rs.getString(2));
				p.setLastName(rs.getString(3));
				p.setAge(rs.getInt(4));
				p.setGender(rs.getString(5));
				p.setDob(rs.getString(6));
				p.setContactNo(rs.getLong(7));
				p.setAltContactNo(rs.getLong(8));
				p.setEmailID(rs.getString(9));
				p.setAddressLine1(rs.getString(10));
				p.setAddressLine2(rs.getString(11));
				p.setCity(rs.getString(12));
				p.setState(rs.getString(13));
				p.setZipcode(rs.getLong(14));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return p;

	}

	public int update(Patient pt) throws Exception {
		int updateStatus = 0;
		try {
			PatientDao.connect();
			pstmt = con.prepareStatement(
					"update patient set FirstName=?,LastName=?,Age=?,Gender=?,Dob=?,ContactNumber=?,AltContactNUmber=?,EmailID=?,AddressLine1=?,AddressLine2=?,City=?,State=?,Zipcode=? where PatientId=?");

			pstmt.setString(1, pt.getFirstName());
			pstmt.setString(2, pt.getLastName());
			pstmt.setInt(3, pt.getAge());
			pstmt.setString(4, pt.getGender());
			pstmt.setString(5, pt.getDob());
			pstmt.setLong(6, pt.getContactNo());
			pstmt.setLong(7, pt.getAltContactNo());
			pstmt.setString(8, pt.getEmailID());
			pstmt.setString(9, pt.getAddressLine1());
			pstmt.setString(10, pt.getAddressLine2());
			pstmt.setString(11, pt.getCity());
			pstmt.setString(12, pt.getState());
			pstmt.setLong(13, pt.getZipcode());
			pstmt.setString(14, pt.getPatientId());

			//System.out.println("SQL is "+pstmt.toString());
			
			updateStatus = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return updateStatus;
	}

	public int delete(String id) throws SQLException {
		int deleteStatus = 0;
		try {
			PatientDao.connect();
			pstmt = con.prepareStatement("delete from patient where PatientId=?");
			pstmt.setString(1, id);
			deleteStatus = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

		return deleteStatus;
	}

	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
		return con;
	}

}

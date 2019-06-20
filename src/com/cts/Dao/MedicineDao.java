package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.bean.Medicine;

public class MedicineDao {

	private static Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	public int insert(Medicine m) throws Exception {
		int insertStatus = 0;
		try {
			MedicineDao.connect();
			pstmt = conn.prepareStatement("insert into medicine values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, m.getId());
			pstmt.setString(2, m.getDescription());
			pstmt.setString(3, m.getPurpose());
			pstmt.setString(4, m.getManufacturingCompany());
			pstmt.setInt(5, m.getDosage());
			pstmt.setString(6, m.getPrescription());
			pstmt.setInt(7, m.getAmount());
			insertStatus = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return insertStatus;
	}
	public Medicine read(int id) throws Exception {
		Medicine m = new Medicine();
		try {
			MedicineDao.connect();
			pstmt = conn.prepareStatement("select * from medicine where Id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				m.setId(rs.getInt(1));
				m.setDescription(rs.getString(2));
				m.setPurpose(rs.getString(3));
				m.setManufacturingCompany(rs.getString(4));
				m.setDosage(rs.getInt(5));
				m.setPrescription(rs.getString(6));
				m.setAmount(rs.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return m;
	}
	
	public List<Medicine> readAll() throws Exception {
		List<Medicine> med = new ArrayList<Medicine>();
		try {
			MedicineDao.connect();
			pstmt = conn.prepareStatement("select * from medicine");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Medicine m = new Medicine();
				m.setId(rs.getInt(1));
				m.setDescription(rs.getString(2));
				m.setPurpose(rs.getString(3));
				m.setManufacturingCompany(rs.getString(4));
				m.setDosage(rs.getInt(5));
				m.setPrescription(rs.getString(6));
				m.setAmount(rs.getInt(7));
				med.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return med;
	}
	
	public int update(Medicine m) throws Exception {
		int updateStatus = 0;
		try {
			MedicineDao.connect();
			pstmt = conn.prepareStatement("update medicine set Description=?,Purpose=?,Manufacturing_company=?,Dosage=?,Prescription=?,Amount=? where Id=?");

			pstmt.setInt(7, m.getId());
			pstmt.setString(1,m.getDescription());
			pstmt.setString(2, m.getPurpose());
			pstmt.setString(3, m.getManufacturingCompany());
			pstmt.setInt(4, m.getDosage());
			pstmt.setString(5, m.getPrescription());
			pstmt.setInt(6, m.getAmount());
			updateStatus = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return updateStatus;
	}
	
	public int delete(int id) throws Exception {
		int deleteStatus = 0;
		try {
			MedicineDao.connect();
			pstmt = conn.prepareStatement("delete from medicine where Id=?");
			pstmt.setInt(1, id);
			deleteStatus = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return deleteStatus;
	}
	
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
		return conn;
	}
}

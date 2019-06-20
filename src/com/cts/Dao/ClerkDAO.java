package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.bean.Clerk;



public class ClerkDAO {
	private static Connection con=null;
    private ResultSet rs=null;
    private Statement stmt=null;
    private PreparedStatement pstmt=null;
    public int insert(Clerk c) throws Exception {
    	connect();
    	 pstmt=con.prepareStatement("insert into clerk values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         int insertStatus=0;
         pstmt.setInt(1, c.getClerkId());
         pstmt.setString(2, c.getFirst_Name());
         pstmt.setString(3, c.getLast_Name());
         pstmt.setInt(4, c.getAge());
         pstmt.setString(5, c.getGender());
         pstmt.setString(6, c.getDOB());
         pstmt.setLong(7, c.getContact_No());
         pstmt.setLong(8, c.getAlt_Contact_No());
         pstmt.setString(9, c.getAddress_Line1());
         pstmt.setString(10, c.getAddress_line2());
         pstmt.setString(11, c.getEmail_id());
         pstmt.setString(12, c.getCity());
         pstmt.setString(13, c.getState());
         pstmt.setInt(14 , c.getZipCode());
         insertStatus=pstmt.executeUpdate();
         return insertStatus;
    	
    	
    }
    public List<Clerk> readAll() throws Exception{
        List<Clerk> clist=new ArrayList<Clerk>();
        connect();
        stmt=con.createStatement();
      rs=stmt.executeQuery("select * from clerk");
        while(rs.next()) {
               Clerk c=new Clerk();
               c.setClerkId(rs.getInt(1));
               c.setFirst_Name(rs.getString(2));
               c.setLast_Name(rs.getString(3));
               c.setAge(rs.getInt(4));
               c.setGender(rs.getString(5));
               c.setDOB(rs.getString(6));
               c.setContact_No(rs.getLong(7));
               c.setAlt_Contact_No(rs.getLong(8));
               c.setAddress_Line1(rs.getString(9));
               c.setAddress_line2(rs.getString(10));
               c.setEmail_id(rs.getString(11));
               c.setCity(rs.getString(12));
               c.setState(rs.getString(13));
               c.setZipCode(rs.getInt(14));
               
               clist.add(c);
               
        }
        con.close();
        return clist;
    }
        public Clerk read(int id) throws Exception {
           Clerk c = new Clerk();
            connect();
                  stmt=con.createStatement();
                rs=stmt.executeQuery("select * from clerk where clerkId="+id);
                if(rs.next()) {
                	 c.setClerkId(rs.getInt(1));
                     c.setFirst_Name(rs.getString(2));
                     c.setLast_Name(rs.getString(3));
                     c.setAge(rs.getInt(4));
                     c.setGender(rs.getString(5));
                     c.setDOB(rs.getString(6));
                     c.setContact_No(rs.getLong(7));
                     c.setAlt_Contact_No(rs.getLong(8));
                     c.setAddress_Line1(rs.getString(9));
                     c.setAddress_line2(rs.getString(10));
                     c.setEmail_id(rs.getString(11));
                     c.setCity(rs.getString(12));
                     c.setState(rs.getString(13));
                     c.setZipCode(rs.getInt(14));
                     con.close();
                }
                return c;  
                       
                    
                }
        public int update(Clerk c) throws Exception {
            int updatestatus=0;
            connect();
                pstmt=con.prepareStatement("update clerk set First_Name=?,Last_Name=?,Age=?,Gender=?,DOB=?,Contact_No=?,Alt_Contact_No=?,Email_id=?,Address_Line1=?,Address_Line2=?,City=?,State=?,ZipCode=? where clerkId=?");
             
                pstmt.setInt(14,c.getClerkId());
                pstmt.setString(1, c.getFirst_Name());
                pstmt.setString(2, c.getLast_Name());
                pstmt.setInt(3, c.getAge());
                pstmt.setString(4, c.getGender());         
                pstmt.setString(5,c.getDOB());
                pstmt.setLong(6, c.getContact_No());
                pstmt.setLong(7, c.getAlt_Contact_No());
                pstmt.setString(8, c.getEmail_id());
                pstmt.setString(9, c.getAddress_Line1());
                pstmt.setString(10, c.getAddress_line2());
                pstmt.setString(11, c.getCity());
                pstmt.setString(12, c.getState());
                pstmt.setInt(13, c.getZipCode());
                updatestatus=pstmt.executeUpdate();
                con.close();
                
         return updatestatus;
            
     }
        public int delete(int id) throws Exception {
            int deletestatus=0;
            connect();
                  stmt=con.createStatement();
                deletestatus=stmt.executeUpdate("delete from clerk where clerkId="+id);
                con.close();
                
         return deletestatus;
        }
            
         public static Connection connect() throws Exception {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patienttracker", "root", "root");
          return con;
             
      }
                       
       
     }
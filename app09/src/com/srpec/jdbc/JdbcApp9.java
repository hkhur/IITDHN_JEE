package com.srpec.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import oracle.jdbc.OracleDriver;

//import oracle.jdbc.driver.OracleDriver;

public class JdbcApp9 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
		OracleDriver driver = new OracleDriver();
     	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		
     	st = con.createStatement();
     	     
     	 String query = "select * from comp";
     	     
     	 rs = st.executeQuery(query);
     
     	 System.out.println("ENO\tENAME\tESAL\tEADDR");
     	 System.out.println("------------------------------");
     	 while(rs.next()) {
     	    	 
     	   System.out.print(rs.getInt(1)+"\t");
     	   System.out.print(rs.getString(2)+"\t");
     	   System.out.print(rs.getFloat(3)+"\t");
     	   System.out.println(rs.getString(4)+"\t");
     	 }
     	     
     } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				st.close();
				con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

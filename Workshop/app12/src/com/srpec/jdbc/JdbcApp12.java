package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
     
		Connection con = null;
		Statement st = null;
		try {
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:himanshu", "system", "tiger");
			st = con.createStatement();
			
			String query = "update comp set esal =esal + 1000 where esal > 1000";
			
			ResultSet rs = st.executeQuery(query);
			
			} catch (Exception e) {
			try {
		        int rowCount = st.getUpdateCount();
				System.out.println("RECORDS UPDATED :"+rowCount);
				e.printStackTrace();

			} catch (Exception e1) {
			e1.printStackTrace();
			}
				
		 		}finally {
			try {
				
				st.close();
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	}

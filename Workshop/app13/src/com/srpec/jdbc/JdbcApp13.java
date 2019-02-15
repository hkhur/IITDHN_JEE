package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcApp13 {

	public static void main(String[] args) {

		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			st = con.createStatement();
			String query = "update comp set esal = esal + 1300 where esal > 1000";
			rs = st.executeQuery(query);
		    int rowCount = 	st.getUpdateCount();
		    System.out.println("RECORDS UPDATED   :"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
	}

}

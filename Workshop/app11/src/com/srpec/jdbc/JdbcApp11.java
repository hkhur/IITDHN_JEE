package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcApp11 {

	public static void main(String[] args) {
      
		Connection con = null;
		Statement st = null;
		try {
		DriverManager.registerDriver(new OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		st = con.createStatement();

		String query = "update comp set esal = esal + 500 where esal < 1000";
	    boolean b = st.execute(query);
	    System.out.println(b);
	    int rowCount  = st.getUpdateCount();
	    System.out.println(" RECORDS UPDATED   "+rowCount);
	    } catch (Exception e) {
		e.printStackTrace();
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
package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcApp10 {

	public static void main(String[] args) {
      
		Connection con = null;//closeable resource
		Statement st = null;
		ResultSet rs = null;
		try {
		
		DriverManager.registerDriver(new OracleDriver());
//		automatically driver will be recognized and 
//		registered with our JDBC application
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		st = con.createStatement();
	    String query = "select * from comp";
	    boolean b = st.execute(query);
	    System.out.println(b);
	    rs = st.getResultSet();// getting the ResultSet object explicitly
	    System.out.println("ENO\tENAME\tESAL\tEADDR");
	    System.out.println("----------------------------------");
	    while(rs.next())
	    {
	    	System.out.print(rs.getInt("ENO")+"\t");
	    	System.out.print(rs.getString("ENAME")+"\t");
	    	System.out.print(rs.getFloat("ESAL")+"\t");
	    	System.out.print(rs.getString("EADDR")+"\n");
	    	
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

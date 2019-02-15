package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
       
		Connection con = null;
		Statement st = null;
		try {
		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:himanshu", "system", "tiger");
			st = con.createStatement();
            String query = "select * from comp";
            
            int rowCount = st.executeUpdate(query);
            
            } catch (Exception e) {
			
		        try {
				
	            ResultSet rs = st.getResultSet();			
				System.out.println("ENO\tENAME\tESAL\tEADDR");
				System.out.println("------------------------------------");
				while(rs.next()) {
					
					System.out.print(rs.getInt("ENO")+"\t");
					System.out.print(rs.getString("ENAME")+"\t");
					System.out.print(rs.getFloat("ESAL")+"\t");
					System.out.print(rs.getString("EADDR")+"\n");
					}
				} catch (Exception e2) {
				
					e2.printStackTrace();
			}
			
			e.printStackTrace();
			
		}finally
		{
			try {
				
				st.close();
				con.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
}

}

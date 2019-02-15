package com.srpec.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp15 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			st = con.createStatement();
			
			String query = "select * from comp";
			int rowCount = st.executeUpdate(query);
			System.out.println("RECORDS COUNT     :"+rowCount);
			
			rs = st.getResultSet();
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-----------------------------------");
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
				} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			
		}
	}

}

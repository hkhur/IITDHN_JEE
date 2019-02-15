package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcapp8 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		
		try {
		Class.forName("oracle.jdbc.OracleDriver");
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		st = con.createStatement();
//	    String query = "create table emp17(ENO number primary key, ENAME varchar2(10))";
//	    int rowCount1 = st.executeUpdate(query);
//	    System.out.println(rowCount1);
        String query1 = "drop table emp17";
        int rowCount = st.executeUpdate(query1);
        System.out.println(rowCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				con.close();
			     st.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
}

}

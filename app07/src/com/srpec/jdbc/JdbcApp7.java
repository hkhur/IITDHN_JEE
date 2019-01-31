package com.srpec.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp7 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		
		try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    con = DriverManager.getConnection("jdbc:odbc:himanshu", "system", "tiger");	
		st = con.createStatement();
		String query = "create table emp16(ENO number primary key, ENAME varchar2(10))";
		int rowCount1 = st.executeUpdate(query);
		System.out.println(rowCount1);
		String query1 = "drop table emp16";
		int rowCount2 = st.executeUpdate(query1);
		System.out.println(rowCount2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		
       try {
		con.close();
	    st.close();
       } catch (Exception e) {
		e.printStackTrace();
	}

}
}}
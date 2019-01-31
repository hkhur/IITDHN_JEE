package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp6 {

	public static void main(String[] args) {
     
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
	try
	{
	Class.forName("oracle.jdbc.OracleDriver");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
	st = con.createStatement();
	br = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("SALARY RANGE     :");
	int sal_Range = Integer.parseInt(br.readLine());
	String query = "delete from emp4 where ESAL > "+sal_Range;
	int rowCount = st.executeUpdate(query);
	System.out.println("RECORDS DELETED    "+rowCount);
    }catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		
		try {
			br.close();
			st.close();
			con.close();
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		
	}
	
}

}

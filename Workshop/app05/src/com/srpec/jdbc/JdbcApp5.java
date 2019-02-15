package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp5 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		
		try {
		
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger"); 
		    st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("ENTER THE BONUS AMOUNT     :");
			int bonus_Amount = Integer.parseInt(br.readLine());
			
			System.out.print("SALARY RANGE TO BE MODIFIED     :");
		    int sal_Range = Integer.parseInt(br.readLine());
		    String query = "update emp4 set esal = esal + "+bonus_Amount+" where ESAL > "+sal_Range;
		    
			int rowCount = st.executeUpdate(query);
			
			System.out.print("RECORDS UPDATED     :"+rowCount);
		}catch(Exception e)
		{
	e.printStackTrace();
		}finally {
			
			try {
				con.close();
				st.close();
				br.close();
				}catch(Exception e)
			{
					e.printStackTrace();
					
			}
		}
	}

}

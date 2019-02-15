package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreSelect {

	public static void main(String[] args) throws Exception {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1999");
		
		PreparedStatement pst=con.prepareStatement("Select *from student");
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
		
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
	}

}


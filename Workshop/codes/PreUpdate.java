package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreUpdate {

	public static void main(String[] args) throws Exception {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1999");
		
		PreparedStatement pst=con.prepareStatement("Update student set Smarks=Smarks+ ? where Rollno>=?");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter Roll no:- ");
		int Rollno=Integer.parseInt(br.readLine());
		
		System.out.print("Enter Marks you want to add:- ");
		float marks=Float.parseFloat(br.readLine());

		pst.setFloat(1, marks);
		pst.setInt(2, Rollno);
		int count =pst.executeUpdate();
		System.out.println(count+" Record insert Successfully");

	}

}

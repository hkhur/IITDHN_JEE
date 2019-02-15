package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreDelete {

	public static void main(String[] args) throws Exception {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1999");
		
		PreparedStatement pst=con.prepareStatement("Delete student where Smarks<=?");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		System.out.print("Enter Marks Rang you want to delete:- ");
		float Smarks=Float.parseFloat(br.readLine());
		
		pst.setFloat(1, Smarks);
		int rowcount=pst.executeUpdate();
		
		System.out.println(rowcount+"Row delete Successfully");
		
		System.out.println("You want to continue ??? [yes/no]");
		String option=br.readLine();
		if(option.equalsIgnoreCase("yes")) {
			continue;
		}
		else {
			break;
		}
		}
	}

}


package com.akshay.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreStaEx {

	public static void main(String[] args) throws Exception {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1999");
		
		PreparedStatement pst=con.prepareStatement("Insert into student values(?,?,?)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			System.out.print("Enter Roll no:- ");
			int Rollno=Integer.parseInt(br.readLine());
			
			System.out.print("Enter Name:-");
			String Sname=br.readLine();
			
			System.out.print("Enter Marks:- ");
			float Smarks=Float.parseFloat(br.readLine());
			
			pst.setInt(1, Rollno);
			pst.setString(2, Sname);
			pst.setFloat(3, Smarks);
			pst.executeUpdate();
			System.out.println("Record insert Successfully");
			
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

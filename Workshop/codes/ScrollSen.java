package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollSen {

	public static void main(String[] args) throws Exception{
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srpecdb","root","19991");
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from student");
		
		System.out.print("Rollno"+"\t"+"Sname"+"\t"+"Smarks");
		System.out.println();
		while(rs.next()) {
			System.out.println(rs.getInt("Rollno")+"\t"+rs.getString("Sname")+"\t"+rs.getFloat("Smarks"));
		}
		System.out.println();
		System.out.println("Stop the programe flow of execution to make change into database table");
		
		System.in.read();
		
		rs.beforeFirst();
		
		System.out.print("Rollno"+"\t"+"Sname"+"\t"+"Smarks");
		System.out.println();
		System.out.println("-------------------------------------------");
		
		while(rs.next()) {
			rs.refreshRow();
			System.out.println(rs.getInt("Rollno")+"\t"+rs.getString("Sname")+"\t"+rs.getFloat("Smarks"));
		}
	
		
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

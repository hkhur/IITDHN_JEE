package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcApp08 {

	

	public static void main(String[] args) throws Exception {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srpecdb","root","19991");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			ResultSet rs=st.executeQuery("Select * from student");
			rs.moveToInsertRow();
			
		while(true) {
			
			System.out.print("Enter Roll no:- ");
			int Rollno=Integer.parseInt(br.readLine());
			System.out.print("Enter Name:- ");
			String Sname=br.readLine();
			System.out.print("Enter Marks:- ");
			Float Smarks=Float.parseFloat(br.readLine());
			
			rs.updateInt(1,Rollno);
			rs.updateString(2,Sname);
			rs.updateFloat(3,Smarks);
			rs.insertRow();
			System.out.println("Row inserted Successfully");
			System.out.println("Do you want to continue [yes/no]");
			String option=br.readLine();
			if(option.equalsIgnoreCase("yes")) {
				continue;
			}
			else {
				System.out.println("OK BYEE");
				break;
			}
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}


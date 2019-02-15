package com.srpec.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ScrollUpdate {

	

	public static void main(String[] args) throws Exception {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srpecdb","root","root");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			ResultSet rs=st.executeQuery("Select * from student");
			rs.beforeFirst();
			
		while(rs.next()) {
			System.out.println();
			Float marks=rs.getFloat(3);
			if(marks<90) {
				String name = rs.getString("Sname");	
				float Smarks=marks+5;
				rs.updateFloat(3, Smarks);
				rs.updateRow();
				System.out.println(name+" get 5 marks bonus");
			}
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}


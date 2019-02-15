package com.srpec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ScrollDelete {

	

	public static void main(String[] args) throws Exception {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srpecdb","root","19991");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			ResultSet rs=st.executeQuery("Select * from student");
			rs.beforeFirst();
			
		while(rs.next()) {
			System.out.println();
			float marks = rs.getFloat(3);
			if(marks>=100){
				String name = rs.getString("Sname");	
				rs.deleteRow();
				System.out.println(" the student deleted is "+name);
			}
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}


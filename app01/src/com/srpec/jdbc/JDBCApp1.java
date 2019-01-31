package com.srpec.jdbc;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;

public class JDBCApp1 {

	public static void main(String[] args) throws Exception{
    //1. Load and Register Driver
	// Type-1 Driver provided by sun microsystems
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    
	//2. Establish Connection between JAVA application and the DATABASE
	Connection con = DriverManager.getConnection("jdbc:odbc:hk", "system", "tiger");
    
	//3. Create Statement
	 Statement st =  con.createStatement();
    
	 //4. Create BufferedReader object
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	 System.out.println("Table name :");
	 
	 String tableName = br.readLine();
	 
	 //5. Write SQL query
	String query = "create table "+tableName+"( ENO number(4) primary key, ENAME varchar2(10), ESAL float, EADDR varchar2(10))";
	
	//6. Execute SQL query
	st.executeUpdate(query);
	
	System.out.println(tableName+ " Created Successfully");
	
	//7. Closing the resources 
	
	st.close();
	con.close();
	}
}

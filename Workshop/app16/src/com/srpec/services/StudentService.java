package com.srpec.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.srpec.beans.Student;
// ALL BELOW METHODS ARE CALLED AS BUISNESS METHODS 
public class StudentService {

 String status = "";

 Student std;

 Connection con;

 Statement st;

 ResultSet rs;

public StudentService()// JDBC SET UP CODE IS PROVIDED HERE
{
	try {
	
		Class.forName("oracle.jdbc.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		
		st = con.createStatement();
		
	} catch (Exception e) {

	e.printStackTrace();
	
	}
	
}
// WRITE SQL query and EXECUTE SQL query that is our actual buisness logic
//public String addStudent(String sid, String sname, String saddr)

public String addStudent(Student std)
{

	try {
	
	rs = st.executeQuery("select * from student where SID = '"+std.getSid()+"'");
	
	boolean b = rs.next();
	
	if(b == true)
	{
		status = "existed";
	}else {
		
		st.executeUpdate("insert into student values ('"+std.getSid()+"', '"+std.getSname()+"', '"+std.getSaddr()+"') ");
		status = "success";
		}
		
	} catch (Exception e) {

	status = "failure";
	e.printStackTrace();
	
	}
	
	return status;
	}

public Student searchStudent(String sid)
{
	try {

		rs = st.executeQuery("select * from student where sid = '"+sid+"'");
		
		boolean b = rs.next();
		
		if(b == true)
		{
			
			std = new Student();
			
			std.setSid(rs.getString("SID"));
			
			std.setSname(rs.getString("SNAME"));
			
			std.setSaddr(rs.getString("SADDR"));
			
	}else {
		 std = null;
		}
		
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	return std;
	
	
}
// public String updateStudent(String sid, String sname, String addr)
public String updateStudent(Student student)
{  
	
	try {
	
		st.executeUpdate("update student set sname = '"+student.getSname()+"', saddr = '"+student.getSaddr()+"' where SID = '"+student.getSid()+"'");
		status = "success";
		} catch (Exception e) {
		
	status = "failure";
	e.printStackTrace();
		}
	return status;
	
}

public String deleteStudent(String sid)
{
	try {
		
		rs = st.executeQuery("select * from student where SID = '"+sid+"'");
		
		boolean b = rs.next();
		if(b == true)
		{
		st.executeUpdate("delete from student where SID = '"+sid+"'");
		status = "success";
		}else {
			status = "notexisted";
	}
		
	} catch (Exception e) {
		status = "failure";
		e.printStackTrace();
		
	}
	
return status;
	
	
}

}

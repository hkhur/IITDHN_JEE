package com.srpec.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.srpec.beans.Student;
import com.srpec.services.StudentService;

public class Test {

	public static void main(String[] args) {
		
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StudentService stdservice = new StudentService();
			
			Student std = null;
			
			String status = "";
			
			while(true)
			{
				
				System.out.println(" 1. Add Student ");
				System.out.println(" 2. Search Student ");
				System.out.println(" 3. Update Student ");
				System.out.println(" 4. Delete Student ");
				System.out.println(" 5. Exit ");
				System.out.print(" YOUR OPTION:   ");
				int option = Integer.parseInt(br.readLine());
				
				String sid = "", sname = "", saddr = "";
				
				switch(option)
				{
				
				case 1 : 
				
				System.out.print(" STUDENT ID       :");
				sid = br.readLine();
				
				System.out.print(" STUDENT NAME     :");
				
				sname = br.readLine();
				
				System.out.print(" STUDENT ADDRESS  :");
				
				saddr = br.readLine();
			
				
				std = new Student();
				
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				
			   status = stdservice.addStudent(std);
				
				//		status = stdservice.addStudent(sid, sname, saddr);
				
				if(status.equals("success"))
				{
					
					System.out.println(" STUDENT INSERTED SUCCESSFULLY ");
					
				}
					
				if(status.equals("failure"))	
					
				{
					
					System.out.println(" STUDENT INSERTION FAILURE ");
				}
					
				if(status.equals("existed"))
				{
					
					System.out.println(" STUDENT EXISTED ALREADY ");
				}
				break;
				
				case 2 :
				
				System.out.print(" STUDENT ID    :");
				sid = br.readLine();
				std = stdservice.searchStudent(sid);
				if(std == null)
				{
				System.out.println(" STUDENT DOES NOT EXIST ");
				}else{
				System.out.println(" STUDENT DETAILS ");
				System.out.println("-----------------------------");
				System.out.println(" STUDENT ID    :"+ std.getSid());
				System.out.println(" STUDENT NAME  :"+ std.getSname());
				System.out.println(" STUDENT ADDR  :"+std.getSaddr());
				}
				break;
					
				case 3 :
				
			System.out.print(" STUDENT ID    :");
			sid = br.readLine();
			std = stdservice.searchStudent(sid);
			if(std == null)
			{
			System.out.println(" STUDENT NOT EXISTED ");
			}else {
			System.out.println(" STUDENT ID     :"+ std.getSid());
			System.out.print(" STUDENT NAME    : old value :  " + std.getSname() + " NEW VALUE  :");
			sname = br.readLine();
			System.out.print(" STUDENT ADDRESS : old value :  " +std.getSaddr() + " NEW VALUE   : " );
			saddr = br.readLine();
			Student student = new Student();	
			student.setSid(std.getSid());
			if(sname == null || sname.equals(""))
			{
			student.setSname(std.getSname());
			}else {
			student.setSname(sname);
			}
			if(saddr == null || saddr.equals(""))
			{
			student.setSaddr(std.getSaddr());	
             }else {
             student.setSaddr(saddr);
              }
			status = stdservice.updateStudent(student);
			if(status.equals("success"))
			{
		    System.out.println(" STUDENT UPDATION SUCCESS ");
			}
		if(status.equals("failure")) {
		System.out.println(" STUDENT UPDATION FAILURE ");
		}
		}
					break;
				 
				   case 4 :
				   System.out.print(" STUDENT ID        :");
					sid = br.readLine();
					status = stdservice.deleteStudent(sid);
					if(status.equals("success"))
					{
					System.out.println(" STUDENT DELETED SUCCESSFULLY  ");	
					}
					if(status.equals("failure"))
					{
						System.out.println(" STUDENT DELETION FAILURE ");
					}
					if(status.equals("notexisted"))
					{
					System.out.println(" STUDENT DOES'NOT EXIST ");
					}
					break;
				
				case 5 :
				System.out.println(" OK BYEEEEEEEE  ");
				System.exit(0);
				break;
				
				default : 
					System.out.println(" ENTER OPTIONS FROM 1 to 5 ");
				break;
				}
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

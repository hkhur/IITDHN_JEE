package com.srpec.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp3 {

	public static void main(String[] args)throws Exception {
		
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
	Statement st = con.createStatement();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while(true)
	{
	  System.out.print("EMPLOYEE NUMBER     :");
	  int eno = Integer.parseInt(br.readLine());
	  System.out.print("EMPLOYEE NAME       :");
	  String ename = br.readLine();
	  System.out.print("EMPLOYEE SALARY     :");
	  float esal = Float.parseFloat(br.readLine());
	  System.out.print("EMPLOYEE ADDRESS    :");
	  String eaddr = br.readLine();
	  String query = "insert into comp values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
	  st.executeUpdate(query);
	  System.out.println("EMPLOYEE RECORD INSERTED SUCCESSFULLY");
	  System.out.print("ONE MORE EMPLOYEE[yes/no]?");
	  String option = br.readLine();
	  if(option.equals("yes"))
	  {
		  continue;
	  }
	  else 
	  {
		System.out.println("OF FINE ");
		break;
	}
	}	  
 br.close();
 st.close();
 con.close();
	
	}

}

package com.srpec.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp4 {

	public static void main(String[] args)  {
 //. Declaring the resources
		 BufferedReader br = null;
		 Connection con = null;
		 Statement st = null;
		try
		{
 //.Creating the resources 		
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		st = con.createStatement();
		br = new BufferedReader(new InputStreamReader(System.in));
		String query = "create table ";
		System.out.print("TABLE NAME     :");
		String tname = br.readLine();
		query = query + tname +"(";
		String primary_Key_Cols = "";
		int primary_Key_Cols_Count = 0;
		
		while(true)
		{
		System.out.print("COLUMN NAME     :");
		String col_Name = br.readLine();
	    query = query + col_Name + " ";
	    System.out.print("COLUMN DATA TYPE WITH LENGTH     :");
	    String col_Data_Type = br.readLine();
		query = query + col_Data_Type;	
		System.out.print("IS PRIMARY KEY[yes/no]? ");	
		String primary_Key_Option = br.readLine();	
		if(primary_Key_Option.equals("yes"))
			{
			if(primary_Key_Cols_Count == 0)
			{
				primary_Key_Cols = primary_Key_Cols + col_Name;
		        primary_Key_Cols_Count = primary_Key_Cols_Count+1;	
			}
			else 
			{
			primary_Key_Cols = primary_Key_Cols +","+col_Name;
		    }
			}
			System.out.print("ONE MORE COLUMN[yes/no] ?");
			String option = br.readLine();
			if(option.equals("yes"))
			{
				query = query + ",";
				continue;
			}
			
			else
			{
				
				query = query + ", primary key("+primary_Key_Cols+"))";
                break;			
			
			}
				
		}	
	 
		System.out.println(query);
		
		st.executeUpdate(query);
		System.out.println("TABLE CREATED SUCCESSFULLY ");
		
} catch (Exception e) {
	  e.printStackTrace();
	}finally {
		
		try {
			
		br.close();
		st.close();
		con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
}
}
}

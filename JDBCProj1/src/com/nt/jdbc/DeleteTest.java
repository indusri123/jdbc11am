//GET HIGHEST SAL OF EMPLOYEE

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {

		//properties
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		Scanner sc=null;
		
		
		try {
			sc=new Scanner(System.in);
			int sno=0;
			
			if(sc!=null) {
				System.out.println("enter student id :");
				sno=sc.nextInt();
			}//if
			
		 query="DELETE FROM STUDENT WHERE SNO="+sno;
		 System.out.println(query);
		//load driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//create connection object
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		//create statement obj
		if(con!=null)
		st=con.createStatement();
		
		//execute query
		
		int count=0;
		if(st!=null) {
			
			count=st.executeUpdate(query);
			
		}//if
		if(count==0)
			System.out.println("records  not deleted");
		else
			System.out.println("records deleted");
		
		
		}//try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		catch(ClassNotFoundException cfe) {
			cfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
	}//main

}//class

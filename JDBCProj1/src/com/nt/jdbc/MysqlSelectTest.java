//GET AVG OF STUDENT

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlSelectTest {

	public static void main(String[] args) {

		//properties
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		
		try {
		 query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
		//load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		/*
		 * con=DriverManager.getConnection("jdbc:mysql:///mysqldb", "root", "root");
		 *
		 */
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root", "root");
		
		//create statement obj
		if(con!=null)
		st=con.createStatement();
		
		//execute query
		boolean flag=false;
		if(st!=null) {
			
			rs=st.executeQuery(query);
			
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			}
		}
		if(flag==true)
			System.out.println("records  found");
		else
			System.out.println("records not found");
		
		
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

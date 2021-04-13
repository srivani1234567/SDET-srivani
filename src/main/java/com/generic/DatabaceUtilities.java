package com.generic;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaceUtilities {
	
	Connection con=null;

	/*
	 * Throws SQL exception
	 * @param driver
	 * @ param connection
	 *   excute Query
	 */
	public void Databaceconnect(Driver driverref,Connection con ) throws SQLException {
		try {
		//step1:register to the database
		DriverManager.registerDriver(driverref);
		
		//step2:get connection into data base
		 con=DriverManager.getConnection(IConstance.databasepath, "root", "root");
		 
		 //step3:issue create statement
		 Statement  state = con.createStatement();
		 
		 //step4:excute query
	    ResultSet result=state.executeQuery("select data  from table_name;");
		
	   while(result.next()) {
		
		System.out.println(result.getString(1)+"\t"+result.getString(2));
	}
		}
		catch(Exception e) {
			
		}
		finally {
		//step5:
		con.close();
		}
		
		
		
	}
	
	/*
	 * Throws SQL exception
	 * @param driver
	 * @ param connection
	 *   excute update Query
	 */

	
	
	public void DatabaceconnectionupdateQuary(Driver driverref,Connection con ) throws SQLException {
		try {
		//step1:register to the database
		DriverManager.registerDriver(driverref);
		
		//step2:get connection into data base
		 con=DriverManager.getConnection(IConstance.databasepath, "root", "root");
		 
		 //step3:issue create statement
		 Statement  state = con.createStatement();
		 
		 //step4:excute udateQuery
			int result	 =state.executeUpdate("insert into table_name values(value1, value2);");
			if(result==1) {
				
				System.out.println("Quary executed");
			}

		}
		catch(Exception e) {
			
		}
		finally {
		//step5:
		con.close();
		}

	
		


}
}
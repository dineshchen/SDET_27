package com.crm.autodesk.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Gopinath
 *
 */
public class DataBaseUtility {
	/**
	 * 
	 * @throws SQLException
	 */
public void CreateJdbcConnection() throws SQLException {
	Driver driver=new Driver();
	
	//register the Database
	DriverManager.registerDriver(driver);
	
	//get the connection
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	
	
	//create statement
	Statement statement = connection.createStatement();
	
	//execute the query
	statement.executeQuery("select * from student_info;");
	System.out.println("Database is connected");
}
public void closeJdbcConnection(Connection connection) throws SQLException {
	connection.close();
	System.out.println("Database connection is closed");
}
}

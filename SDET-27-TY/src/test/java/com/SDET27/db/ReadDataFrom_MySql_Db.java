package com.SDET27.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFrom_MySql_Db {

	public static void main(String[] args) throws Throwable {

// Register/load mysql Database		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
//get connection to DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
// Create statement		
		Statement statement = connection.createStatement();
		String query="select * from student_info;";
		
//Execute query/statement
	ResultSet res=statement.executeQuery(query);
	while(res.next())
	{
		System.out.println(res.getInt(1)+" " +res.getString(2)+" "+res.getString(4));
	}
		
//close the connection
	connection.close();
	}

}

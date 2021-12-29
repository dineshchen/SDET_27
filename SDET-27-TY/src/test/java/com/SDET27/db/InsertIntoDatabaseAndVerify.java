package com.SDET27.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertIntoDatabaseAndVerify {
public static void main(String[] args) throws Throwable  {
	
//Register/load Database
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
//Create connection to Database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
//Create statement/query	
	Statement statement = connection.createStatement();
	String query="insert into student_info (fname,lname,address) values ('Bharath','C','Bangalore'),('Binay','S','Mangalore')";
	
	
//Execute statement/query
	int result=statement.executeUpdate(query);
	if(result==2)
	{
		System.out.println("Two new rows are inserted");
	}else {
		System.out.println("No new rows are inserted");
	}
//Insertion done
	
	//now fetching the all the data
	
	Statement statement1 = connection.createStatement();
	String query1="select * from student_info;";
	
	ResultSet result1=statement1.executeQuery(query1);
	while(result1.next())
	{
	System.out.println(result1.getInt(1)+" "+result1.getString(2)+" "+result1.getString(3)+" "+result1.getString(4));
	}
	//Close the Database connection
		connection.close();

}
}


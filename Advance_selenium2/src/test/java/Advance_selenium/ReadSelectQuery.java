package Advance_selenium;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.remote.service.DriverCommandExecutor;

import com.mysql.cj.jdbc.Driver;

public class ReadSelectQuery
{
public static void main(String[] args) throws SQLException
{
	//1.create driver object
	 Driver driver =new Driver();
	 
	 //2.register driver
	 DriverManager.registerDriver(driver);
	 
	 //3. get the connection for database
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "root");
	 
	 //4.create statement
	 Statement state = conn.createStatement();
	 String query = "select * from students;";
	 
	 //5.execute query
	ResultSet result = state.executeQuery(query);
	//System.out.println(result.getMetaData()+"");
	
	while(result.next())
	{
		System.out.println(result.getString(1)+""+ result.getString(2)+""+result.getString(3)+""+ result.getString(4));
	}
	//close the connection
	conn.close();
}
}

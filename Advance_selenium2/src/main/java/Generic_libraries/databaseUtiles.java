package Generic_libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class databaseUtiles {

	private static final String IPathConstants = null;
	Connection conn=null;
    ResultSet result=null;
	public void createDBRegister() throws SQLException
	{
		
				//register to db
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//get connection
		Connection conn = DriverManager.getConnection(Interface.Dburl, Interface.dbusername, Interface.dbpassword);
		
	}
	
		public ResultSet executeQuery(String query) throws SQLException	
		{
			
			//create statement
		Statement state = conn.createStatement();
		
		//execute
		result=state.executeQuery(query);
		return result;
		}	
		public int updateQuery(String query) throws SQLException	
		{
			
			//create statement
		Statement state = conn.createStatement();
		
		//execute
		 int res = state.executeUpdate(query);
		return res;
		}	
		
		
		public void disconnectionDB() throws SQLException
		{
			
		//close db
		conn.close();
	   }
	
}

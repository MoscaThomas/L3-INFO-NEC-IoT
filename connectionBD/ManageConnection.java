package connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ManageConnection {
	private static final String URL_BD = "jdbc:mysql://127.0.0.1:3306/projsaccam'in";
	private static final String USER_BD = "root";
	private static final String MDP_USER_BD = "root";
	
	private static Connection connection = null;
	
	public static Connection getConnection(){
		if (connection != null)
			return connection;
		else
			try{;
				DriverManager.registerDriver(new Driver());
				connection = DriverManager.getConnection(URL_BD, USER_BD, MDP_USER_BD);
				return connection;
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		return null;
	}
	
	public static void stopConnection(){
		try{
			if (connection != null){
				connection.close();
			}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
}


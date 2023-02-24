package main.java;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class DatabaseManagement {
    private static final String URL_BD = "jdbc:mysql://mysql/IOT";
	private static final String USER_BD = "root";
	private static final String MDP_USER_BD = "root";
	
	private static Connection connection = null;
	
	public static Connection getConnection(){
		if (connection != null)
			return connection;
		else
			try{;
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL_BD, USER_BD, MDP_USER_BD);
				return connection;
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
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

    public static int insert(double modif, double prix){
        try{
            Statement stmt = getConnection().createStatement();
            String sql = "INSERT INTO fluctuation " +
                       "VALUES (null," + prix + ", " + modif + ")";
            return stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
    }
}
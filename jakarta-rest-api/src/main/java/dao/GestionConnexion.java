package dao;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class GestionConnexion {
    private static final String URL_BD = "jdbc:mysql://mysql:3306/IOT";
	private static final String USER_BD = "root";
	private static final String MDP_USER_BD = "root";
	
	private static Connection connection = null;
	
	public static Connection getConnection(){
		System.out.println("---------------------Appel connexion---------------------");
		if (connection != null)
			return connection;
		else
			try{
				System.out.println("---------------------avant forname---------------------");
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("---------------------avant driver manager---------------------");
				System.out.println(DriverManager.getConnection(URL_BD, USER_BD, MDP_USER_BD));
				System.out.println("--------------------- après driver manager---------------------");
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
}
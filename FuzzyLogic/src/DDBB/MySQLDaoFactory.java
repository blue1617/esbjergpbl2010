package DDBB;

import java.sql.*;

public class MySQLDaoFactory extends DAOFactory {
  public static final String DRIVER="com.mysql.jdbc.Driver";
  public static final String DBURL="jdbc:mysql://localhost/fuzzy?user=root&amp;password=";
  
  // method to create MySQL connections
  public static Connection createConnection() throws ClassNotFoundException, SQLException{
	  
	    Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?user=root&amp;password=root");	
			
	return conexion;
	}
  public InformationDAO getInformationDAO() {
	// TODO Auto-generated method stub
  return new MySQLInformationDAO();
  
  }
}
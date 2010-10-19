package model.DDBB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDaoFactory extends DAOFactory {
  public static final String DRIVER="com.mysql.jdbc.Driver";
  public static final String DBURL="jdbc:mysql://localhost/fuzzy?user=root&password=root";
  private Statement statement = null;

  // method to create MySQL connections
  public Statement createConnection()throws Exception{
            Connection conexion;
            System.out.println("akiii");
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DBURL);

            return statement;
	}
  public InformationDAO getInformationDAO() {
	// TODO Auto-generated method stub
  return new MySQLInformationDAO();
  
  }


   

}
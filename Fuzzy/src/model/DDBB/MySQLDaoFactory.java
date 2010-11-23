package model.DDBB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDaoFactory extends DAOFactory {
  public static final String DRIVER="com.mysql.jdbc.Driver";
  public static final String DBURL="jdbc:mysql://localhost/mydb?user=root&password=narkotek";
  public static Statement statement = null;
  public static Connection con = null;

  // method to create MySQL connections
  public Connection getConnection() {
            Connection conexion;
            try {
            //System.out.println("akiii");
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DBURL);
            }
	catch (SQLException e) { e.printStackTrace();  }
            catch (ClassNotFoundException ex) { ex.printStackTrace();  }
        return con;
    }
  public static void closeConnection( Connection con ) {
	try {
	    if ( con != null )
		if ( !con.isClosed() )    // Si no está cerrada, la cierro
		    con.close();
	}
	catch (SQLException e) { e.printStackTrace();  }
    }

  public void create() throws Exception {
            Connection conexion;
            System.out.println("akiii");
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DBURL);
            statement = conexion.createStatement();

    }

  public  Statement createConnection()throws Exception{
            Connection conexion;
            System.out.println("akiii");
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DBURL);

            return statement;
	}
  public UserDAO getUserDAO() {

      return new MySQLUserDAO();
  }
  public FilmDAO getFilmDAO() {

      return new MySQLFilmDAO();
  }
  public ItemDAO getItemDAO() {

      return new MySQLItemDAO();
  }
  public RateDAO getRateDAO() {

      return new MySQLRateDAO();
  }



   

}

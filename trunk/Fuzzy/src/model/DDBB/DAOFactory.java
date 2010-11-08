package model.DDBB;

import java.sql.*;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	  public static final int MySQL = 1;
	  public static final int ORACLE = 2;
	  public static final int SYBASE = 3;
          private Statement statement = null;

	  // There will be a method for each DAO that can be 
	  // created. The concrete factories will have to 
	  // implement these methods.
	  public abstract UserDAO getUserDAO();
          public abstract FilmDAO getFilmDAO();
          public abstract ItemDAO getItemDAO();
          public abstract void create()throws Exception;
          public abstract Connection getConnection();
          public abstract Statement createConnection()throws Exception;

	  public static MySQLDaoFactory getDAOFactory(
	      int whichFactory) {
	  
	    switch (whichFactory) {
	      case MySQL: 
	          return new MySQLDaoFactory();
	      default           : 
	          return null;
	    }
	  }

}

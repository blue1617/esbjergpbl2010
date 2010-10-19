package model.DDBB;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	  public static final int MySQL = 1;
	  public static final int ORACLE = 2;
	  public static final int SYBASE = 3;

	  // There will be a method for each DAO that can be 
	  // created. The concrete factories will have to 
	  // implement these methods.
	  public abstract InformationDAO getInformationDAO();

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

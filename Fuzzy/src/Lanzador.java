import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DDBB.*;


public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create the required DAO Factory
		DAOFactory MySQLFactory =   
		  DAOFactory.getDAOFactory(DAOFactory.MySQL);
                  System.out.println("asdsfd");
        try {
            // Create a DAO
            Statement sta = MySQLFactory.createConnection();
        } catch (Exception ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
		InformationDAO infDAO = 
		  MySQLFactory.getInformationDAO();
                System.out.println("asdsfd");
        int newInf = infDAO.insertInformation();
		


	}

}

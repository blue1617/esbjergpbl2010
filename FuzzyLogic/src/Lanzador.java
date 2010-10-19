import DDBB.*;


public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create the required DAO Factory
		DAOFactory MySQLFactory =   
		  DAOFactory.getDAOFactory(DAOFactory.MySQL);

		// Create a DAO
		InformationDAO infDAO = 
		  MySQLFactory.getInformationDAO();
        int newInf = infDAO.insertInformation();
		


	}

}

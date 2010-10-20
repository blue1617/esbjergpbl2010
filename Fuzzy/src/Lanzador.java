import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DDBB.*;
import model.dto.User;


public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		// create the required DAO Factory
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);

                  System.out.println("asdsfd");
        
		UserDAO userDAO = MySQLFactory.getUserDAO();
                System.out.println("asdsfd");
                ArrayList<User> use = userDAO.getUsers();
                System.out.println("User in database:");
                int i=0;
                while(i<use.size()){
                    System.out.println(use.get(i).name+" "+use.get(i).surname);
                    i++;
                }
		System.out.println(use.size());


	}

}

import control.DataMining;
import control.Fuzzifier;
import control.Similarity;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DDBB.*;
import model.dto.Film;
import model.dto.Item;
import model.dto.User;


public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		// create the required DAO Factory
		//DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);

               //   System.out.println("asdsfd");
        
		/*UserDAO userDAO = MySQLFactory.getUserDAO();
                System.out.println("asdsfd");
                ArrayList<User> use = userDAO.getUsers();
                System.out.println("User in database:");
                int i=0;
                while(i<use.size()){
                    System.out.println(use.get(i).name+" "+use.get(i).surname);
                    i++;
                }
		System.out.println(use.size());
                 */

              //  ItemDAO itemDAO = MySQLFactory.getItemDAO();
               // System.out.println("asdsfd");
               // ArrayList<Item> items = itemDAO.getItems();
                DataMining data = new DataMining();
                ArrayList<Film> films;
                films = data.NotRankedList(2);
                for(int i=0;i<films.size();i++){
                    System.out.println("Pinicula: "+ films.get(i).getTitle());
                }
                /*int i=0;
                while(i<items.size()){
                    System.out.println(items.get(i).getIdItem());
                    i++;
                }
		System.out.println(items.size());*/
                //System.out.println("total "+items.get(0).total());
                //Fuzzifier ff = new Fuzzifier();
                //HashMap<String,Double> rank =  ff.getFuzzyVector(items.get(0));
                //System.out.println(rank.toString());
               // Similarity ss = new Similarity();
               // System.out.println(ss.cosineItemSimilarity(items.get(0),items.get(1)));

	}

}

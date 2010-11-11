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
import model.dto.Rate;
import model.dto.User;


public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);

        
		UserDAO userDAO = MySQLFactory.getUserDAO();
                RateDAO rateDAO = MySQLFactory.getRateDAO();
                System.out.println("asdsfd");
                ArrayList<User> use = userDAO.getUsers();
                System.out.println("User in database:");
                                
                for(int i=0; i<use.size();i++){
                   ArrayList<Rate> rate = rateDAO.getRatesUser(use.get(i).getIdUser());
                   if(rate.size()!=0){
                       System.out.println("EXISTE EL USUARIO "+use.get(i).getIdUser());
                   } else{
                       System.out.println("NO EXISTE EL USUARIO "+use.get(i).getIdUser());
                   }
                }

		System.out.println(use.size());
                 

              //  ItemDAO itemDAO = MySQLFactory.getItemDAO();
               // System.out.println("asdsfd");
               // ArrayList<Item> items = itemDAO.getItems();
               /* DataMining data = new DataMining();
                if(data.exits(1)){
                    System.out.println("Exists film 1");
                } else{
                    System.out.println("Doesn't Exists film 1");
                }
                if(data.exits(14)){
                    System.out.println("Exists film 14");
                } else{
                    System.out.println("Doesn't Exists film 14");
                }*!

                /*ArrayList<Film> films;
                films = data.NotRankedList(1);

                for(int i=0;i<films.size();i++){
                    System.out.println("Pinicula: "+ films.get(i).getTitle()+" Rate="+data.getRate(1, films.get(i).getIdFilm()));
                    System.out.println("Item="+data.getItem(films.get(i).getIdItem()).getIdItem());
                }*/
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

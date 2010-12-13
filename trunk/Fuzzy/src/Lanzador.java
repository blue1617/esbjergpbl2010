import control.DataMining;
import control.Fuzzifier;
import control.FuzzyReasoning;
import control.Similarity;
import java.lang.Double;
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

        
		
                 

                //ItemDAO itemDAO = MySQLFactory.getItemDAO();
                //FilmDAO filmDAO = MySQLFactory.getFilmDAO();
                UserDAO userDAO = MySQLFactory.getUserDAO();
                ArrayList<User> allUsers = userDAO.getUsers();
                //ArrayList<Film> allMovies = filmDAO.getFilms();
               // System.out.println("asdsfd");
                //ArrayList<Item> items = itemDAO.getItems();
                //System.out.println("total items number: "+items.size());
                DataMining data = new DataMining();
                data.get10R1(2);
                //Similarity.getNeighbourhood(13,allUsers);
                //ArrayList<Film> targetMovies = data.NotRankedList(13);
                //ArrayList<Film> ratedMovies = data.getRankedListGreaterThan(13,3);
                //System.out.println("size-> "+ratedMovies.size());
                //FuzzyReasoning reasoning = new FuzzyReasoning();
                //Iterator<Film> it = targetMovies.iterator();
                //System.out.println("Movies user number 36 has rated: ");
                //FuzzyReasoning brain = new FuzzyReasoning();
                //System.out.println("similarity user ->"+brain.r3(1,2, allMovies));
                /*ArrayList<Double> rankR1 = new ArrayList<Double>();
                double maxR1 = 0;
                while(it.hasNext()){
                    Film targetFilm = it.next();
                    //System.out.println(targetFilm.getTitle() + " --with rate-- "+data.getRate(36,targetFilm.getIdFilm()));
                    double a= brain.r1(data.getItem(targetFilm.getIdItem()), ratedMovies, 13);
                    if(a > maxR1)
                        maxR1 = a;
                    rankR1.add(a);
                    
                }

                for(int i=0; i<rankR1.size();i++){
                    System.out.println("previous value ->" + rankR1.get(i));
                    double temp= rankR1.get(i);
                    rankR1.set(i, temp/maxR1);
                    System.out.println("current value ->" + rankR1.get(i));
                    System.out.println("");
                }*/

                /*for(int i=0;i<films.size();i++){
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

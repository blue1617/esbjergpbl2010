/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import model.dto.Film;
import model.dto.Item;
import model.dto.User;


/**
 *
 * @author daniele
 */
public class FuzzyReasoning {



    // arrayList e is a list of items an user has rated
    public double r1(Item j, ArrayList<Film> ratedFilms,int idUser) throws SQLException{
        DataMining data = new DataMining();
        double sum = 0;
        Iterator it =ratedFilms.iterator();
        while(it.hasNext()){
            Film element = (Film) it.next();
            double a=Fuzzifier.fuzzifyRate(data.getRate(idUser,element.getIdFilm()));
            double b=Similarity.cosineItemSimilarity(j, data.getItem(element.getIdItem()));
            System.out.println("the similarity: between "+j.getIdItem() + " and "+data.getItem(element.getIdFilm()) + b);

            double c=Similarity.fuzzyTheoreticProximity(j,data.getItem(element.getIdItem()));
            System.out.println("the minkowsky similarity is: " + c);
            
            sum = sum + (a*b);
        }
        return sum;
    }

    //also known as supTnormComposition
    public double r2(Item j, ArrayList<Film> ratedFilms,int idUser) throws SQLException{
        DataMining data = new DataMining();
        double min = 0;
        double max = 0;
        Iterator it =ratedFilms.iterator();
        while(it.hasNext()){
            Film element = (Film) it.next();
            double similarity= Similarity.cosineItemSimilarity(j, data.getItem(element.getIdItem()));
            double fuzzyRate = Fuzzifier.fuzzifyRate(data.getRate(idUser,element.getIdFilm())) ;
            min = similarity <  fuzzyRate ? similarity : fuzzyRate;
            
           if(max ==0)
                max = min;
           else
               max = max<min ? max : min;
            System.out.println("the similarity: " + max);
     
        }
        return max;
    }

    public static double supTnormComposition(int idUser,Item j,ArrayList<Film> listFilm) throws SQLException
    {
        double min = 0;
        double max = 0;
        DataMining data = new DataMining();
        Iterator it =listFilm.iterator();
        while(it.hasNext()){
            Film element = (Film) it.next();
            double similarity= Similarity.cosineItemSimilarity(j, data.getItem(element.getIdItem()));
            //the fuzzifyRate is also known as P plus
            double fuzzyRate = Fuzzifier.fuzzifyRate(data.getRate(idUser,element.getIdFilm())) ;

            min = similarity <  fuzzyRate ? similarity : fuzzyRate;
            
            max = max > min ? max : min;
        
        }
        System.out.println("the supTnormComposition value is: " + max);
        return max;
    }

    public static double supTnormCompositionMinus(int idUser,Item j,ArrayList<Film> listFilm) throws SQLException
    {
        double min = 0;
        double max = 0;
        DataMining data = new DataMining();
        Iterator it =listFilm.iterator();
        while(it.hasNext()){
            Film element = (Film) it.next();
            double similarity= Similarity.cosineItemSimilarity(j, data.getItem(element.getIdItem()));
            //the fuzzifyRate is also known as P plus
            double fuzzyRate = Fuzzifier.complementFuzzifyRate(data.getRate(idUser,element.getIdFilm())) ;
            min = similarity <  fuzzyRate ? similarity : fuzzyRate;

           if(max ==0)
                max = min;
           else
               max = max > min ? max : min;

        }
          System.out.println("the supTnormCompositionMinus value is: " + max);
        return max;
    }

    //the implicator will be the min(1, 1- x + y)
    private static double implicator(double a, double b)

    {
        double min = 0;
        min = 1 < 1-a+b ? 1 : 1- a + b;
        return min;
        
    }

    public static double r3(int idUser1, int idUser2,ArrayList<Film> listFilm) throws SQLException
    {
        double result = 1000 ;
        double min1 = -100;
        DataMining data = new DataMining();
        Iterator it =listFilm.iterator();
        while(it.hasNext()){
            Film element = (Film) it.next();
            //the fuzzifyRate is also known as P plus
            double fuzzyRate = Fuzzifier.fuzzifyRate(data.getRate(idUser1,element.getIdFilm())) ;
            double fuzzyRateMinus = Fuzzifier.complementFuzzifyRate(data.getRate(idUser1,element.getIdFilm()));

            double supPlus = supTnormComposition(idUser2, data.getItem(element.getIdFilm()), listFilm);
            double supMinus = supTnormCompositionMinus(idUser2, data.getItem(element.getIdFilm()), listFilm);
          
            
            min1 = implicator(fuzzyRate,supPlus)<implicator(fuzzyRateMinus, supMinus) ? implicator(fuzzyRate,supPlus) : implicator(fuzzyRateMinus, supMinus);
            
            result  = result < min1 ? result : min1;

        }

        System.out.println("the r3 is: " + result);
        return result;
    }

    public static double predictionPlus(ArrayList<User> users, int idUser,Item j,ArrayList<Film> films) throws SQLException
    {
        double result = 0;
        double min;
        double supTNorm;
        double userSimilarity;
        Iterator<User> it = users.iterator();
        while(it.hasNext())
        {
            User currentUser = it.next();
            supTNorm = FuzzyReasoning.supTnormComposition(currentUser.getIdUser(),j,films);
            userSimilarity = FuzzyReasoning.r3(idUser,currentUser.getIdUser(), films);

            min = supTNorm < userSimilarity ? supTNorm : userSimilarity;

            result = result > min ? result : min; 
        }


        return result;
    }

  
}

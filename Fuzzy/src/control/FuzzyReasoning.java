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
            System.out.println("the similarity: " + b);
            sum = sum + (a*b);
        }
        return sum;
    }

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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import model.dto.Item;
import model.dto.User;

/**
 *
 * @author daniele
 */
public class Similarity {

    public static double cosineItemSimilarity(Item i,Item j){
        HashMap<String,Double> a= Fuzzifier.getFuzzyVector(i);
        HashMap<String,Double> b= Fuzzifier.getFuzzyVector(j);
        double denominator =0;
        double numerator = 0;
        Iterator it =a.entrySet().iterator();
        Iterator it2 =b.entrySet().iterator();
        double sum1 = 0;
        double sum2 = 0;
        while(it.hasNext()){
            Entry<String,Double> element1 = (Entry<String, Double>) it.next();
            Entry<String,Double> element2 = (Entry<String, Double>) it2.next();
            numerator = numerator + element1.getValue()*element2.getValue();


            sum1 =sum1 + Math.pow(element1.getValue(), 2);
            sum2 =sum2 + Math.pow(element2.getValue(), 2);
        }

        denominator = Math.sqrt(sum1)*Math.sqrt(sum2);
        //System.out.println("similarity between" + i.getIdItem()+" and " + j.getIdItem()+ "is: " + numerator/denominator);
        return numerator/denominator;
    }

    private static double minkowskiDistance( Item i, Item j)
    {
        double sum = 0;
        HashMap<String,Double> a= Fuzzifier.getFuzzyVector(i);
        HashMap<String,Double> b= Fuzzifier.getFuzzyVector(j);

        Iterator it =a.entrySet().iterator();
        Iterator it2 =b.entrySet().iterator();

        while(it.hasNext()){
            Entry<String,Double> element1 = (Entry<String, Double>) it.next();
            Entry<String,Double> element2 = (Entry<String, Double>) it2.next();
            sum = sum + Math.pow(element1.getValue()-element2.getValue(),2);

        }

        return Math.sqrt(sum);
        
    }

    //we are 50% sure this is correctly calculated
    //fuzzy theoretic proximity , Minokowski distance based
    public static double fuzzyTheoreticProximity(Item i, Item j)
    {
        double sum =0 ;
        double d = minkowskiDistance(i, j);

        HashMap<String,Double> a= Fuzzifier.getFuzzyVector(i);
        HashMap<String,Double> b= Fuzzifier.getFuzzyVector(j);

        Iterator it =a.entrySet().iterator();
        Iterator it2 =b.entrySet().iterator();

        while(it.hasNext()){
            Entry<String,Double> element1 = (Entry<String, Double>) it.next();
            Entry<String,Double> element2 = (Entry<String, Double>) it2.next();
            double e =  element1.getValue() > element2.getValue() ?  element1.getValue():element2.getValue();
            
            sum = sum + e;
        }
        //System.out.println("the sum is: " + sum);
        //System.out.println("the similarity 2 is equal to: " + (1 - (d/sum)));
        return  1 - (d/sum);
    }

    public static ArrayList<User> getNeighbourhood(int idUser,ArrayList<User> allUsers) throws SQLException{
        ArrayList<User> neighbourhood = new ArrayList<User>();
        HashMap<User,Double> rankedUsers = new HashMap<User, Double>();
        DataMining data = new DataMining();
        //get all the rated movie from idUser
        HashMap<Integer,Integer> IdsTarget = data.getAllRatedFilms(idUser);
        //while allUsers
        Iterator<User> it = allUsers.iterator();
        while(it.hasNext()){
            User currentUser = it.next();
            double sum = 0;
            //get all the rated movie from current user
            HashMap<Integer,Integer> ids = data.getAllRatedFilms(currentUser.getIdUser());
            //only on the common rated movies
            Set<Integer> dunno = ids.keySet();
            dunno.retainAll(IdsTarget.keySet());
            //do euclidian similarity
            Iterator<Integer> itDunno = dunno.iterator();
            while(itDunno.hasNext()){
                int idMovie = itDunno.next();
                double a = Fuzzifier.fuzzifyRate(IdsTarget.get(idMovie));
                double b = Fuzzifier.fuzzifyRate(ids.get(idMovie));
                double plus = Math.pow((a-b),2);
                sum = sum + plus;
            }
            double score = Math.sqrt(sum);
            rankedUsers.put(currentUser,score);
        }
        System.out.println("one:"+rankedUsers.size()+"\n"+rankedUsers);
        sortOutTen(rankedUsers);
        return neighbourhood;
    }


    private static ArrayList<User> sortOutTen(HashMap<User,Double> rankedUsers){
        ArrayList<User> sortedUsers = new ArrayList<User>();
        List mapValues = new ArrayList(rankedUsers.values());
        Collections.sort(mapValues);
        System.out.println("fuck you mofo:"+mapValues.size()+"\n "+mapValues);
        /*Iterator<Entry<Integer, User>> iterator = rankedUsers.entrySet().iterator();
        while(iterator.hasNext()){

            User aux = new User();
            if(iterator.next().)
   
        }
        }*/

        //Map<Double,User> sortedMap = new TreeMap<Double, User>(rankedUsers);
        //System.out.println("two:"+sortedMap+"\n"+sortedMap);
        return sortedUsers;
    }






    

}

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

    private static final int TOTATTRIB = 26;

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
        return sortOutTen(rankedUsers);
        
    }



    
    private static ArrayList<User> sortOutTen(HashMap<User,Double> x) {
        ArrayList<User> rankedUser = new ArrayList<User>();
        Object temp = null;
        Object[] xArray = x.entrySet().toArray();
        for(int j=0;j<xArray.length;j++) {
            for(int i=j;i<xArray.length;i++) {
                Entry<User,Double> a = (Entry<User, Double>) xArray[j];
                Entry<User,Double> b = (Entry<User, Double>) xArray[i];
                if(a.getValue()>b.getValue()) {
                    temp = xArray[j];
                    xArray[j]=xArray[i];
                    xArray[i]=temp;
                }//fine if
            }//fine for
        }//fine for
        //System.out.println("lenght ->"+xArray.length);
        for(int f=0;f<10;f++){
            Entry<User,Double> element = (Entry<User, Double>) xArray[f];
            rankedUser.add(element.getKey());
        }
        return rankedUser;
    }//fine bubbleSort




    public static ArrayList<ArrayList<Item>> clustering (ArrayList<Item> allItems, int clustNumber){
        ArrayList<ArrayList<Item>> clusters = new ArrayList<ArrayList<Item>>();
        for(int i=0; i< clustNumber; i++){
            ArrayList<Item> cluster = new ArrayList<Item>();
            cluster.add(allItems.get(i));
            clusters.add(cluster);
        }
int count = 0;
do{
        for(int i=0;i<allItems.size();i++){
            double distance = 100000000;
            int pointer = 0;
            for(int j=0; j< clusters.size(); j++){
                Collection<Double> centroid = calculateCentroid(clusters.get(j));
                //euclidian distance between items[i] and cluster[j]
                //the centroid is in the first position of the cluster
                double temp = euclidianDistance(allItems.get(i),centroid);
                if(temp < distance){
                    distance=temp;
                    pointer=j;
                }
                clusters.get(j).remove(allItems.get(i));
            }
            //assign the membership value of the item to a cluster
            clusters.get(pointer).add(allItems.get(i));

        }
        for(int x=0;x<clusters.size();x++){
            System.out.println("size cluster"+x+" -> "+clusters.get(x).size());
        }
        System.out.println("<------>");
        count++;
}while(count != 5);
        return clusters;

    }

    private static double euclidianDistance(Item i,Collection<Double> centroid){
        Collection<Double> a= Fuzzifier.getFuzzyVector(i).values();
        //Collection<Double> b= Fuzzifier.getFuzzyVector(centroid).values();
        double sum = 0;
        Iterator<Double> it =a.iterator();
        Iterator<Double> it2 =centroid.iterator();
        while(it.hasNext()){
            double element1 = it.next();
            double element2 = it2.next();
            sum = sum + Math.pow(element1-element2,2);
        }

        return Math.sqrt(sum);

    }

    public static Collection<Double> calculateCentroid(ArrayList<Item> clusterItems){
        ArrayList<Double> centroid = new ArrayList<Double>();
        for(int x=0;x<TOTATTRIB;x++){
            centroid.add(0.0);
        }
        for(int i=0; i< clusterItems.size();i++){
            Collection<Double> attributes = Fuzzifier.getFuzzyVector(clusterItems.get(i)).values();
            Iterator<Double> it =attributes.iterator();
            int j=0;
            while(it.hasNext()){
                centroid.set(j,centroid.get(j)+ it.next());
                j++;
            }
        }
        for(int i=0; i< centroid.size();i++){
            centroid.set(i, centroid.get(i)/clusterItems.size());
        }

        /*for(int x=0;x<centroid.size();x++){
            System.out.print(centroid.get(x)+"\t");
        }*/
        return centroid;
    }


    

}

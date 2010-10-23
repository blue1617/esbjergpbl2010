/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author daniele
 */
public class FuzzyReasoning {

    public static double supTcompositionPlus(Item i,User u){
        double max=0.0;
        Iterator<Entry<Integer,Double>> it= i.getSimilarityItem().entrySet().iterator();
        //double value = i.getSimilarityItem().get(i.getId());
        while(it.hasNext()){
            Entry<Integer,Double> element = it.next();
            double rate = u.getPlusRatings().get(element.getKey());
            double similarity = element.getValue();
            double min = fMmin(rate, similarity);
            max = fMax(min,max);

        }

        return max;
    }


    public static double supTcompositionMin(Item i,User u){
        double max=0.0;
        Iterator<Entry<Integer,Double>> it= i.getSimilarityItem().entrySet().iterator();
        //double value = i.getSimilarityItem().get(i.getId());
        while(it.hasNext()){
            Entry<Integer,Double> element = it.next();
            double rate = u.getMinusRatings().get(element.getKey());
            double similarity = element.getValue();
            double min = fMmin(rate, similarity);
            max = fMax(min,max);

        }

        return max;
    }

    public static double similarityUsers(User u,User x,ArrayList<Item> items){
        //this need to be initialazed to the max possible value
        //that should be 1, but i'm not sure
        double min = 100000;
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            double pPlus = u.getPlusRatings().get(i.getId());
            double supCompPlus = supTcompositionPlus(i, x);
            double pMin = u.getMinusRatings().get(i.getId());
            double supCompMin = supTcompositionMin(i, x);
            double tempMin = fMmin(implicator(pPlus, supCompPlus),implicator(pMin, supCompMin));
            min = fMmin(tempMin,min);
        }
        
        return min;
    }

    public static double predictionPlus(User u, Item i,ArrayList<User> users,ArrayList<Item> items){
        double max=0;
        Iterator<User> itUs = users.iterator();
        while(itUs.hasNext()){
            User user= itUs.next();
            double supCompPlus = supTcompositionPlus(i,user);
            double simUsers = similarityUsers(user, u, items);
            double min = fMmin(supCompPlus, simUsers);
            max= fMax(min, max);
        }
        return max;
    }

    public static double predictionMin(User u, Item i,ArrayList<User> users,ArrayList<Item> items){
        double max=0;
        Iterator<User> itUs = users.iterator();
        while(itUs.hasNext()){
            User user= itUs.next();
            double supCompMin = supTcompositionMin(i,user);
            double simUsers = similarityUsers(user, u, items);
            double min = fMmin(supCompMin, simUsers);
            max= fMax(min, max);
        }
        return max;
    }


    private static double fMax(double x,double y){
        if(x>y)
            return x;
        else
            return y;
    }

    private static double fMmin(double x,double y){
        if(x<y)
            return x;
        else
            return y;
    }

    private static double implicator(double x,double y){
        double result = 1 - x + y;
        if(result >= 1)
            return 1;
        else
            return result;
    }

}

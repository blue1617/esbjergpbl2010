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

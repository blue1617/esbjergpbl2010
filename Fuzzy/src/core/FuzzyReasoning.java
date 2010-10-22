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

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import model.dto.Item;

/**
 *
 * @author daniele
 */
public class Fuzzifier {

    public HashMap<String,Double> getFuzzyVector(Item i){

        HashMap<String,Double> result = new HashMap<String, Double>();

        Iterator it =i.getRank().entrySet().iterator();

        switch(i.total()){
            //if item has just one genre
            case 1:
                while(it.hasNext()){
                    Entry<String,Integer> element = (Entry<String, Integer>) it.next();
                    if(element.getValue()==1){
                        result.put(element.getKey(), 1.0);
                    }else{
                        result.put(element.getKey(),0.0);
                    }
                }
                return result;
            //if item has two genres
            case 2:
                while(it.hasNext()){
                    Entry<String,Integer> element = (Entry<String, Integer>) it.next();
                    if(element.getValue()==1){
                        result.put(element.getKey(), 0.8);
                    }else if(element.getValue()==2){
                        result.put(element.getKey(),0.2);
                    }else{
                        result.put(element.getKey(),0.0);
                    }
                }
               return result;
            //if item has three genres
            case 3:
                while(it.hasNext()){
                    Entry<String,Integer> element = (Entry<String, Integer>) it.next();
                    if(element.getValue()==1){
                        result.put(element.getKey(), 0.7);
                    }else if(element.getValue()==2){
                        result.put(element.getKey(),0.3);
                    }else if(element.getValue()==3){
                        result.put(element.getKey(),0.1);
                    }else{
                        result.put(element.getKey(),0.0);
                    }
                }
                return result;
            //if item has more than three
            default:
                while(it.hasNext()){
                    Entry<String,Integer> element = (Entry<String, Integer>) it.next();
                    if(element.getValue()!=0){
                        result.put(element.getKey(),gaussianMembership(element.getValue(),i.total()));
                    }else{
                        result.put(element.getKey(),0.0);
                    }
                }

                return result;
        }

    }


    private double gaussianMembership(int position,int total){
        double alpha = 1.2;
        double denominator = Math.pow(2,Math.sqrt(alpha*total*(position-1)));
        return position/denominator;
    }

}

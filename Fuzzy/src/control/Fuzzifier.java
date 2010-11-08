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


        switch(i.total()){
            //if item has just one genre
            case 1:
                Iterator it =i.getRank().entrySet().iterator();
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
               break;
            //if item has three genres
            case 3:break;
            //if item has more than three
            default:break;
        }








        return null;
    }

}

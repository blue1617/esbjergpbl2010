/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import model.dto.Item;


/**
 *
 * @author daniele
 */
public class FuzzyReasoning {



    // arrayList e is a list of items an user has rated
    public double r1(Item j, HashMap<Item,Integer> e){
        double sum = 0;
        Iterator it =e.entrySet().iterator();
        while(it.hasNext()){
            Entry<Item,Integer> element = (Entry<Item, Integer>) it.next();
            double a=Fuzzifier.fuzzifyRate(element.getValue());
            double b=Similarity.cosineItemSimilarity(j, element.getKey());
            sum = sum + (a*b);
        }
        return sum;
    }

}

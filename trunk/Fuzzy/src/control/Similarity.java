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

        return numerator/denominator;
    }

}

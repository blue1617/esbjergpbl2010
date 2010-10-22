/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



/**
 *
 * @author daniele
 */
public class User {

    private int id;

    HashMap<Integer,Double> plusRatings;
    HashMap<Integer,Double> minusRatings;
    
    public User(int id) {
        this.id = id;
        this.plusRatings= new HashMap<Integer, Double>();
        this.minusRatings= new HashMap<Integer, Double>();
    }

    public int getId(){
        return this.id;
    }

    public void addRatings(Item i,int rate){
        this.plusRatings.put(i.getId(),this.pPlus(rate));
        this.minusRatings.put(i.getId(),this.pMinus(rate));
    }

    public HashMap<Integer,Double> getPlusRatings(){
        return this.plusRatings;
    }

    public HashMap<Integer,Double> getMinusRatings(){
        return this.minusRatings;
    }


    private double pPlus(int rate){
        double result;
        if(rate>0)
            result = (double)(rate-1)/4;
        else
            result = (double)0;
        return  result;
    }

        private double pMinus(int rate){
        double result;
        if(rate>0)
            result = (double)(5-rate)/4;
        else
            result = (double)0;
        return  result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("User"+ this.getId()+ " [");

        Iterator<Entry<Integer,Double>> it= this.plusRatings.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer,Double> element = it.next();
            result.append(element.getValue()+",");
        }
        result.append("]");

        result.append("  /-/  [");

        Iterator<Entry<Integer,Double>> itmin= this.minusRatings.entrySet().iterator();
        while(itmin.hasNext()){
            Entry<Integer,Double> element = itmin.next();
            result.append(element.getValue()+",");
        }
        result.append("]");
        return result.toString();

    }



}

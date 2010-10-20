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

    HashMap<Integer,Double> ratings;
    
    public User(int id) {
        this.id = id;
        this.ratings= new HashMap<Integer, Double>();
    }

    public int getId(){
        return this.id;
    }

    public void addRatings(Item i,int rate){
        this.ratings.put(i.getId(),this.pPlus(rate));
    }


    private double pPlus(int rate){
        double result;
        if(rate>0)
            result = (double)(rate-1)/4;
        else
            result = (double)0;
        return  result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("User"+ this.getId()+ " [");

        Iterator<Entry<Integer,Double>> it= this.ratings.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer,Double> element = it.next();
            result.append(element.getValue()+",");
        }

        return result.toString();

    }



}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author daniele
 */
public class Item {

    private int id;

    HashMap<Integer,Double> similarityItem;

    public Item(int id) {
        this.id = id;
        this.similarityItem = new HashMap<Integer, Double>();
    }

    public int getId(){return this.id;}

    public void addSimilarityItem(Item i,double degree){
        this.similarityItem.put(i.getId(), degree);
    }

    public HashMap<Integer,Double> getSimilarityItem(){
        return this.similarityItem;
    }


        @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Item"+ this.getId()+ " [");

        Iterator<Entry<Integer,Double>> it= this.similarityItem.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer,Double> element = it.next();
            result.append(element.getValue()+",");
        }
        result.append("]");

        return result.toString();

    }

}

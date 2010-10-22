/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import core.FuzzyReasoning;
import core.Item;
import core.User;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author daniele
 */
public class Test {

    public static void main(String[] args) {

        //i'm creating the users and items via code but these should be fetched from the db
        //3 users
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 1; i <= 3; i++) {
            users.add(new User(i));
         }
       
        //and 8 items
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 1; i <= 8; i++) {
            items.add(new Item(i));
         }
        
        //again this ratings should be obtained from db
        Integer[] ratingsUser1 = {0,5,1,4,0,0,0,0};
        Integer[] ratingsUser2 = {5,0,0,3,0,1,0,0};
        Integer[] ratingsUser3 = {0,5,0,0,1,0,0,0};
        Integer[][] usersRatings = {ratingsUser1, ratingsUser2, ratingsUser3};

        //similarity items, we still dont know how to obtains these values
        //we can figure it out later
        Double[] similarityItem1 = {1.0,0.85,0.2,0.75,0.1,0.0,0.9,0.0};
        Double[] similarityItem2 = {0.85,1.0,0.25,0.05,0.0,0.3,0.0,0.1};
        Double[] similarityItem3 = {0.2,0.25,1.0,0.0,0.1,0.9,0.0,1.0};
        Double[] similarityItem4 = {0.75,0.05,0.0,1.0,0.95,0.3,0.1,0.35};
        Double[] similarityItem5 = {0.1,0.0,0.1,0.95,1.0,0.15,0.8,0.0};
        Double[] similarityItem6 = {0.0,0.3,0.9,0.3,0.15,1.0,0.25,0.1};
        Double[] similarityItem7 = {0.9,0.0,0.0,0.1,0.8,0.25,1.0,0.0};
        Double[] similarityItem8 = {0.0,0.1,1.0,0.35,0.0,0.1,0.0,1.0};
        Double[][] similarityItems = {similarityItem1,similarityItem2,similarityItem3,similarityItem4,
                                        similarityItem5,similarityItem6,similarityItem7,similarityItem8};



        //in this cycle i fulfill the users and items respectively with
        //the ratings and the similarity degrees so we can work with
        //TODO: to implement better
        for(int j=0; j<users.size();j++){
            User user = users.get(j);
            Iterator<Item> iItms = items.iterator();
            int i=0;
            while(iItms.hasNext()){
                Item item = iItms.next();
                user.addRatings(item,usersRatings[j][i]);
                for(int x=0; x< items.size();x++){
                    item.addSimilarityItem(items.get(x), similarityItems[i][x]);
                }
                i++;
            }
        }

        
        //double wot= FuzzyReasoning.supTcompositionMin(items.get(6),users.get(1));
        //System.out.println(wot);
        double wot= FuzzyReasoning.similarityUsers(users.get(2), users.get(0),items);
        System.out.println(wot);
//        System.out.println(users.get(0).toString());
//        System.out.println(users.get(1).toString());
//        System.out.println(users.get(2).toString());
//
//        System.out.println(items.get(0).toString());
//        System.out.println(items.get(7).toString());




    }

}

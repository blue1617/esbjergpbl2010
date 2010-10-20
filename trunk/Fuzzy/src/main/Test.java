/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

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
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        //and 8 items
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 1; i < 8; i++) {
            items.add(new Item(i));
         }

        //again this ratings should be obtained from db
        Integer[] ratingsUser1 = {0,5,1,4,0,0,0,0};

        Iterator<Item> iItms = items.iterator();
        int i=0;
        while(iItms.hasNext()){
            user1.addRatings(iItms.next(),ratingsUser1[i]);
            i++;
        }

        System.out.println(user1.toString());

        //System.out.println((double)3/4);



    }

}

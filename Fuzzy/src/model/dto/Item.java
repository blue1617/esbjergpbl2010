/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author keldor
 */
public class Item {
    private int idItem;
    /*int action, adventure, animation, biography, comedy,
        crime, documentary, drama, family, fantasy, film_noir,
        gameshow, history, horror, music, musical, mistery, news,
        reality_tv, romance, science_fiction, sport,
        talk_show, thriller, war, western;*/

    private HashMap<String,Integer> rank;

    public Item(int idItem, int action, int adventure, int animation, int biography, int comedy, int crime, int documentary, int drama, int family, int fantasy, int film_noir, int gameshow, int history, int horror, int music, int musical, int mistery, int news, int reality_tv, int romance, int science_fiction, int sport, int talk_show, int thriller, int war, int western) {
        this.idItem=idItem;
        this.rank= new HashMap<String, Integer>();
        rank.put("action", action);
        rank.put("adventure", adventure);
        rank.put("animation", animation);
        rank.put("biography", biography);
        rank.put("comedy", comedy);
        rank.put("crime", crime);
        rank.put("documentary", documentary);
        rank.put("drama", drama);
        rank.put("family", family);
        rank.put("fantasy", fantasy);
        rank.put("film_noir", film_noir);
        rank.put("gameshow", gameshow);
        rank.put("history", history);
        rank.put("horror", horror);
        rank.put("music", music);
        rank.put("musical", musical);
        rank.put("mistery", mistery);
        rank.put("news", news);
        rank.put("reality_tv", reality_tv);
        rank.put("romance", romance);
        rank.put("science_fiction", science_fiction);
        rank.put("sport",sport);
        rank.put("talk_show", talk_show);
        rank.put("thriller", thriller);
        rank.put("war", war);
        rank.put("western", western);
    }

    public int total(){
        int total = 0;
        Iterator it =this.rank.entrySet().iterator();
        while(it.hasNext()){
            Entry<String,Integer> element = (Entry<String, Integer>) it.next();
            //System.out.println(element.getKey()+" -> "+element.getValue());
            if(element.getValue()!=0){
                total++;
            }
        }

        return total;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public HashMap<String, Integer> getRank() {
        return rank;
    }

    public void setRank(HashMap<String, Integer> rank) {
        this.rank = rank;
    }





    



}

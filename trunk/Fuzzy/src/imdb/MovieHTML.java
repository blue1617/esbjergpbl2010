/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imdb;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class MovieHTML {

	private int id;
	private String title;
	private String releaseDate;
	private ArrayList<String> rankedGenres;

	public MovieHTML(int id,String title,String relaseDate){
		this.id = id;
		this.title = title;
		this.releaseDate = relaseDate;
	}

	public int getId(){return this.id;};
	public String getTitle(){return this.title;};

	

	public void setRankedGenres(ArrayList<String> genres){
		this.rankedGenres=genres;
	}

	public ArrayList<String> getRankedGenre() {return this.rankedGenres;}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
        result.append( this.getId()+ " - ");
        result.append(this.getTitle()+ " - ");
        result.append(this.releaseDate()+ " - ");
        result.append("[");
        Iterator<String> it = this.rankedGenres.iterator();
        while(it.hasNext()){
        	result.append(it.next()+" ");
        }
        result.append("]");
        return result.toString();
	}

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public HashMap<String, Integer> lista() {
        HashMap<String,Integer> rank;
        rank= new HashMap<String, Integer>();
        rank.put("action", 0);
        rank.put("adventure", 0);
        rank.put("animation", 0);
        rank.put("biography", 0);
        rank.put("comedy", 0);
        rank.put("crime", 0);
        rank.put("documentary", 0);
        rank.put("drama", 0);
        rank.put("family", 0);
        rank.put("fantasy", 0);
        rank.put("film-noir", 0);
        rank.put("gameshow", 0);
        rank.put("history", 0);
        rank.put("horror", 0);
        rank.put("music", 0);
        rank.put("musical", 0);
        rank.put("mystery", 0);
        rank.put("news", 0);
        rank.put("reality-tv", 0);
        rank.put("romance", 0);
        rank.put("sci-fi", 0);
        rank.put("sport",0);
        rank.put("talk-show", 0);
        rank.put("thriller", 0);
        rank.put("war", 0);
        rank.put("western", 0);
        for(int i=0;i<this.rankedGenres.size();i++){
            
            rank.put(this.getRankedGenre().get(i),(i+1));
        }

        return rank;
    }

    public String releaseDate(){
                String sDay="", pro="";
                String sMon="";
                String sYear="";
                String retu="";
                sDay = ""+this.releaseDate.charAt(0)+this.releaseDate.charAt(1);
                pro = ""+this.releaseDate.charAt(3)+this.releaseDate.charAt(4)+this.releaseDate.charAt(5);
                if(pro.equals("Jan"))
                    sMon ="01";
                if(pro.equals("Feb"))
                    sMon ="02";
                if(pro.equals("Mar"))
                    sMon ="03";
                if(pro.equals("Apr"))
                    sMon ="04";
                if(pro.equals("May"))
                    sMon ="05";
                if(pro.equals("Jun"))
                    sMon ="06";
                if(pro.equals("Jul"))
                    sMon ="07";
                if(pro.equals("Aug"))
                    sMon ="08";
                if(pro.equals("Sep"))
                    sMon ="09";
                if(pro.equals("Oct"))
                    sMon ="10";
                if(pro.equals("Nov"))
                    sMon ="11";
                if(pro.equals("Dec"))
                    sMon ="12";
                sYear = ""+this.releaseDate.charAt(7)+this.releaseDate.charAt(8)+this.releaseDate.charAt(9)+this.releaseDate.charAt(10);
                retu = sYear+sMon+sDay;
          return retu;
        }
}


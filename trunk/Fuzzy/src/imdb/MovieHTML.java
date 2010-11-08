/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imdb;

import java.util.ArrayList;
import java.util.Iterator;


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
	public String releaseDate(){return this.releaseDate;};

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


}


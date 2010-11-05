/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dto;

/**
 *
 * @author keldor
 */
public class Film {
    int idFilm;
    int idItem;
    String title;
    String director;
    String date;

    public void Film(int fil, int ite, String titl, String directo, String dat){
        this.idFilm = fil;
        this.idItem = ite;
        this.title = titl;
        this.director = directo;
        this.date = dat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilmM) {
        this.idFilm = idFilmM;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}

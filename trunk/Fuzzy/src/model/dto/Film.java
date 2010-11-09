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
    String date;


    public Film(int fil, int ite, String titl, String dat){
        this.idFilm = fil;
        this.idItem = ite;
        this.title = titl;
        this.date = dat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

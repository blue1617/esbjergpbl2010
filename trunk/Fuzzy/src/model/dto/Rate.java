/*
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dto;

/**
 *
 * @author keldor
 */
public class Rate {
    private int idUser;
    private int idFilm;
    private int rank;

    public  Rate(int Film, int User, int rank){
        this.idUser = User;
        this.idFilm = Film;
        this.rank = rank;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}

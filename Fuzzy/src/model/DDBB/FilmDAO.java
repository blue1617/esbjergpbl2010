/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import imdb.MovieHTML;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Film;

/**
 *
 * @author keldor
 */
public interface FilmDAO {
    public ArrayList<Film> getFilms() throws SQLException;
    public Film getFilm(String film) throws SQLException;
    public void insertFilm(MovieHTML mov) throws SQLException;

}

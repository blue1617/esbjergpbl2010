/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;


import imdb.MovieHTML;
import java.sql.*;
import java.util.ArrayList;
import model.dto.Film;
import model.dto.User;

/**
 *
 * @author keldor
 */
public class MySQLFilmDAO extends MySQLDaoFactory implements FilmDAO{

    public ArrayList<Film> getFilms() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Film getFilm(String film) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void insertFilm(MovieHTML mov) throws SQLException {
            
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sentence = "INSERT INTO `Film` (`idFilm`, `idItem`, `Title`, `Year`) VALUES ('"+mov.getId()+"', '"+mov.getId()+"', '"+mov.getTitle()+"', '"+mov.releaseDate()+"');";
            System.out.println(sentence);
            sentencia.executeUpdate(sentence);

	    sentencia.close();
	    closeConnection(conexion);
	    
    }

}

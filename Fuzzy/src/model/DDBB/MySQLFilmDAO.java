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
            private int id;
            private String title;
            private String releaseDate;
            private ArrayList<String> rankedGenres;
        

            ArrayList<User> list = new ArrayList<User>();
            Connection conexion = getConnection();
            String sentence = "SELECT * FROM USER";
            Statement sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery( sentence );

	    while (rs.next()) {
		  User user = new User( rs.getInt("idUser"), rs.getInt("idItem"),
					rs.getString( "name" ), rs.getString( "surname" ),
					rs.getString( "birthday" ), rs.getString("country"), rs.getString("sex"), rs.getString("password"));
                  list.add(user);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    
    }

}

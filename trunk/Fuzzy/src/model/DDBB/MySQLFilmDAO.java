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


            ArrayList<User> list = new ArrayList<User>();
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sentence = "INSERT INTO `Film` (`"+mov.getId()+"`, `"+mov.getId()+"`, `Title`, `Year`) VALUES ('1', '1', 'hi wolrd', '1999-05-06');";
            statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");

           
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

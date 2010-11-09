/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;


import imdb.MovieHTML;
import java.sql.*;
import java.util.ArrayList;
import model.dto.Film;
import model.dto.Rate;
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

    public ArrayList<Film> getNotRankedFilms(ArrayList<Rate> Rates) throws SQLException {
        String sentence="select * from film where ";
        String sentence2="";
        ArrayList<Film> list = new ArrayList<Film>();
        for(int i=0;i<Rates.size();i++){
            if(i==0){
                sentence2=sentence2+"idFilm!="+Rates.get(i).getIdFilm();
            } else{
                sentence2=sentence2+" and "+"idFilm!="+Rates.get(i).getIdFilm();
            }
        }
        sentence=sentence+sentence2+";";
        System.out.println(sentence);
        Connection conexion = getConnection();
        Statement sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery( sentence );

	    while (rs.next()) {
		  Film film = new Film( rs.getInt("idFilm"), rs.getInt("idItem"),
					rs.getString( "Title" ), rs.getString( "Year" ));
                  list.add(film);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    return list;
    }

}

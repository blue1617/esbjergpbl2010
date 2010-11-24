/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;


import model.dto.Rate;
import imdb.MovieHTML;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Item;

/**
 *
 * @author keldor
 */
public class MySQLRateDAO extends MySQLDaoFactory implements RateDAO{

    public ArrayList<Rate> getRatesUser(int idUser) throws SQLException {
        String sentence="select * from Rate where idUser="+idUser+";";
        ArrayList<Rate> list = new ArrayList<Rate>();
        Connection conexion = getConnection();
        Statement sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery( sentence );

	    while (rs.next()) {
		  Rate rate = new Rate( rs.getInt("idFilm"), rs.getInt("idUser"),
					rs.getInt( "rate" ));
                  list.add(rate);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    return list;
    }

    public ArrayList<Rate> getTaresUserGreater(int idUser, int rate2) throws SQLException {
        String sentence="select * from Rate where idUser="+idUser+" and rate>"+rate2+";";
        ArrayList<Rate> list = new ArrayList<Rate>();
        Connection conexion = getConnection();
        Statement sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery( sentence );

	    while (rs.next()) {
		  Rate rate = new Rate( rs.getInt("idFilm"), rs.getInt("idUser"),
					rs.getInt( "rate" ));
                  list.add(rate);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    return list;
    }

    public ArrayList<Rate> getRatesFilm(int idFilm) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getRate(int idUser, int idFilm) throws SQLException {
        String sentence="select * from Rate where idUser="+idUser+" and idFilm="+idFilm+";";
        Connection conexion = getConnection();
        Statement sentencia = conexion.createStatement();
	ResultSet rs = sentencia.executeQuery( sentence );
        
		  Rate retu = new Rate( rs.getInt("idFilm"), rs.getInt("idUser"),
					rs.getInt( "rate" ));
                

	    sentencia.close();
	    closeConnection(conexion);
	    return retu.getRank();
    }

    public Rate Rate(int idUser, int idFilm) throws SQLException {
        String sentence="select * from Rate where idUser="+idUser+" and idFilm="+idFilm+";";
        Connection conexion = getConnection();
        Statement sentencia = conexion.createStatement();
	ResultSet rs = sentencia.executeQuery( sentence );
        rs.next();
	Rate rate = new Rate( rs.getInt("idFilm"), rs.getInt("idUser"),
					rs.getInt( "rate" ));
                  
               
	sentencia.close();
	closeConnection(conexion);
	return rate;
    }



}

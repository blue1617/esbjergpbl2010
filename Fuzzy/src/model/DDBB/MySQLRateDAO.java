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

    public ArrayList<Rate> getRatesFilm(int idFilm) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Rate getRate(int idUser, int idFilm) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

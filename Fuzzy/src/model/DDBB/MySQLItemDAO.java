/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import imdb.MovieHTML;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Item;

/**
 *
 * @author daniele
 */
public class MySQLItemDAO extends MySQLDaoFactory implements ItemDAO {

    public ArrayList<Item> getItems() throws SQLException {
        ArrayList<Item> list = new ArrayList<Item>();
        Connection conexion = getConnection();
        String sentence = "SELECT * FROM ITEM";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery( sentence );

        while (rs.next()) {
              Item item = new Item( rs.getInt("idItem"),
                                    rs.getInt("action"),
                                    rs.getInt("adventure"),
                                    rs.getInt("animation"),
                                    rs.getInt("biography"),
                                    rs.getInt("comedy"),
                                    rs.getInt("crime"),
                                    rs.getInt("documentary"),
                                    rs.getInt("drama"),
                                    rs.getInt("family"),
                                    rs.getInt("fantasy"),
                                    rs.getInt("film-noir"),
                                    rs.getInt("game-show"),
                                    rs.getInt("history"),
                                    rs.getInt("horror"),
                                    rs.getInt("music"),
                                    rs.getInt("musical"),
                                    rs.getInt("mistery"),
                                    rs.getInt("news"),
                                    rs.getInt("reality-tv"),
                                    rs.getInt("romance"),
                                    rs.getInt("science fiction"),
                                    rs.getInt("sport"),
                                    rs.getInt("talk-show"),
                                    rs.getInt("thriller"),
                                    rs.getInt("war"),
                                    rs.getInt("western"));
              list.add(item);
        }
        sentencia.close();
        closeConnection(conexion);
        return list;
    }

    public void insertItem(MovieHTML mov) throws SQLException {
        Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sentence = "INSERT INTO `Item` VALUES ('"+mov.getId()+"', '"+mov.lista().get("action")+"', '"+mov.lista().get("adventure")+"', '"+mov.lista().get("animation")+"', '"+mov.lista().get("biography")+"', '"+mov.lista().get("comedy")+"', '"+mov.lista().get("crime")+"', '"+mov.lista().get("documentary")+"', '"+mov.lista().get("drama")+"', '"+mov.lista().get("family")+"', '"+mov.lista().get("fantasy")+"', '"+mov.lista().get("film-noir")+"', '"+mov.lista().get("gameshow")+"', '"+mov.lista().get("history")+"', '"+mov.lista().get("horror")+"', '"+mov.lista().get("music")+"', '"+mov.lista().get("musical")+"', '"+mov.lista().get("mystery")+"', '"+mov.lista().get("news")+"', '"+mov.lista().get("reality-tv")+"', '"+mov.lista().get("romance")+"', '"+mov.lista().get("sci-fi")+"', '"+mov.lista().get("sport")+"', '"+mov.lista().get("talk-show")+"', '"+mov.lista().get("thriller")+"', '"+mov.lista().get("war")+"', '"+mov.lista().get("western")+"');";
            System.out.println(sentence);
            sentencia.executeUpdate(sentence);

	    sentencia.close();
	    closeConnection(conexion);
    }

    public Item getItem(int idItem) throws SQLException {
        ArrayList<Item> list = new ArrayList<Item>();
        Connection conexion = getConnection();
        String sentence = "SELECT * FROM ITEM where idItem="+idItem+";";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery( sentence );
        Item ite=null;
        while (rs.next()) {
              Item item = new Item( rs.getInt("idItem"),
                                    rs.getInt("action"),
                                    rs.getInt("adventure"),
                                    rs.getInt("animation"),
                                    rs.getInt("biography"),
                                    rs.getInt("comedy"),
                                    rs.getInt("crime"),
                                    rs.getInt("documentary"),
                                    rs.getInt("drama"),
                                    rs.getInt("family"),
                                    rs.getInt("fantasy"),
                                    rs.getInt("film-noir"),
                                    rs.getInt("game-show"),
                                    rs.getInt("history"),
                                    rs.getInt("horror"),
                                    rs.getInt("music"),
                                    rs.getInt("musical"),
                                    rs.getInt("mystery"),
                                    rs.getInt("news"),
                                    rs.getInt("reality-tv"),
                                    rs.getInt("romance"),
                                    rs.getInt("science fiction"),
                                    rs.getInt("sport"),
                                    rs.getInt("talk-show"),
                                    rs.getInt("thriller"),
                                    rs.getInt("war"),
                                    rs.getInt("western"));
              list.add(item);
              ite=item;
        }

        sentencia.close();
        closeConnection(conexion);
        return ite;
    }

}

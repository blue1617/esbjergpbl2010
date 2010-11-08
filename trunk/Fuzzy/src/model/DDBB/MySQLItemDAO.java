/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

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

}

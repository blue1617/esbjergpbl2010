/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import imdb.MovieHTML;
import model.dto.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author keldor
 */
public interface ItemDAO {
    public ArrayList<Item> getItems() throws SQLException;
    public Item getItem(int idItem) throws SQLException;
    public void insertItem(MovieHTML mov) throws SQLException;

}

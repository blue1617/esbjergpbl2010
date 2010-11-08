/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import model.dto.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author keldor
 */
public interface ItemDAO {
    public ArrayList<Item> getItems() throws SQLException;

}

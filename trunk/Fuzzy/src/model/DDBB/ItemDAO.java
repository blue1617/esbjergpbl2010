/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import model.dto.Item;
import java.sql.SQLException;

/**
 *
 * @author keldor
 */
public interface ItemDAO {
    public Item getItem(int idItem) throws SQLException;

}

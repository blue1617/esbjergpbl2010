/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.User;

/**
 *
 * @author keldor
 */
public interface UserDAO {
    public ArrayList<User> getUsers() throws SQLException;
}

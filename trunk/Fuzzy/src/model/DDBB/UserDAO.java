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
    public boolean validate(String name, String password) throws SQLException;
    public User getUser(String name) throws SQLException;
    public ArrayList<User> getUsersNotRanked() throws SQLException;
    public void dropUser(int idUser) throws SQLException;
}

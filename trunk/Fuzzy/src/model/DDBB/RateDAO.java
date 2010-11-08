/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DDBB;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Rate;

/**
 *
 * @author keldor
 */
public interface RateDAO {
    public ArrayList<Rate> getRatesUser(int idUser) throws SQLException;
    public ArrayList<Rate> getRatesFilm(int idFilm) throws SQLException;
    public Rate getRate(int idUser, int idFilm) throws SQLException;
}

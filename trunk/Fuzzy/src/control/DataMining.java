/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DDBB.DAOFactory;
import model.DDBB.FilmDAO;
import model.DDBB.RateDAO;
import model.dto.Film;

/**
 *
 * @author keldor
 */
public class DataMining {

    public DataMining(){
        
    }


    public ArrayList<Film> NotRankedList(int idUser) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        RateDAO rateDAO = MySQLFactory.getRateDAO();
        FilmDAO filmDAO = MySQLFactory.getFilmDAO();
        
    return filmDAO.getNotRankedFilms(rateDAO.getRatesUser(idUser));
    }
}

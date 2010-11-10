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
import model.DDBB.ItemDAO;
import model.DDBB.RateDAO;
import model.dto.Film;
import model.dto.Item;

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
    public ArrayList<Film> getRankedListGreaterThan(int idUser, int rate) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        RateDAO rateDAO = MySQLFactory.getRateDAO();
        FilmDAO filmDAO = MySQLFactory.getFilmDAO();
        ItemDAO itemDAO = MySQLFactory.getItemDAO();

        return filmDAO.getRankedFilms(rateDAO.getTaresUserGreater(idUser, rate));
    }
    public int getRate(int idUser,int idFilm) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        RateDAO rateDAO = MySQLFactory.getRateDAO();

        return rateDAO.Rate(idUser, idFilm).getRank();
    }
    public Item getItem(int idItem) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        ItemDAO itemDAO = MySQLFactory.getItemDAO();
        return itemDAO.getItem(idItem);
    }
}

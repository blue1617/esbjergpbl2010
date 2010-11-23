/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DDBB.DAOFactory;
import model.DDBB.FilmDAO;
import model.DDBB.ItemDAO;
import model.DDBB.RateDAO;
import model.DDBB.UserDAO;
import model.dto.Film;
import model.dto.Item;
import model.dto.Rate;

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
    public boolean exits(int idFilm) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        FilmDAO filmDAO = MySQLFactory.getFilmDAO();
        return filmDAO.exists(idFilm);
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
    public boolean validate(String name, String password) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        UserDAO userDAO = MySQLFactory.getUserDAO();
        return userDAO.validate(name, password);
    }

    public HashMap<Integer,Integer> getAllRatedFilms(int idUser) throws SQLException{
        DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
        RateDAO rateDAO = MySQLFactory.getRateDAO();
        ArrayList<Rate> rates= rateDAO.getRatesUser(idUser);
        HashMap<Integer,Integer> whateva = new HashMap<Integer, Integer>();
        for(int i=0; i<rates.size();i++){
            Rate rate = rates.get(i);
            whateva.put(rate.getIdFilm(),rate.getRank());
        }
        return whateva;

    }
}

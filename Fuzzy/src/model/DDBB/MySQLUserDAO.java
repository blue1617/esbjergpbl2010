package model.DDBB;

import java.sql.*;
import java.util.ArrayList;
import model.dto.User;

public class MySQLUserDAO extends MySQLDaoFactory implements UserDAO{

  public ArrayList<User> getUsers() throws SQLException{
            ArrayList<User> list = new ArrayList<User>();
            Connection conexion = getConnection();
            String sentence = "SELECT * FROM USER";
            Statement sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery( sentence );

	    while (rs.next()) {
		  User user = new User( rs.getInt("idUser"), rs.getInt("idItem"),
					rs.getString( "name" ), rs.getString( "surname" ),
					rs.getString( "birthday" ), rs.getString("country"), rs.getString("sex"), rs.getString("password"));
                  list.add(user);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    return list;
  }

    public boolean validate(String name, String password) throws SQLException {
        Connection conexion = getConnection();
        String sentence = "SELECT * FROM USER WHERE NAME='"+name+"';";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sentence);
        sentencia.close();
	    closeConnection(conexion);
        if((rs.getString("name").equals(name))&&(rs.getString("password").equals(password)))
            return true;
        else
            return false;
    }

    public User getUser(String name) throws SQLException {
        Connection conexion = getConnection();
        String sentence = "SELECT * FROM USER WHERE NAME='"+name+"';";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sentence);
        User user = new User( rs.getInt("idUser"), rs.getInt("idItem"),
					rs.getString( "name" ), rs.getString( "surname" ),
					rs.getString( "birthday" ), rs.getString("country"), rs.getString("sex"), rs.getString("password"));
        sentencia.close();
	closeConnection(conexion);
        return user;
    }

 
}
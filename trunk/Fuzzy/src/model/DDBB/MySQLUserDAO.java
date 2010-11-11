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
        boolean retu=false;
        String nam="", pass="";
        Connection conexion = getConnection();
        String sentence = "SELECT * FROM USER WHERE NAME='"+name+"';";
        System.out.println(sentence);
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sentence);
        while (rs.next()) {
            nam=rs.getString("name");
        pass=rs.getString("password");
        
        if((nam.equals(name))&&(pass.equals(password)))
            retu = true;
        else
            retu = false;
	    }
        sentencia.close();
	closeConnection(conexion);
        return retu;
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
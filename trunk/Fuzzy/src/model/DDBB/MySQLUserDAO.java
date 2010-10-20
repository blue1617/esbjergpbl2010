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
					rs.getString( "birthday" ), rs.getString("country"), rs.getString("sex"));
                  list.add(user);
	    }
	    sentencia.close();
	    closeConnection(conexion);
	    return list;
  }

  public int insertInformation() {
	// TODO Auto-generated method stub
	return 0;
  }

  public String getInformation() {
	// TODO Auto-generated method stub
	return null;
  }

 
}
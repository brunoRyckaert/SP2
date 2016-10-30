package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

//CTRL + SHIFT + O pour générer les imports

	/**
	 * @author ilias
	 *
	 */
	public class DAO_Connect {
	  public static void main(String[] args) {      
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Driver O.K.");

	      String url = "jdbc:mysql://https://dt5.ehb.be/phpmyadmin";
	      String user = "SP2GR1";
	      String passwd = "6xBfsv";

	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective !");         
	         
	    } catch (Exception e) {
	      e.printStackTrace();
	    }      
	  }
	}




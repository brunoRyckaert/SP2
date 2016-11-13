package model;


import java.sql.DriverManager;

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

			    //  String url = "jdbc:mysql://dt5.ehb.be:443/phpmyadmin";
			   

			  DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
			     
			      System.out.println("Connexion effective !");         
			         System.out.println("conn");
			    } catch (Exception e) {
			      e.printStackTrace();
			    }      
			  }
	}
	
		/*	  try
				{
					if( con == null || con.isClosed())
					{
						con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
					}
					if( con == null || con.isClosed())
					{
						return null;
					}
				PreparedStatement stmt = con.prepareStatement("u statement");
				ResultSet rs = stmt.executeQuery();
				Login log = new Login();
				while (rs.next())
				{
				/* 
				log.setId(rs.getInt("LoginID"));
				log.setUsername(rs.getString("Usernaam"));
				log.setWachtwoord(rs.getString("Wachtwoord"));
				
				}
				con.close();
				return log;
				}
				catch (SQLException exc)
				{
					System.out.println("PROBLEEM: "+exc.getMessage());
					System.out.println("fout code: "+ exc.getErrorCode());
					con.close();
					return null;
				}
	*/




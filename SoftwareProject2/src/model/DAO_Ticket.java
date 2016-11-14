package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Ticket {
	
//	protected Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

	// con =  (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

     
	public static void createTicket(Ticket a) throws SQLException{
	 Connection con = null; 
		PreparedStatement pstmt = null;  
     try {
       //  con = (Connection) DriverManager.getConnection(
         //          "jdbc:default:connection");
    	 con= (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

           ;   try {
				pstmt = (PreparedStatement) con.prepareStatement(
					"INSERT INTO `Ticket` (`TicketID`, `TicketSoortID`, `HeenDatum`, `TerugDatum`, `BeginStation`, `EindStation`, `Prijs`, `Korting`, `AantalReizigers`, `Aankooptijd`, `Klasse`) VALUES (NULL,'"+ a.getTicketsoortID().getTicketSoortID()+"','"+a.getHeenDatum()+"','"+a.getTerugDatum()+"','"+a.getBeginStation()+"','"+a.getEindStation()+"','"+a.getPrijs()+"','"+ a.getKorting() +"','"+a.getAantalReizigers()+"', CURRENT_TIMESTAMP, '1');"
		);	
         } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

     
         pstmt.executeUpdate();
     }
     finally {
         if (pstmt != null) pstmt.close();
     }
 
		
		
	}

	public static void selectTicket(Ticket a) throws SQLException{
	//Ticket retTick= new Ticket();
		
		Connection con = null; 
			PreparedStatement pstmt = null;  
	     try {
	       //  con = (Connection) DriverManager.getConnection(
	         //          "jdbc:default:connection");
	    	 con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

	         try {
					pstmt = (PreparedStatement) con.prepareStatement(
							"SELECT * FROM `Ticket` WHERE TicketID = '"+a.getTicketID()+"';"
			);	
					
	         } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	                   

	     
	        pstmt.execute();
	     }
	     finally {
	         if (pstmt != null) pstmt.close();
	     }
	 
			System.out.println("geselecteerd");
			
		}



	
	 public static Ticket find(int id) throws SQLException {
		    Ticket eleve = new Ticket();      

			Connection con = null; 
				PreparedStatement pstmt = null;  
		    try {
		   	 con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

		     /* ResultSet result = ((java.sql.Connection) con).createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Ticket WHERE TicketID = " + id);
		  ResultSet resultat= statement.executeQuery("SELECT * FROM Ticket WHERE TicketID = " + id)
				  ResultSet resultat = statement.executeQuery(sql); 
				  /*   if(result.first())
		        eleve = new Ticket(
		          id,result.getD
		          null, null, null, result.getString("BeginStation"),
		          result.getString("EindStation"
		        ), id, id, id, null);         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }*/
		   	Statement statement = con.createStatement( 
		   			ResultSet.TYPE_FORWARD_ONLY, 
		   			ResultSet.CONCUR_READ_ONLY); 
		   			String sql = "SELECT * FROM `Ticket` WHERE TicketID =1"; 
		   			ResultSet resultat = statement.executeQuery(sql); 
		   			while(resultat.next()){ 
		   			eleve.setTicketID(resultat.getInt(1)); 
		   			eleve.setTicketsoortID(null);//  = resultat.getString(2); 
		   			eleve.setHeenDatum(resultat.getDate(3)); 
		   			eleve.setTerugDatum(resultat.getDate(4)); 
		   			eleve.setBeginStation(resultat.getString(5));
		   			eleve.setEindStation(resultat.getString(6));
		   			eleve.setPrijs(resultat.getDouble(7));
		   			eleve.setKorting(resultat.getInt(8));
		   			eleve.setAantalReizigers(resultat.getInt(9));
		   			}
		   			
		    }
		   			//eleve.setAankoopTijd(sql);
		   		
		   		/*	System.out.println("Données contenues dans la ligne "+row); 
		   			System.out.println("id : "+id+" nom : "+nom+ 
		   			" prix : "+prix+" date : "+date); */
		   			
		   		 finally {
		   	      if (pstmt != null) pstmt.close();
		   	  }
		    return eleve;
		  
	 }

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
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
			  
		  int a,b,c;
		  a=2016;
		  b=4;
		  c=7;
		Date heen=new Date(a,b,c);
		   Date terug=new Date(a,b,c+2);
		//Ticket a=new Ticket();
	//	createTicket(a);
		//System.out.println("tis gemaakt");
		   TicketSoort a1=new TicketSoort();
		   a1.setTicketSoortID(1);
		Ticket b1=new Ticket(7,a1,heen,terug,"Brussel-Zuid","Brussel-Noord",15,4,1,"0");
		createTicket(b1);
		System.out.println("tis gemaakt");
		//Ticket c1=new Ticket();
	
		//selectTicket(b1.getTicketID());
		Ticket q = new Ticket(find(b1.getTicketID()));

	
		System.out.println(q.toString());
		}
}
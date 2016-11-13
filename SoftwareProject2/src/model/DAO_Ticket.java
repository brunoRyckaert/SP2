package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.runner.Request;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Ticket {
	
	public static void createTicket(Ticket a) throws SQLException{
	 Connection con = null; 
		PreparedStatement pstmt = null;  
     try {
       //  con = (Connection) DriverManager.getConnection(
         //          "jdbc:default:connection");
    	 con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

         try {
				pstmt = (PreparedStatement) con.prepareStatement(
					"INSERT INTO `Ticket` (`TicketID`, `TicketSoortID`, `HeenDatum`, `TerugDatum`, `BeginStation`, `EindStation`, `Prijs`, `Korting`, `AantalReizigers`, `Aankooptijd`, `Klasse`) VALUES (NULL,"+ a.getTicketsoortID().getTicketSoortID()+","+a.getHeenDatum()+","+a.getTerugDatum()+","+a.getBeginStation()+","+a.getEindStation()+","+a.getPrijs()+","+ a.getKorting() +","+a.getAantalReizigers()+", CURRENT_TIMESTAMP, '1');"
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

	public static Ticket selectTicket(Ticket a) throws SQLException{
	Ticket retTick= new Ticket();
		
		Connection con = null; 
			PreparedStatement pstmt = null;  
	     try {
	       //  con = (Connection) DriverManager.getConnection(
	         //          "jdbc:default:connection");
	    	 con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

	         try {
					pstmt = (PreparedStatement) con.prepareStatement(
							"SELECT * FROM `Ticket` WHERE TicketID = "+a.getTicketID()+";"
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

	
		}
}
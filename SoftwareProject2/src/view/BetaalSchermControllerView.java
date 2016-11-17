package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BetaalSchermControllerView extends JFrame {
	JPanel mainPanel= new JPanel();
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JPanel panel4= new JPanel();
	public BetaalSchermControllerView(){
	super();
	BorderLayout layout = new BorderLayout();
	JButton backButton = new JButton("TERUG");
	JButton betalenButton= new JButton("BETALEN"); 
	JTextField prijsVul = new JTextField();
	JTextField kortingVul = new JTextField();
	JLabel prijsLabel = new JLabel("Prijs: "); 
	JLabel kortingLabel = new JLabel("Korting: "); 
	JLabel totaalLabel = new JLabel("Totaal: ");
	JLabel totaalGevuld = new JLabel();
	panel1.setLayout(layout);
	panel1.add(prijsLabel, BorderLayout.WEST);
	panel1.add(prijsVul,BorderLayout.EAST);
	panel2.setLayout(layout);
	
	panel2.add(kortingLabel, BorderLayout.WEST);
	panel2.add(kortingVul,BorderLayout.EAST);
	panel3.setLayout(layout);
	panel3.add(totaalLabel, BorderLayout.WEST);
	panel3.add(totaalGevuld,BorderLayout.EAST);
	panel4.setLayout(layout);
	panel4.add(backButton,BorderLayout.WEST);
	panel4.add(betalenButton,BorderLayout.EAST);
	
	mainPanel.add(panel1,BorderLayout.PAGE_START);
	mainPanel.add(panel2,BorderLayout.AFTER_LAST_LINE);
	mainPanel.add(panel3,BorderLayout.AFTER_LAST_LINE);
	mainPanel.add(panel4, BorderLayout.PAGE_END);
	this.setSize(600,400);
	this.getContentPane().add(mainPanel, BorderLayout.CENTER);
	
	
	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args){
		BetaalSchermControllerView myScherm = new BetaalSchermControllerView();
		
		myScherm.setVisible(true);
	}
}
	


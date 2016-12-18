package view;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.OmzetListener;

public class StatistiekView {
	
	JFrame frame =new JFrame("Statistiek");
	JPanel panel = new JPanel();
	JLabel lab = new JLabel ("Statistieken");
	JButton omzet = new JButton("Omzet");
	JButton productiviteit = new JButton("productiviteit");
	JTable tabel;
	OmzetListener c = new OmzetListener();
	/*public JTable tabellen()
	{
		  Object[][] data = {
			      {"Cysboy", "28 ans", "1.80 m"},
			      {"BZHHydde", "28 ans", "1.80 m"},
			      {"IamBow", "24 ans", "1.90 m"},
			      {"FunMan", "32 ans", "1.85 m"}
			    };
		  String  title[] = {"Pseudo", "Age", "Taille"};
		this.tabel = new JTable(data,title);
		//this.frame.getContentPane().add(new JScrollPane(tabel));
		return tabel;
	}
	*/
	public JButton omzetlist()
	{
	this.omzet.addActionListener(new OmzetListener());
		
		return this.omzet;
	}
	public StatistiekView ()
	{
		
		frame.add(panel);
		panel.add(lab);
		panel.add(omzetlist());
		panel.add(productiviteit);
		//panel.add(this.tabellen());
	//	this.frame.getContentPane().add(new JScrollPane(tabel));
		this.frame.getContentPane().add(lab, BorderLayout.NORTH);
		// this.frame.getContentPane().add(omzetlist(), BorderLayout.EAST);
		 //this.frame.getContentPane().add(productiviteit, BorderLayout.WEST);
		
		frame.setVisible(true);
		frame.setSize(400, 400);
	}
	
	
	public static void main(String[] args) {
		new StatistiekView();
	}

}

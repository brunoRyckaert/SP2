package view;

import javax.swing.*;

public class StatistiekView {
	
	JFrame frame =new JFrame("Statistiek");
	JPanel panel = new JPanel();
	JLabel lab = new JLabel ("Statistieken");
	JButton omzet = new JButton("Omzet");
	JButton productiviteit = new JButton("productiviteit");
	JTable tabel;
	
	public JTable tabellen()
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
	
	public StatistiekView ()
	{
		
		frame.add(panel);
		panel.add(lab);
		panel.add(omzet);
		panel.add(productiviteit);
		panel.add(this.tabellen());
	//	this.frame.getContentPane().add(new JScrollPane(tabel));
		
		frame.setVisible(true);
		frame.setSize(400, 400);
	}
	
	
	public static void main(String[] args) {
		new StatistiekView();
	}

}

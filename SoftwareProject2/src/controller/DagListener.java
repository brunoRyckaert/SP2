package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.TransactieDAO;

public class DagListener implements ActionListener {

	JOptionPane p = new JOptionPane();
	StatistiekDAO statistiekDAO = new StatistiekDAO();
	Integer a = statistiekDAO.totaalOmzetBinnenEenBepaaldePeriode("2016-12-14 00:00:00","2016-12-15 23:59:59");
	String b = "de omzet van de dag is "+a.toString() + ".";
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		JOptionPane.showMessageDialog(null, b , b, JOptionPane.INFORMATION_MESSAGE);
	}

}

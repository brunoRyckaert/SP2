package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controller.DagListener;

public class OmzetView {

	JFrame frame = new JFrame("Omzet");
	JPanel panel =new JPanel();
	JLabel dag =new JLabel("Van de dag");
	JButton dag2 = new JButton ("van de dag");
	JLabel maand =new JLabel("Van maand");
	JButton maand2 = new JButton("Van maand");
	JLabel bepaaldeperiode =new JLabel ("Binnen een bepaalde periode");
	JButton bepPeriode = new JButton("Binnen een bepaalde periode");
	JLabel jaar =new JLabel ("jaar");
	JButton bjaar =new JButton ("jaar");
	JSpinner c=new JSpinner();
	//JSpinner.DateEditor a=new JSpinner.DateEditor(b);
	//DateEditor c = new DateEditor(b);
	
	public JButton dagg()
	{
		dag2.addActionListener(new DagListener());
		return this.dag2;
	}
	
	public JSpinner datemode()
	{
		SpinnerDateModel b =new SpinnerDateModel();
		this.c.setModel(b);
		return this.c;
	}
	
	public OmzetView()
	{
		
		frame.add(panel);
		panel.add(dag);
		panel.add(this.dagg());
		panel.add(maand);
		panel.add(maand2);
		panel.add(bepaaldeperiode);
		panel.add(bepPeriode);
		panel.add(jaar);
		panel.add(bjaar);		
		panel.add(this.datemode());
		this.frame.setLocationRelativeTo(null);
		// this.frame.setLayout(new BorderLayout());
		 this.frame.setLayout(new GridLayout(5, 4));
		 this.frame.getContentPane().add(dag);
		 this.frame.getContentPane().add(dagg());
		 this.frame.getContentPane().add(maand);
		 this.frame.getContentPane().add(maand2);
		 this.frame.getContentPane().add(bepaaldeperiode);
		 this.frame.getContentPane().add(jaar);
		 this.frame.getContentPane().add(bjaar);
		 this.frame.getContentPane().add(datemode());
		
		/* this.frame.getContentPane().add(dag, BorderLayout.WEST);
		 this.frame.getContentPane().add(dagg(), BorderLayout.EAST);
		 this.frame.getContentPane().add(maand, BorderLayout.EAST);
		 this.frame.getContentPane().add(maand2, BorderLayout.EAST);
		 this.frame.getContentPane().add(bepaaldeperiode, BorderLayout.EAST);
		 this.frame.getContentPane().add(bepPeriode, BorderLayout.EAST);
		 this.frame.getContentPane().add(jaar, BorderLayout.EAST);
		 this.frame.getContentPane().add(bjaar, BorderLayout.EAST);
		 this.frame.getContentPane().add(datemode(), BorderLayout.EAST);*/
		frame.setVisible(true);
		frame.setSize(400, 400);
		    
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new OmzetView();
	}
}

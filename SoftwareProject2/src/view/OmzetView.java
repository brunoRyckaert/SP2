package view;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;

public class OmzetView {

	JFrame frame = new JFrame("Omzet");
	JPanel panel =new JPanel();
	JLabel dag =new JLabel("Van de dag");
	JLabel maand =new JLabel("Van maand");
	JLabel bepaaldeperiode =new JLabel ("Binnen een bepaalde periode");
	JLabel jaar =new JLabel ("jaar");
	JSpinner c=new JSpinner();
	//JSpinner.DateEditor a=new JSpinner.DateEditor(b);
	//DateEditor c = new DateEditor(b);
	
	
	
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
		panel.add(maand);
		panel.add(bepaaldeperiode);
		panel.add(jaar);
		panel.add(this.datemode());
		
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

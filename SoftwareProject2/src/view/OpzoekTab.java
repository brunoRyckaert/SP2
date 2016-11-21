package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.LocalizedLabel;
import model.Strings;

public class OpzoekTab extends JPanel {
	public OpzoekTab() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel titel = new LocalizedLabel(Strings.tabOpzoek);
		this.add(titel);
		
		JPanel vanPanel = new JPanel();
		vanPanel.setLayout(new FlowLayout());
		
		LocalizedLabel vanLabel = new LocalizedLabel(Strings.vanStation);
		vanPanel.add(vanLabel);
		
		JTextField vanStation = new JTextField();
		vanStation.setPreferredSize(new Dimension(100,20));
		vanPanel.add(vanStation);
		
		JPanel naarPanel = new JPanel();
		naarPanel.setLayout(new FlowLayout());
		
		LocalizedLabel naarLabel = new LocalizedLabel(Strings.naarStation);
		naarPanel.add(naarLabel);
		
		JTextField naarStation = new JTextField();
		naarStation.setPreferredSize(new Dimension(100,20));
		naarPanel.add(naarStation);
		

		
		this.add(vanPanel);
		this.add(naarPanel);
	}
}

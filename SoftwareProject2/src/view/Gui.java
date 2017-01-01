package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import controller.KortingDAO;
import model.Korting;
import model.LocalizedFrame;
import model.LocalizedLabel;
import model.LocalizedMenu;
import model.LocalizedMenuItem;
import model.LocalizedTabbedPane;
import model.Settings;
import model.Strings;
import model.Taal;
import model.Taal.TaalEnum;

public class Gui extends Ui {
	

	public static void main(String[] args) {
		Gui gui = new Gui();
	}
	
	private static LocalizedFrame frame;
	
	public Gui() {
		initFrame();
		new LoginView(frame);
	}
	
	
	
	private static void initFrame() {
		frame= new LocalizedFrame(Strings.guiTitle);
		frame.setPreferredSize(new Dimension(800,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LocalizedMenu menu = new LocalizedMenu(Strings.menuFile);
		JMenuBar mb = new JMenuBar();
		mb.add(menu);
		LocalizedMenuItem mitem = new LocalizedMenuItem(Strings.menuLogin);
		mitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new LoginView(frame);	
			}
			
		});
		JMenu submenutaal = new LocalizedMenu(Strings.menuTaal);
		JMenuItem submenutaalNL = new JMenuItem("NL");
		submenutaalNL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().getTaal().setTaal(TaalEnum.NL);
				
			}
			
		});
		JMenuItem submenutaalFR = new JMenuItem("FR");
		submenutaalFR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().getTaal().setTaal(TaalEnum.FR);
				
			}
			
		});
		JMenuItem submenutaalEN = new JMenuItem("EN");
		submenutaalEN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().getTaal().setTaal(TaalEnum.EN);
				
			}
			
		});
		
		submenutaal.add(submenutaalNL);
		submenutaal.add(submenutaalFR);
		submenutaal.add(submenutaalEN);
		menu.add(mitem);
		menu.add(submenutaal);
		frame.setJMenuBar(mb);
		
		//JTabbedPane jtp = new JTabbedPane();
		LocalizedTabbedPane jtp = new LocalizedTabbedPane();
		frame.add(jtp);
		/*JPanel jp = new JPanel();
		LocalizedLabel opzoek = new LocalizedLabel(Strings.tabOpzoek);
		jp.add(opzoek);*/
		JPanel jp = new OpzoekTab();
		//JPanel jp2 = new JPanel();
		JPanel jp2 = new VerkoopTab();
		JPanel jp3 = new JPanel();
		//jp2.add(new JLabel("Tweede tab"));
		jp3.add(new JLabel("Derde tab"));
		jtp.addTab(Strings.tabOpzoek[Settings.getInstance().getTaal().getValue()], jp);
		jtp.addTab(Strings.tabVerkoop[Settings.getInstance().getTaal().getValue()], jp2);
		jtp.addTab(Strings.tabVoorwerpen[Settings.getInstance().getTaal().getValue()], jp3);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static JFrame getFrame() {
		if (frame == null)
		{
			initFrame();
		}
		return frame;
	}
	public static void setVisible() {
		frame.setVisible(true);
	}
	public static void setInvisible() {
		frame.setVisible(false);
	}
}

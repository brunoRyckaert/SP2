package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class LocalizedMenuItem extends JMenuItem implements Observer {
	private String[] string;
	public LocalizedMenuItem(String[] s) {
		string = s;
		update(null,null);
		Settings.getInstance().getTaal().addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(string[Settings.getInstance().getTaal().getValue()]);
		
	}

}

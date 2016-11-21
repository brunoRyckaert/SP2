package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class LocalizedLabel extends JLabel implements Observer {
	private String[] string;
	public LocalizedLabel(String[] s) {
		string = s;
		this.setText(string[Settings.getInstance().getTaal().getValue()]);
		Settings.getInstance().getTaal().addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(string[Settings.getInstance().getTaal().getValue()]);
	}
}

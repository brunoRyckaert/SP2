package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class LocalizedButton extends JButton implements Observer{
	private String[] string;
	public LocalizedButton(String[] s) {
		string = s;
		this.update(null,null);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(string[Settings.getInstance().getTaal().getValue()]);	
	}

}

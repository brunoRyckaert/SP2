package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;;

public class LocalizedFrame extends JFrame implements Observer{
	private String[] string;
	public LocalizedFrame(String[] s) {
		string = s;
		update(null,null);
		Settings.getInstance().getTaal().addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setTitle(string[Settings.getInstance().getTaal().getValue()]);
	}

}

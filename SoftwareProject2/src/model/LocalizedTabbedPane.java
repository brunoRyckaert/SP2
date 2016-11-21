package model;

import java.util.Observable;
import java.util.Observer;
import model.Settings;

import javax.swing.*;

public class LocalizedTabbedPane extends JTabbedPane implements Observer {
	public LocalizedTabbedPane() {
		Settings.getInstance().getTaal().addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		this.setTitleAt(0, Strings.tabOpzoek[Settings.getInstance().getTaal().getValue()]);
		this.setTitleAt(1, Strings.tabVerkoop[Settings.getInstance().getTaal().getValue()]);
		this.setTitleAt(2, Strings.tabVoorwerpen[Settings.getInstance().getTaal().getValue()]);
	}
	

}

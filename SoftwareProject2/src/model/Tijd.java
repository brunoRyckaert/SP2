package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import controller.ApplicatieController;
import controller.Main;
import javafx.scene.control.Label;

public class Tijd implements Runnable {

	public Tijd(Label lbl,Label lblDag)
	{
		elkeSecond(lbl,lblDag);
	}
	@Override
	public void run() {
	
//	this.tijd(Main.getRoot());
	}
private void tijd(ApplicatieController contrl)
{
//	contrl.setTijd(Settings.getTijd().toString());
}
private void elkeSecond(Label lbluur,Label lblDag)
{
	Thread th = new Thread();
	
lbluur.setText(Settings.getTijd().toString());
lblDag.setText(Settings.getDag());
}
}

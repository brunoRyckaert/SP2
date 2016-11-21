package model;
import java.util.*;

public class Taal extends Observable {
	private TaalEnum taal;
	public Taal() {
		this(TaalEnum.NL);
	}
	public Taal(TaalEnum te) {
		taal = te;
	}
	public TaalEnum getTaal() {
		return taal;
	}

	public void setTaal(TaalEnum taal) {
		this.taal = taal;
		Settings.getInstance().getTaal().setChanged();
		Settings.getInstance().getTaal().notifyObservers();
	}
	public int getValue() {
		return taal.getValue();
	}
	 public enum TaalEnum { 
			NL(0), FR(1), EN(2);
			private int value; 
			private TaalEnum(int value) {
				this.value = value;
			}
			public int getValue() {
				return value;
			}
		 }

}


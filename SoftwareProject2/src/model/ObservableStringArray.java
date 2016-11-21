package model;
import java.util.*;

public class ObservableStringArray extends Observable {
	private String[] string;
	public String[] getStrings() {
		return string;
	}
	public ObservableStringArray(String[] s) {
		string = s;
	}
}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Omzet2DataController implements Initializable {

	@FXML
	private DatePicker DPbegin;
	@FXML
	private DatePicker DPeind;
	@FXML
	private Label lblbegin;
	@FXML
	private Label lbleind;
	@FXML
	private TextArea tekst;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void zoekbutton(ActionEvent event)
	{
		StatistiekDAO s = new StatistiekDAO();
		
		String st = "Omzet: begindatum :" +this.DPbegin.toString() +" einddatum: "+this.DPeind.toString() + "Omzet: "+ s.totaalOmzetBinnenEenBepaaldePeriode(this.DPbegin.toString(),this.DPeind.toString());
		
		tekst.setText(st);
	}

}

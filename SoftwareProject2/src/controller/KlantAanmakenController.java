package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Adres;
import model.Klant;

public class KlantAanmakenController implements Initializable {

	@FXML
	private Label lblvn;
	@FXML
	private Label lblan;
	@FXML
	private Label lbl;
	@FXML
	private Label lblGeboortedatum;
	@FXML
	private Label lblTelefoonnumer;
	@FXML
	private Label lblstad;
	@FXML
	private Label lblStraat;
	@FXML
	private Label lblnr;
	@FXML
	private Label lblbus;
	
	@FXML
	private TextField TFvn;
	@FXML
	private TextField TFan;
	@FXML
	private TextField TFtel;
	@FXML
	private TextField TFst;
	@FXML
	private TextField TFstr;
	@FXML
	private TextField TFnr;
	@FXML
	private TextField TFbus ;  
	
	@FXML
	private DatePicker  DPdatum;
	@FXML
	private TextArea area;
	
	@FXML
	private Button btnklantmaken;
	@FXML 
	private TextField provincie;
	@FXML
	private Label province;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void clearAlleVelden()
	{
		this.TFan.clear();
		this.TFbus.clear();
		this.TFnr.clear();
		this.TFst.clear();
		this.TFtel.clear();
		this.TFvn.clear();
		this.TFstr.clear();
	}
	
	public void klantmaken(ActionEvent event)
	{
		KlantDAO k = new KlantDAO();
		Klant p=new Klant();
		//public Adres(int adresID, String stad, String straat, int nr, String gemeente, int bus) 
		Adres a = new Adres(0,this.TFst.getText(),this.TFstr.getText(),Integer.parseInt(this.TFnr.getText()),this.provincie.getText(),Integer.parseInt(this.TFbus.getText()));
		AdresDAO b = new AdresDAO();
		b.insertAdres(a);
		p.setGeboortedatum(String.valueOf(DPdatum.getValue()));
		p.setNaam(this.TFvn.getText() + this.TFan.getText());
		if(this.TFtel.getText().length() == 9)
		{
		p.setTelefoonnummer(this.TFtel.getText());
		}
		else
		{
			this.TFtel.setPromptText("geen geldige telefoonnummer");
		}
		p.setAdresID(b.selectAdres(a).getAdresID());
		//	public Klant(int klantID, int adresID, String naam, String telefoonnummer, String geboortedatum) {

		k.insertKlant(p);
		area.setText("Klant werd aangemaakt");
	}
}

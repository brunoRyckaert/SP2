package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Abonnement;
import model.Definitions;

public class AbonnementController implements Initializable {

	 ArrayList<String>stations = Definitions.getStations();
	@FXML
	private Label lblklantid; 
	@FXML
	private Label lblBeginstation;
	@FXML
	private Label lblEindStation;
	@FXML
	private Label lblbeginDatum;
	@FXML
	private Label lbleindDatum;
	@FXML
	private Label lblkorting;
	@FXML
	private Label lblPrijs;
	@FXML
	private Label lblKlasse;
	@FXML
	private TextArea area;
	@FXML
	private TextField TFKlantid;
	@FXML
	private TextField TFBeginStation;
	@FXML
	private TextField TFEindStation;
	@FXML
	private TextField TFKorting;
	@FXML
	private TextField TFPrijs;
	
	@FXML
	private DatePicker DTBeginDatum;
	@FXML
	private DatePicker DTEindDatum;
	@FXML
	private Button btnBetalen;
	@FXML
	private ComboBox<String> cbklasse ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> klasse = FXCollections.observableArrayList("1ste klasse","2 de klasse");
				cbklasse.setItems(klasse);
				TextFields.bindAutoCompletion(this.TFBeginStation,  stations);
				TextFields.bindAutoCompletion(this.TFEindStation,  stations);
	}
	
	public void betalen(ActionEvent event)
	{
		/*private int abonnementNummer;
	private int klantNummer;
	private String beginStation;
	
	private String eindStation;
	private Timestamp aankoopTijd;
	private Date beginDatum;
	private Date eindDatum;
	private boolean isGeldig;
	private double prijs;
	private int kortingNummer;*/
		Abonnement b = new Abonnement();
		b.setKlantNummer(Integer.parseInt(this.TFKlantid.getText()));
		b.setBeginStation(this.TFBeginStation.getText());
		b.setEindStation(this.TFEindStation.getText());
		b.setBeginDatum(Date.valueOf(this.DTBeginDatum.toString()));
		b.setEindDatum(Date.valueOf(this.DTEindDatum.toString()));
		b.setPrijs(Double.parseDouble(this.TFPrijs.getText()));
		AbonnementDAO a = new AbonnementDAO();
		a.insertAbonnement(b);
		area.setText("Abonnement is aangemaakt");
		clearalleVelden();
	}
	
	public void clearalleVelden()
	{
		this.TFBeginStation.clear();
		this.TFEindStation.clear();
		this.TFKlantid.clear();
		this.TFKorting.clear();
		this.TFPrijs.clear();
		this.DTBeginDatum.setValue(null);
		this.DTEindDatum.setValue(null);
	}

}

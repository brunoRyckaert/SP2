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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Abonnement;
import model.Definitions;
import model.Klant;
import model.Settings;
import model.Station;
import model.Strings;

public class AbonnementController implements Initializable {

	 ArrayList<Station> stations = Definitions.getStations();
	 ArrayList<String> klantennr = new ArrayList<String>();
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
	@FXML
	private Label lblError=new Label();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		this.lblbeginDatum.setText(Strings.lblbeginDatum[Settings.getInstance().getTaal().getValue()]);
		this.lblBeginstation.setText(Strings.vanStation[Settings.getInstance().getTaal().getValue()]);
		this.lbleindDatum.setText(Strings.lblEindDatum[Settings.getInstance().getTaal().getValue()]);
		this.lblEindStation.setText(Strings.naarStation[Settings.getInstance().getTaal().getValue()]);
		this.lblklantid.setText(Strings.klantId[Settings.getInstance().getTaal().getValue()]);
		this.lblKlasse.setText(Strings.lblklasse[Settings.getInstance().getTaal().getValue()]);
		this.lblkorting.setText(Strings.korting[Settings.getInstance().getTaal().getValue()]);
		this.lblPrijs.setText(Strings.lblprijs[Settings.getInstance().getTaal().getValue()]);
		
		
		
		
		ObservableList<String> klasse = FXCollections.observableArrayList(Strings.eersteKlasse[Settings.getInstance().getTaal().getValue()],Strings.tweedeKlasse[Settings.getInstance().getTaal().getValue()]);
	
				cbklasse.setItems(klasse);
				ArrayList<String> stationsnamen = new ArrayList<String>();
				for (int i = 0; i < stations.size(); i++) {
				
					stationsnamen.add(stations.get(i).getNaam().get(0));
				}
				KlantDAO k = new KlantDAO();
				ArrayList<Klant> a = k.alleKlanten();
				for (int i = 0; i < a.size(); i++) {
					klantennr.add(String.valueOf(a.get(i).getNaam()));
				}
				
				TextFields.bindAutoCompletion(this.TFBeginStation,  stationsnamen);
				TextFields.bindAutoCompletion(this.TFEindStation,  stationsnamen);
				TextFields.bindAutoCompletion(this.TFKlantid, this.klantennr);
				lblError.setText("");
	}
	
	public void betalen(ActionEvent event)
	{
		
		ArrayList<String> stationsnamen = new ArrayList<String>();
		for (int i = 0; i < stations.size(); i++) {
		
			stationsnamen.add(stations.get(i).getNaam().toString());
		}
		KlantDAO k = new KlantDAO();
		ArrayList<Klant> a = k.alleKlanten();
		for (int i = 0; i < a.size(); i++) {
			klantennr.add(String.valueOf(a.get(i).getNaam()));
		}
		System.out.println(TFKlantid.getText());
		Klant klant = a.get(klantennr.indexOf(TFKlantid.getText()));
//		System.out.println(TFBeginStation.getText());
//		System.out.println(this.TFEindStation.getText());
//		System.out.println(this.TFKlantid.getText());
//		System.out.println(this.DTEindDatum.getValue());
		
//		System.out.println(stationsnamen.contains(TFBeginStation.getText()));
//		System.out.println( stationsnamen.contains(this.TFEindStation.getText()));
//		System.out.println(this.TFBeginStation.getText().equals(TFEindStation.getText()));
		System.out.println(Definitions.getStationsNamen().contains(TFBeginStation.getText()));
		System.out.println(Definitions.getStationsNamen().contains(TFEindStation.getText()));
		//Definitions.getStationsNamen().contains(TFBeginStation.getText()) && Definitions.getStationsNamen().contains(TFEindStation.getText())
		if( 
//				&& stationsnamen.contains(this.TFEindStation.getText())
//				&& (this.TFBeginStation.getText().equals(TFEindStation.getText()) == false)
//				&& klantennr.contains(this.TFKlantid.getText()) 
				 Definitions.getStationsNamen().contains(TFBeginStation.getText())
				&& Definitions.getStationsNamen().contains(TFEindStation.getText())
				
				&& this.DTBeginDatum.getValue().isBefore(this.DTEindDatum.getValue()))
		{
			Abonnement b = new Abonnement();
			//	b.setKlantNummer(Integer.parseInt(this.TFKlantid.getText()));
				b.setBeginStation(this.TFBeginStation.getText());
				b.setEindStation(this.TFEindStation.getText());
				b.setBeginDatum(Date.valueOf(this.DTBeginDatum.getValue()));
				b.setEindDatum(Date.valueOf(this.DTEindDatum.getValue()));
				//b.setPrijs(Double.parseDouble(this.TFPrijs.getText()));
				b.setKlantId(klant.getKlantID());
				b.setKortingId(Integer.parseInt(this.TFKorting.getText()));
				
				System.out.println("je passe dans le if");
				
				
				
				AbonnementDAO abdao = new AbonnementDAO();
				abdao.add(b);
				area.setText(Strings.Abmake[Settings.getInstance().getTaal().getValue()]);
				clearalleVelden();
			/*Abonnement b = new Abonnement();
			//	b.setKlantNummer(Integer.parseInt(this.TFKlantid.getText()));
				b.setBeginStation(this.TFBeginStation.getText());
				b.setEindStation(this.TFEindStation.getText());
				b.setBeginDatum(Date.valueOf(this.DTBeginDatum.toString()));
				b.setEindDatum(Date.valueOf(this.DTEindDatum.toString()));
				b.setPrijs(Double.parseDouble(this.TFPrijs.getText()));
				b.setKlantId(Integer.parseInt(this.TFKlantid.getText()));
				b.setKortingId(Integer.parseInt(this.TFKorting.getText()));
				System.out.println("je passe dans le if");
				b.setGeldig(true);
				
				
				AbonnementDAO abdao = new AbonnementDAO();
				abdao.add(b);
				area.setText(Strings.Abmake[Settings.getInstance().getTaal().getValue()]);
				clearalleVelden();*/
		
		
		}
		
		else
		{
		/*	this.lblError.setText(Strings.lblError[Settings.getInstance().getTaal().getValue()]);
			area.setText("fout invoer bij de velden");
		*/	
			this.lblError.setText(Strings.lblError[Settings.getInstance().getTaal().getValue()]);
			area.setText(Strings.lblError[Settings.getInstance().getTaal().getValue()]);
		}
		
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

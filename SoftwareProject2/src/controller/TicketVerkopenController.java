package controller;


import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Definitions;
import model.Ticket;

public class TicketVerkopenController implements Initializable,  ActionListener {

	ArrayList<String>stations = Definitions.getStations();
	@FXML
	private Label lblvan = new Label();
	@FXML
	private Label lblnaar = new Label();
	@FXML
	private Label lblheen = new Label();
	@FXML
	private Label lblvterug = new Label();
	@FXML
	private Label lblkorting = new Label();
	@FXML
	private Label lblklasse = new Label();
	@FXML
	private Label lblprijs = new Label();
	@FXML
	private TextField TFvan = new TextField();
	@FXML
	private TextField TFnaar = new TextField();
	@FXML
	private TextField TFKorting = new TextField();
	@FXML
	private TextField TFprijs = new TextField();
	@FXML
	private DatePicker DPHeen = new DatePicker();
	@FXML
	private DatePicker DPTerug = new DatePicker();
	@FXML
	private Button btnbetalen = new Button();
	@FXML
	private ChoiceBox<String> klasse = new ChoiceBox<String>(FXCollections.observableArrayList(
		    "Eerste", "Tweede"));
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		
		 TextFields.bindAutoCompletion(this.TFnaar,stations);
		 TextFields.bindAutoCompletion(this.TFvan,stations);
	}
	
	public void betalenbtn(ActionEvent event)
	{
		
		Ticket a = new Ticket();
		a.setBeginStation(this.TFvan.getText());
		a.setEindStation(this.TFnaar.getText());
		a.setHeenDatum(Date.valueOf(this.DPHeen.getEditor().toString()));
		a.setTerugDatum(Date.valueOf(this.DPTerug.getEditor().toString()));
		TicketDAO b = new TicketDAO();
		try {
			b.setTicket(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clearalleVelden();
	}
	public void clearalleVelden()
	{
		this.TFKorting.clear();
		this.TFnaar.clear();
		this.TFprijs.clear();
		this.TFvan.clear();
		this.DPHeen.setValue(null);
		this.DPTerug.setValue(null);
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

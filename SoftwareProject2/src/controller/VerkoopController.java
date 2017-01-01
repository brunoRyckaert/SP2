package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

import org.controlsfx.control.textfield.TextFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Definitions;
import model.Personeel;
import model.Settings;
import model.Strings;

public class VerkoopController implements Initializable{
	Personeel ingelogde = Settings.getIngelogdPersoneelslid();
	TreeSet<String>stations = Definitions.getStationsNamen();

	@FXML
	private TextField txtfVan = new TextField();
	@FXML
	private TextField txtfNaar = new TextField();
	@FXML
	private Button btnVolgende;
	@FXML
	private Label lblVan;
	@FXML
	private Label lblNaar;
	@FXML
	private Label lblError;
	@FXML
	private RadioButton rbHeen;
	@FXML
	private RadioButton rbHeenTerug;
	@FXML
	private DatePicker dpDatum;
	@FXML
	private TextField txtfUur;
	@FXML
	private Label lblUur;
	private ToggleGroup group = new ToggleGroup();
	@FXML
	private void volgendeAction(ActionEvent event)
	{
		
		lblError.setText("");

		if(stations.contains(txtfVan.getText()) && stations.contains(txtfNaar.getText()) && txtfNaar.getText().length()!=0 && txtfVan.getText().length()!=0)
		{if(txtfVan.getText().compareTo(txtfNaar.getText()) == 0)
		{
			lblError.setText("hetzelde station");
		}
		else
		{
			lblError.setText("goed");
			//ticketView
//			Parent root = Main.getRoot();
//			Scene sc= Main.getScene();
//			Stage st = Main.getWindow();
			
		}
		}
		else if(txtfVan.getText().trim().equals("") && txtfVan.getText().trim().equals(""))
		{
			lblError.setText("gelieve alle velden in te vullen");
		}
	else
			{
						lblError.setText("gelieve een bestaand station in te geven");	
			}
		}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblVan.setText(Strings.naarStation[Settings.getInstance().getTaal().getValue()]);
		lblNaar.setText(Strings.vanStation[Settings.getInstance().getTaal().getValue()]);
		btnVolgende.setText(Strings.volgende[Settings.getInstance().getTaal().getValue()]);
		rbHeen.setText(Strings.rbHeen[Settings.getInstance().getTaal().getValue()]);
		rbHeenTerug.setText(Strings.rbHeenTerug[Settings.getInstance().getTaal().getValue()]);
		lblUur.setText(Strings.uur[Settings.getInstance().getTaal().getValue()]);

		TextFields.bindAutoCompletion(txtfVan,  stations);
		TextFields.bindAutoCompletion(txtfNaar,  stations);
		rbHeen.setSelected(true);
		rbHeen.setToggleGroup(group);
		rbHeenTerug.setToggleGroup(group);
		dpDatum.setValue(Settings.getLocalDate());
		txtfUur.setText(Settings.getTijd().toString());
		
		//lblUur taal

		
	}
}

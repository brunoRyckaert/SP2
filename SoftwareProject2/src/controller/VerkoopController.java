package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.TextFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import model.Definitions;
import model.Personeel;
import model.Settings;

public class VerkoopController implements Initializable{
	Personeel ingelogde = Settings.getInstance().getIngelogdPersoneelslid();
	 ArrayList<String>stations = Definitions.getStations();
	@FXML
	private Label lblHelloUser = new Label();//gebruiker
	@FXML
	private SplitMenuButton smbTaal;//talen kiezen
	@FXML
	private TextField txtlbVan = new TextField();
	@FXML
	private TextField txtlbNaar = new TextField();
	@FXML
	private Button btnBetalen;
	@FXML
	private Label lblVan;
	@FXML
	private Label lblNaar;
	@FXML
	private Label lblBetalen;
	@FXML
	private void btnBetaalAction(ActionEvent event)
	{
		lblBetalen.setText("");
		int compareInt = txtlbVan.getText().compareTo(txtlbNaar.getText());
		if( compareInt == 0)
		{
			if(txtlbVan.getLength() == 0 || txtlbNaar.getLength() == 0)
			{
				lblBetalen.setText("gelieve alle velden in te vullen");
			}
			else
			lblBetalen.setText("hetzelde station");
		}
		else
		{
			if(stations.contains(txtlbVan.getText()) && stations.contains(txtlbNaar.getText()))
			{
				lblBetalen.setText("goed");
				//ticketView
			}
			else
			{
				lblBetalen.setText("gelieve een bestaand station in te geven");
			}
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblHelloUser.setText("Logged in: " + ingelogde.getNaam());
		TextFields.bindAutoCompletion(txtlbVan,  stations);
		TextFields.bindAutoCompletion(txtlbNaar,  stations);
	}
}

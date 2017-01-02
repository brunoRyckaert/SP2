package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Settings;
import model.Strings;
import model.Taal;
import model.Taal.TaalEnum;

public class SettingsController implements Initializable {
@FXML
private Label	lblSettings;
@FXML
	private Label lblTaal;
@FXML
	private ComboBox<String> cmbTaal = new ComboBox<String>();
@FXML
private Button btnOk;
@FXML
private Button btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cmbTaal.getItems().addAll(
		"Nederlands",
		"Français",
		"English"
				);

	}
 public void okAction(ActionEvent event)
 {
	 Taal taal = new Taal();

	switch(cmbTaal.getValue())
	{
	case "Nederlands":
		taal.setTaal(TaalEnum.NL);
		Settings.getInstance().setTaal(taal);
		break;
	case "Français":
		taal.setTaal(TaalEnum.FR);
		Settings.getInstance().setTaal(taal);
		break;
	case "English":
		taal.setTaal(TaalEnum.EN);
		Settings.getInstance().setTaal(taal);
		break;
	default:
		taal.setTaal(TaalEnum.NL);
		Settings.getInstance().setTaal(taal);
	}
		Parent startScherm;
		try {
			Settings.getInstance();
			if(Settings.getIngelogdPersoneelslid().getAdmin())
			{
				startScherm = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
				Scene startScene = new Scene(startScherm);
				Stage startStage = new Stage();

				startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				startStage.hide();
				startStage.setScene(startScene);
				startStage.setTitle(Strings.guiTitle[Settings.getInstance().getTaal().getValue()]);
				
				startStage.show();
				Main.setRoot(startScherm);
				Main.setScene(startScene);
				Main.setWindow(startStage);
			}
			else
			{
			startScherm = FXMLLoader.load(getClass().getResource("applicatie.fxml"));
			Scene startScene = new Scene(startScherm);
			Stage startStage = new Stage();

			startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			startStage.hide();
			startStage.setScene(startScene);
			startStage.setTitle(Strings.guiTitle[Settings.getInstance().getTaal().getValue()]);
			
			startStage.show();
			Main.setRoot(startScherm);
			Main.setScene(startScene);
			Main.setWindow(startStage);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 public void cancelAction(ActionEvent event)
 {
	
		Parent startScherm;
		try {
			startScherm = FXMLLoader.load(getClass().getResource("applicatie.fxml"));
			Scene startScene = new Scene(startScherm);
			Stage startStage = new Stage();

			startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			startStage.hide();
			startStage.setScene(startScene);
			startStage.show();
			Main.setRoot(startScherm);
			Main.setScene(startScene);
			Main.setWindow(startStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 }
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Login;
import model.Personeel;
import model.Settings;

public class StartController implements Initializable{
	@FXML
	private TextArea txtaOpz;
	@FXML
	private TextArea txtaVerVo;//verloren voorwerpen
	@FXML
	private TextArea txtaVerk;
	@FXML
	private Button btnOpz;
	@FXML
	private Button btnVerVo;
	@FXML
	private Button btnVerk;
	@FXML
	private Button btnLogOff;
	@FXML
	private Label lblHelloUser = new Label();//gebruiker
	
	@FXML
	private void smbTaalwijzigAction(ActionEvent event)
	{
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Personeel ingelogde = Settings.getInstance().getIngelogdPersoneelslid();
		lblHelloUser.setText("ingelogd: " + ingelogde.getNaam());
		
	}
	@FXML
	private void btnLogOffAction(ActionEvent event) throws IOException
	{
		Parent startScherm = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
		Scene startScene = new Scene(startScherm);
		Stage startStage = new Stage();
		startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		startStage.hide();
		startStage.setScene(startScene);
		startStage.show();
	}
	@FXML
	private void btnOpzoekAction(ActionEvent event)
	{
		//naar OpzoekView gaan
	}
	@FXML
	private void btnVerlorenVoorwerpAction(ActionEvent event)
	{
		//naar verlorenvoorwerpenview gaan
	}
	@FXML
	private void btnVerkoopAction(ActionEvent event) throws IOException
	{
		Parent startScherm = FXMLLoader.load(getClass().getResource("VerkoopView.fxml"));
		Scene startScene = new Scene(startScherm);
		Stage startStage = new Stage();
		startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		startStage.hide();
		startStage.setScene(startScene);
		startStage.show();
	}
}

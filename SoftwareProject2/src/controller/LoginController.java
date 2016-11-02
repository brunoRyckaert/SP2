package controller;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Login;
import model.Personeel;
import model.Settings;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//probeer het te runnen met internet krijg communication link fouten

public class LoginController implements Initializable{
	@FXML
	private Label lblGebruikersnaam;
	@FXML
	private Label lblWachtwoord;
	@FXML
	private Label lblMessage;
	@FXML
	private TextField txtlbGebruikersnaam;
	@FXML
	private PasswordField txtlbwachtwoord;
	//@FXML
	//private SplitMenuButton smbTaal;

	public void btnLoginAction(ActionEvent event) throws SQLException, IOException
	{
		Login log = new Login();
		if(txtlbGebruikersnaam.getLength() == 0 || txtlbwachtwoord.getLength() == 0)
		{
			if(txtlbGebruikersnaam.getLength() == 0)
			lblGebruikersnaam.setText("Vul in");
			else
			{
				lblGebruikersnaam.setText("");
			}
			if(txtlbwachtwoord.getLength() == 0)
			lblWachtwoord.setText("Vul in");
			else
			{
				lblWachtwoord.setText("");
			}
		}
		else
		{
		lblGebruikersnaam.setText("");
		lblWachtwoord.setText("");
		log.setUsername(txtlbGebruikersnaam.getText());
		log.setWachtwoord(log.Sha512(txtlbwachtwoord.getText()));
		LoginDAO loginDAO = new LoginDAO();
		log = loginDAO.checkLogin(log);
		try
		{
		if (log != null)
		{
			Personeel ingelogd = new Personeel();
			PersoneelDAO persDAO = new PersoneelDAO();
			System.out.println(log.getId());
			ingelogd = persDAO.getPersoon(log.getId());
			if(ingelogd.getIsActief() == false)
			{
				lblWachtwoord.setText("account niet actief");
			}
			else
			{
				Settings set = Settings.getInstance();
				set.setIngelogdPersoneelslid(ingelogd);

			if(ingelogd.getAdmin())
			{
				Parent startScherm = FXMLLoader.load(getClass().getResource("StartScherm.fxml"));
				Scene startScene = new Scene(startScherm);
				Stage startStage = new Stage();
				startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				startStage.hide();
				startStage.setScene(startScene);
				startStage.show();
			}
			else
			{
			Parent startScherm = FXMLLoader.load(getClass().getResource("StartScherm.fxml"));
			Scene startScene = new Scene(startScherm);
			Stage startStage = new Stage();
			startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			startStage.hide();
			startStage.setScene(startScene);
			startStage.show();
			}
		}
		}
		else 
		{
			lblWachtwoord.setText("Fout ! ");
		}
		}
		catch(NullPointerException exc)
		{
			lblWachtwoord.setText("Geen Connectie");
		}
		}
	}
	@FXML
	private void smbTaalwijzigAction(ActionEvent event)
	{
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}

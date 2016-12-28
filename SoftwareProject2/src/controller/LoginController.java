package controller;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Login;
import model.Personeel;
import model.Settings;
import model.Strings;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


public class LoginController implements Initializable{
	@FXML
	private Label lblError;
	@FXML
	private Label lblLogin;
	@FXML
	private TextField txtlbGebruikersnaam;
	@FXML
	private PasswordField txtlbWachtwoord;
	

	public void btnLoginAction(ActionEvent event) throws SQLException, IOException
	{
		Login log = new Login();
		if(txtlbGebruikersnaam.getLength() == 0 || txtlbWachtwoord.getLength() == 0)
		{
			if(txtlbGebruikersnaam.getLength() == 0 && txtlbWachtwoord.getLength() == 0)
			lblError.setText(Strings.allesInvullen[Settings.getInstance().getTaal().getValue()]);
			else if (txtlbWachtwoord.getLength() == 0)
			{
					lblError.setText(Strings.loginPasword[Settings.getInstance().getTaal().getValue()]);
			}
			else
				{
					lblError.setText(Strings.legeNaam[Settings.getInstance().getTaal().getValue()]);
				}
			}
		else
		{
		lblError.setText("");
		log.setUsername(txtlbGebruikersnaam.getText());
		log.setWachtwoord(log.Sha512(txtlbWachtwoord.getText()));
		LoginDAO loginDAO = new LoginDAO();
		log = loginDAO.checkLogin(log);
		try
		{
		if (log.getId() != -1)
		{
			Personeel ingelogd = new Personeel();
			PersoneelDAO persDAO = new PersoneelDAO();
			ingelogd = persDAO.getPersoon(log.getId());
			if(ingelogd.getIsActief() == false)
			{
				lblError.setText(Strings.actiefAccount[Settings.getInstance().getTaal().getValue()]);
			}
			else
			{
				Settings set = Settings.getInstance();
				set.setIngelogdPersoneelslid(ingelogd);

			if(ingelogd.getAdmin())
			{
				Parent startScherm = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
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
			Parent startScherm = FXMLLoader.load(getClass().getResource("applicatie.fxml"));
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
		}
		}
		else if(log.getId() == -1)
		{
			lblError.setText(Strings.fout[Settings.getInstance().getTaal().getValue()]);
		}
		}
		catch(NullPointerException exc)
		{
			lblError.setText(Strings.geenConnectie[Settings.getInstance().getTaal().getValue()]);
		}
		}
	}
	@FXML
	public void CancelAction(ActionEvent event)
	{
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtlbGebruikersnaam.setPromptText(Strings.loginUsername[Settings.getInstance().getTaal().getValue()]);
		txtlbWachtwoord.setPromptText(Strings.loginPasword[Settings.getInstance().getTaal().getValue()]);
	}
	
}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Login;
import model.Personeel;
import model.Settings;
import model.Strings;

public class StatistiekenController implements Initializable{
	@FXML
	private Label lblError = new Label();
	@FXML
	private Button btnVolgende = new Button();
	@FXML
	private TextField txtfNaam = new TextField();
	@FXML
	private Label lblNaam = new Label();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnVolgende.setText(Strings.volgende[Settings.getInstance().getTaal().getValue()]);
		txtfNaam.setPromptText(Strings.loginUsername[Settings.getInstance().getTaal().getValue()]);
		lblNaam.setText(Strings.loginUsername[Settings.getInstance().getTaal().getValue()]);
	}
	public void nextAction()
	{
		Login log = new Login();
		if(txtfNaam.getLength() == 0)
		{
			lblError.setText(Strings.allesInvullen[Settings.getInstance().getTaal().getValue()]);
			
		}
		else
		{
		lblError.setText("");
		log.setUsername(txtfNaam.getText());

		LoginDAO loginDAO = new LoginDAO();
		if(loginDAO.checkUsername(log.getUsername()))
		{
			lblError.setText("goed zo jongen");
		}
		else
		{
			lblError.setText(Strings.bestaan[Settings.getInstance().getTaal().getValue()]);
		}
		}
	}

}

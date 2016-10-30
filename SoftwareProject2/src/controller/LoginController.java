package controller;

import javafx.scene.control.*;
import model.Login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


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
	@FXML
	private void btnLoginAction(ActionEvent event) throws SQLException
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
			LoginDAO loginDAO = new LoginDAO();
		}
		else
		{
		lblGebruikersnaam.setText("");
		lblWachtwoord.setText("");
		log.setUsername(txtlbGebruikersnaam.getText());
		log.setWachtwoord(log.Sha512(txtlbwachtwoord.getText()));
		LoginDAO loginDAO = new LoginDAO();
		try
		{
		if (loginDAO.checkLogin(log))
		{

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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}

package controller;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Definitions;
import model.Login;
import model.Personeel;
import model.Settings;
import model.Strings;
import model.Tijd;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.table.TableModel;

import org.controlsfx.control.textfield.TextFields;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


public class ApplicatieController implements Initializable {

	@FXML
	private  Label lblUur;
	@FXML
	private  Label lblDag;
	@FXML
	private Label lblIngelogde;
	@FXML
	private Hyperlink hyplSettings;
	@FXML
	private Hyperlink hyplLogin;
	@FXML
	private Tab tabHome;
	@FXML
	private TableView<?> tabelTreinen;
	@FXML
	private TableColumn<?, ?> tabColUur;
	@FXML
	private TableColumn<?, ?> tabColPerron;
	@FXML
	private TableColumn<?, ?> tabColNaar;
	//tickets tab objecten
	@FXML
	private Button btnVolgende;
	@FXML
	private Label lblError;
	@FXML
	private Label lblVan;
	@FXML
	private Label lblNaar;
	@FXML
	private TextFields txtfVan;
	@FXML
	private TextFields txtfNaar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	new Thread()
	{
		public void run()
		{
			while(true)
			{
			Platform.runLater(new Runnable(){// moet een fx thread zijn !

				@Override
				public void run() {
					lblUur.setText(Settings.getTijd().toString());
					lblDag.setText(Settings.getDag());
					
				}
				
			});
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}.start();
	lblIngelogde.setText(Strings.begroeting[Settings.getInstance().getTaal().getValue()] +Settings.getIngelogdPersoneelslid().getNaam());
	hyplLogin.setText(Strings.logOff[Settings.getInstance().getTaal().getValue()]);
	tabColUur.setText(Strings.uur[Settings.getInstance().getTaal().getValue()]);
	tabColNaar.setText(Strings.naarStation[Settings.getInstance().getTaal().getValue()]);
	}
	@FXML
	public void logAction()
	{

		{
		Stage st = Main.getWindow();
		st.hide();
		Main.setWindow(st);
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("LoginPopup.fxml"));
			Scene scene = new Scene(root);
			st.setScene(scene);
			st.show();
			Main.setRoot(root);
			Main.setScene(scene);
			Main.setWindow(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	}
	@FXML
	public void settingsAction()
	{
		{
		Stage st = Main.getWindow();
		st.hide();
		Main.setWindow(st);
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("settingsView.fxml"));
			Scene scene = new Scene(root);
			st.setScene(scene);
			st.show();
			Main.setRoot(root);
			Main.setScene(scene);
			Main.setWindow(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	}
}

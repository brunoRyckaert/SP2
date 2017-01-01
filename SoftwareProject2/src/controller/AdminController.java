package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Settings;
import model.Strings;

public class AdminController  implements Initializable {

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
					this.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}.start();
	lblIngelogde.setText(Strings.begroeting[Settings.getInstance().getTaal().getValue()] +Settings.getIngelogdPersoneelslid().getNaam());
	hyplLogin.setText(Strings.logOff[Settings.getInstance().getTaal().getValue()]);

		
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


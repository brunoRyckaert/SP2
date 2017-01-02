package controller;
import java.io.IOException;
/**
 * @author ilias
 */
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ObservableValue;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Definitions;
import model.Settings;
import model.Station;
import model.Strings;

public class VerlorenVoorwerpController implements Initializable {

	 VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();	
	 ArrayList<Station> stations = Definitions.getStations();
	
	 ObservableList<VerlorenVoorwerp> vwerpen;
		
	
	@FXML
	private TableView<VerlorenVoorwerp> tabel;
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom1 = new TableColumn<VerlorenVoorwerp,Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom2 = new TableColumn<VerlorenVoorwerp,Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom3 = new TableColumn<VerlorenVoorwerp,String>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom4 = new TableColumn<VerlorenVoorwerp,String>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Date> kolom5 = new TableColumn<VerlorenVoorwerp,Date>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Date> kolom6 = new TableColumn<VerlorenVoorwerp,Date>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom7 = new TableColumn<VerlorenVoorwerp,Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom8 = new TableColumn<VerlorenVoorwerp, String>();
	@FXML
	private Label kassierid;
	@FXML
	private TextField kass ;
	@FXML
	private TextField txtbeschrijving ;
	@FXML
	private Label lblbeschr;
	@FXML
	private Label LStation;
	@FXML
	private TextField textStation;
	@FXML
	private Label lblDate ;
	@FXML
	private DatePicker datum;
	@FXML
	private Label lblTreinid;
	@FXML
	private TextField textTreinid;
	@FXML
	private Button btnzoek;
	@FXML
	private Button btnIns;
	
	@FXML
    private TextArea resultArea;
	@FXML
	private Label lblklantid;
	@FXML
	private TextField TFKlantid;
	@FXML
	private Label lbItemid;
	@FXML
	private TextField TFItemid;
	@FXML
	private Button btnUpdate;
	
	
	public void zoekVoorwerp (ActionEvent actionEvent) throws SQLException
	{
		VerlorenVoorwerpDAo b = new VerlorenVoorwerpDAo();
		VerlorenVoorwerp a = b.selectVVByNaam(txtbeschrijving.getText());
		System.out.println(a.toString());
		populateAndShowVoorwerp(a);
	}
	
	public void populateAndShowVoorwerp(VerlorenVoorwerp v)
	{
		 if (v != null) {
	            populateVerlorenVoorwerp(v);
	            setVVInfoToTextArea(v);
	        } else {
	            resultArea.setText(Strings.itemId[Settings.getInstance().getTaal().getValue()]);
	        }
		
	}
	
	private void setVVInfoToTextArea(VerlorenVoorwerp v2) {
		// TODO Auto-generated method stub
		 resultArea.setText("Beschrijving: " + v2.getBeschrijving() + "\n" +
	                "ID: " + v2.getItemId());
	}

	private void populateVerlorenVoorwerp(VerlorenVoorwerp v2) {
		// TODO Auto-generated method stub
		 //Declare and ObservableList for table view
        ObservableList<VerlorenVoorwerp> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(v2);
        //Set items to the employeeTable
        tabel.setItems(empData);
		
	}

	@FXML
	private void populateVerlorenVoorwerpen(ObservableList<VerlorenVoorwerp> vvdata )
	{
		tabel.setItems(vvdata);
		
	}
	
	@FXML
	private void searchVerlorenVoorwerpen(ActionEvent actionEvent)
	{
		VerlorenVoorwerpDAo b = new VerlorenVoorwerpDAo();
		ObservableList<VerlorenVoorwerp> vvdata = (ObservableList<VerlorenVoorwerp>) b.selectLijstVVByNaam( txtbeschrijving.getText());
	populateVerlorenVoorwerpen(vvdata);
	}
	
	public void zoekbutton(ActionEvent event)
	{
		ObservableList<VerlorenVoorwerp> a = FXCollections.observableArrayList();
		VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();
		
		if(txtbeschrijving.getLength()!= 0){
		 a = v.selectLijstVVByNaam(txtbeschrijving.getText());
		
		}
		
		else if (textStation.getLength()!= 0)
		{
			a = v.selectLijstVVByStation(textStation.getText());
		}
		
		else if (datum.getEditor().getLength() != 0)
		{
			a = v.selectLijstVVByDate(datum.toString());
		}
		vwerpen = (ObservableList<VerlorenVoorwerp>) a;
		
		txtbeschrijving.setText(null);
		
		
		this.clearalleVelden();
		
		tabel.setItems(vwerpen);
		
	}
	
	
	public void clearalleVelden()
	{
		this.TFItemid.clear();
		this.TFKlantid.clear();
		this.kass.clear();
		this.datum.setValue(LocalDate.now());
		textStation.clear();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		kolom1.setText(Strings.itemId[Settings.getInstance().getTaal().getValue()]);
		kolom2.setText(Strings.klantId[Settings.getInstance().getTaal().getValue()]);
		kolom3.setText(Strings.beschrijving[Settings.getInstance().getTaal().getValue()]);
		kolom4.setText("station");
		kolom5.setText(Strings.datumGevonden[Settings.getInstance().getTaal().getValue()]);
		kolom6.setText(Strings.datumOpgehaald[Settings.getInstance().getTaal().getValue()]);
		kolom7.setText(Strings.kassierId[Settings.getInstance().getTaal().getValue()]);
		kolom8.setText(Strings.treinId[Settings.getInstance().getTaal().getValue()]);

		
		kolom1.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("itemId"));
		kolom2.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("klantId"));
		kolom3.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("beschrijving"));
		kolom4.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("Station"));
		kolom5.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("DatumGevonden"));
		kolom6.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("DatumOpgehaald"));
		kolom7.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("KassierID"));
		kolom8.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("TreinID"));
		TextFields.bindAutoCompletion(this.textStation,  Definitions.getStationsNamen());

	
		this.refresh();
	}
	public void refresh() {
		VerlorenVoorwerpDAo a= new VerlorenVoorwerpDAo();
		try {
			vwerpen = FXCollections.observableArrayList(a.getAlles());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabel.setItems(vwerpen);
	}
	
	public void inserten(ActionEvent event)
	{
	
		VerlorenVoorwerp v = new VerlorenVoorwerp();
		v.setBeschrijving( txtbeschrijving.getText());
		Settings.getInstance();
		v.setKassierID(Settings.getIngelogdPersoneelslid().getPersonneelsId());
		v.setKlantId(Integer.parseInt(this.TFKlantid.getText()));
		v.setStation(textStation.getText());
		//v.setTreinid(this.textTreinid.getText()); uncommenten ! 
		VerlorenVoorwerpDAo b = new VerlorenVoorwerpDAo();
		try {
			b.insertVerlorenvoorwerp(v);
			 resultArea.setText("Item inserted! \n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 resultArea.setText("Item not inserted! \n");
			e.printStackTrace();
		}
		refresh();
		
	}
	
	public void vulTabel()
	{
		ArrayList<VerlorenVoorwerp> a =new ArrayList<VerlorenVoorwerp>();
		VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();
		
		try {
			vwerpen =  (ObservableList<VerlorenVoorwerp>) v.getAlles();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtbeschrijving.setText(null);
		textStation.clear();
		
	
		
		
		tabel.setItems(vwerpen);
	}
		
		
	 @FXML
	 private void updateVerlorenVoorwerp (ActionEvent actionEvent) 
	    {
		 		VerlorenVoorwerpDAo a= new VerlorenVoorwerpDAo();
//		 		if(Integer.parseInt(this.TFKlantid.getText())  == 0 || this.TFKlantid ==null )
//		 		{
//	            a.updateVerlorenvoorwerp(0,Integer.parseInt(this.TFKlantid.getText()) );
//	           
//		 		}
//		 		else{
		 		 //  a.updateVerlorenvoorwerp(Integer.parseInt(this.TFKlantid.getText()),Integer.parseInt(this.TFItemid.getText()) );
		 		a.ophalenVoorwerp(this.txtbeschrijving.getText());
		 	//	}
		 		resultArea.setText(Strings.Gevonden[Settings.getInstance().getTaal().getValue()] + this.TFItemid.getText() + "\n");
		 		refresh();
		 		
	    }
	 
	
public static void main(String[] args) throws IOException {
//	URL startScherm2 = VerlorenVoorwerpController.class.getResource("VerlorenvoorwerpenView.fxml") ;
//	
//	Parent startScherm = FXMLLoader.load(startScherm2);
//	
//	Scene startScene = new Scene(startScherm);
//	Stage startStage = new Stage();
//	startStage.setScene(startScene);
//	startStage.show();
//	Main.setScene(startScene);
//	Main.setRoot(startScherm);
//	Main.setWindow(startStage);
	
	}


}

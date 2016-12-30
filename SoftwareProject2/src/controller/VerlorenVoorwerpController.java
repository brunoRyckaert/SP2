package controller;
import java.io.IOException;
/**
 * @author ilias
 */
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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

public class VerlorenVoorwerpController implements Initializable {

	 VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();	
	 ArrayList<String>stations = Definitions.getStations();
	
	 ObservableList<VerlorenVoorwerp> vwerpen;
		
			
	@FXML
	private TableView<VerlorenVoorwerp> tabel = new TableView<VerlorenVoorwerp>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom1 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom2 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom3 = new TableColumn<VerlorenVoorwerp, String>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom4 = new TableColumn<VerlorenVoorwerp, String>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Date> kolom5 = new TableColumn<VerlorenVoorwerp, Date>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Date> kolom6 = new TableColumn<VerlorenVoorwerp, Date>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom7 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, String> kolom8 = new TableColumn<VerlorenVoorwerp, String>();
	@FXML
	private Label kassierid = new Label();
	@FXML
	private ReadOnlyIntegerProperty kass = new TextField().anchorProperty();
	@FXML
	private TextField txtbeschrijving = new TextField();
	@FXML
	private Label lblbeschr = new Label();
	@FXML
	private Label LStation = new Label();
	@FXML
	private TextField textStation = new TextField();
	@FXML
	private Label lblDate = new Label();
	@FXML
	private DatePicker datum = new DatePicker();
	@FXML
	private Label lblTreinid = new Label();
	@FXML
	private TextField textTreinid = new TextField();
	@FXML
	private Button btnzoek = new Button();
	@FXML
	private Button btnIns = new Button();
	
	
	public void zoekbutton(ActionEvent event)
	{
		
		ArrayList<VerlorenVoorwerp> a =new ArrayList<VerlorenVoorwerp>();
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
			a = v.selectLijstVVByDAte(datum.toString());
		}
		vwerpen = (ObservableList<VerlorenVoorwerp>) a;
		
		txtbeschrijving.setText(null);
		textStation.clear();
		
		
		
		tabel.setItems(vwerpen);
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		ArrayList<VerlorenVoorwerp> a =new ArrayList<VerlorenVoorwerp>();
		VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();
		
		
		
		txtbeschrijving.setText(null);
		textStation.clear();
		
	
		
		
		
		
		
		/*private int itemId;
	private int klantId;
	private String beschrijving;
	private String station;
	private Date datumGevonden;
	private int kassierID;
	private String treinid;*/
		/*firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
         // p.getValue() returns the Person instance for a particular TableView row
         return p.getValue().firstNameProperty();
     }
  });
 }*/
	
		kolom1.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("itemId"));
		kolom2.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("klantId"));
		kolom3.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("beschrijving"));
		kolom4.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("station"));
		kolom5.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumGevonden"));
	//	kolom6.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumOpgehaald"));
		kolom7.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("kassierID"));
		kolom8.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("treinid"));
		
	/*	kolom1.setCellValueFactory(cellData -> cellData.getValue().getItemId().asObject());
	        kolom2.setCellValueFactory(cellData -> cellData.getValue().getKlantId().asObject());
	        kolom3.setCellValueFactory(cellData -> cellData.getValue().getBeschrijving());
	        kolom4.setCellValueFactory(cellData -> cellData.getValue().getStation());
	        kolom5.setCellValueFactory(cellData -> cellData.getValue().getDatumGevonden());
	        kolom6.setCellValueFactory(cellData -> cellData.getValue().getDatumOpgehaald());
	        kolom7.setCellValueFactory(cellData -> cellData.getValue().getKassierID().asObject());
	        kolom8.setCellValueFactory(cellData -> cellData.getValue().getTreinid());*/
	      
	        try {
				tabel.setItems( FXCollections.observableArrayList(v.getAlles()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		v.setKassierID(this.kass.get());
		v.setStation(textStation.getText());
		v.setTreinid(this.textTreinid.getText());
		VerlorenVoorwerpDAo b = new VerlorenVoorwerpDAo();
		b.insertVerlorenvoorwerp(v);
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
		
	
		
		
		
		
		
		/*private int itemId;
	private int klantId;
	private String beschrijving;
	private String station;
	private Date datumGevonden;
	private int kassierID;
	private String treinid;*/
	
		/*kolom1.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("itemId"));
		kolom2.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("klantId"));
		kolom3.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("beschrijving"));
		kolom4.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("station"));
		kolom5.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumGevonden"));
	//	kolom6.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumOpgehaald"));
		kolom7.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("kassierID"));
		kolom8.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("treinid"));*/
		
	/*kolom1.setCellValueFactory(cellData -> cellData.getValue().getItemId().asObject());
	        kolom2.setCellValueFactory(cellData -> cellData.getValue().getKlantId().asObject());
	        kolom3.setCellValueFactory(cellData -> cellData.getValue().getBeschrijving());
	        kolom4.setCellValueFactory(cellData -> cellData.getValue().getStation());
	        kolom5.setCellValueFactory(cellData -> cellData.getValue().getDatumGevonden());
	        kolom6.setCellValueFactory(cellData -> cellData.getValue().getDatumOpgehaald());
	        kolom7.setCellValueFactory(cellData -> cellData.getValue().getKassierID().asObject());
	        kolom8.setCellValueFactory(cellData -> cellData.getValue().getTreinid());*/
	      
	        tabel.setItems(vwerpen);
	}
	/*public static void main(String[] args) {
		launch(args);
		System.out.println("ii");
	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
		ArrayList<VerlorenVoorwerp> a =new ArrayList<VerlorenVoorwerp>();
		VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();
		
		
		
		txtbeschrijving.setText(null);
		textStation.clear();
		
		
		
		/*private int itemId;
	private int klantId;
	private String beschrijving;
	private String station;
	private Date datumGevonden;
	private int kassierID;
	private String treinid;*/
		/*
	
		kolom1.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("itemId"));
		kolom2.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("klantId"));
		kolom3.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("beschrijving"));
		kolom4.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("station"));
		kolom5.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumGevonden"));
	//	kolom6.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Date>("datumOpgehaald"));
		kolom7.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, Integer>("kassierID"));
		kolom8.setCellValueFactory(new PropertyValueFactory<VerlorenVoorwerp, String>("treinid"));
		
	/*	kolom1.setCellValueFactory(cellData -> cellData.getValue().getItemId().asObject());
	        kolom2.setCellValueFactory(cellData -> cellData.getValue().getKlantId().asObject());
	        kolom3.setCellValueFactory(cellData -> cellData.getValue().getBeschrijving());
	        kolom4.setCellValueFactory(cellData -> cellData.getValue().getStation());
	        kolom5.setCellValueFactory(cellData -> cellData.getValue().getDatumGevonden());
	        kolom6.setCellValueFactory(cellData -> cellData.getValue().getDatumOpgehaald());
	        kolom7.setCellValueFactory(cellData -> cellData.getValue().getKassierID().asObject());
	        kolom8.setCellValueFactory(cellData -> cellData.getValue().getTreinid());*/
	      /*
	        try {
				tabel.setItems( FXCollections.observableArrayList(v.getAlles()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
*/}

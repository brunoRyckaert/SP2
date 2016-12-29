package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Definitions;

public class VerlorenVoorwerpController extends Application implements Initializable {

	 ArrayList<String>stations = Definitions.getStations();
	 ObservableList<VerlorenVoorwerp> vwerpen;
	@FXML
	private TableView<VerlorenVoorwerp> tabel = new TableView<VerlorenVoorwerp>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom1 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom2 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom3 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom4 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom5 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom6 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom7 = new TableColumn<VerlorenVoorwerp, Integer>();
	@FXML
	private TableColumn<VerlorenVoorwerp, Integer> kolom8 = new TableColumn<VerlorenVoorwerp, Integer>();
	/*TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
	 firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
	     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
	         // p.getValue() returns the Person instance for a particular TableView row
	         return p.getValue().firstNameProperty();
	     }
	  });
*/

	@FXML
	private TextArea txtbeschrijving = new TextArea();
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
	private TextArea textTreinid = new TextArea();
	@FXML
	private Button btnzoek = new Button();
	
	@SuppressWarnings("unchecked")
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
		
		for (int i = 0; i < vwerpen.size(); i++) {
			
		}
		
		tabel.setItems(vwerpen);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TextFields.bindAutoCompletion(textStation,  stations);
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

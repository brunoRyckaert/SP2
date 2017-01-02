package controller;




import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Definitions;
import model.Settings;
import model.Station;
import model.Strings;
import model.Ticket;
import model.TicketSoort;

public class TicketVerkopenController implements Initializable {

	ArrayList<Station> stations = Definitions.getStations();
	@FXML
	private Label lblvan = new Label();
	@FXML
	private Label lblnaar = new Label();
	@FXML
	private Label lblheen = new Label();
	@FXML
	private Label lblvterug = new Label();
	@FXML
	private Label lblkorting = new Label();
	@FXML
	private Label lblklasse = new Label();
	@FXML
	private Label lblprijs = new Label();
	@FXML
	private TextField TFvan = new TextField();
	@FXML
	private TextField TFnaar = new TextField();
	@FXML
	private TextField TFKorting = new TextField();
	@FXML
	private TextField TFprijs = new TextField();
	@FXML
	private DatePicker DPHeen = new DatePicker();
	@FXML
	private DatePicker DPTerug = new DatePicker();
	@FXML
	private Button btnbetalen = new Button();
	@FXML
	private ComboBox<String> klasse;
	@FXML
	private ComboBox<String> cmbTicketSoort;
    @FXML
    private Label lblTicketSoort;
	@FXML
	private RadioButton rbEnkel;
	@FXML
	private RadioButton rbHeenTerug;
	private ToggleGroup group = new ToggleGroup();
	@FXML
	private Label lblError = new Label();
private ObservableList<String> lijst =  FXCollections.observableArrayList();
	private ObservableList<TicketSoort>soorten;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	/*comboBox.getItems().addAll(
    "Option 4",
    "Option 5",
    "Option 6"
);*/
		klasse.getItems().addAll(Strings.eerstKlasse[Settings.getInstance().getTaal().getValue()],Strings.tweedeKlasse[Settings.getInstance().getTaal().getValue()]);
		rbEnkel.setSelected(true);
		 TextFields.bindAutoCompletion(this.TFnaar,Definitions.getStationsNamen());
		 TextFields.bindAutoCompletion(this.TFvan,Definitions.getStationsNamen());
		 TicketSoortDAO dao = new TicketSoortDAO();
		 soorten = dao.getAlles();
		 rbEnkel.setText(Strings.rbHeen[Settings.getInstance().getTaal().getValue()]);
		 rbHeenTerug.setText(Strings.rbHeenTerug[Settings.getInstance().getTaal().getValue()]);
		 //
		 this.lblheen.setText(Strings.rbHeen[Settings.getInstance().getTaal().getValue()]);
		 this.lblklasse.setText(Strings.klasse[Settings.getInstance().getTaal().getValue()]);
		 this.lblkorting.setText(Strings.korting[Settings.getInstance().getTaal().getValue()]);
		 this.lblnaar.setText(Strings.naarStation[Settings.getInstance().getTaal().getValue()]);
		 this.lblprijs.setText(Strings.prijs[Settings.getInstance().getTaal().getValue()]);
		 this.lblTicketSoort.setText(Strings.ticketsoort[Settings.getInstance().getTaal().getValue()]);
		 this.lblvan.setText(Strings.vanStation[Settings.getInstance().getTaal().getValue()]);
		 this.lblvterug.setText(Strings.terug[Settings.getInstance().getTaal().getValue()]);
		 for(TicketSoort tick : soorten)
		 {
			 lijst.add(tick.getNaam());
		 }
		 klasse.setValue(Strings.tweedeKlasse[Settings.getInstance().getTaal().getValue()]);
		 cmbTicketSoort.getItems().addAll(lijst);
		 cmbTicketSoort.setValue(lijst.get(0));;
			rbEnkel.setToggleGroup(group);
			rbHeenTerug.setToggleGroup(group);
	}
	
	public void betalenbtn(ActionEvent event)
	{
		lblError.setText("");


		if(Definitions.getStationsNamen().contains(TFvan.getText()) && Definitions.getStationsNamen().contains(TFnaar.getText()) && TFnaar.getText().length()!=0 && TFvan.getText().length()!=0)
		{if(TFvan.getText().compareTo(TFnaar.getText()) == 0)
		{
			lblError.setText(Strings.zelfdeStation[Settings.getInstance().getTaal().getValue()]);
		}
		else
		{
			if(	DPHeen.getValue() != null  && !DPHeen.getValue().equals("") && DPTerug.getValue()!= null  && !DPTerug.getValue().equals("") )
			{
				if(TFKorting.getText().length() != 0)
				{
			Ticket a = new Ticket();
			a.setBeginStation(this.TFvan.getText());
			a.setEindStation(this.TFnaar.getText());
			System.out.println(this.DPHeen.getValue().toString());
			a.setHeenDatum(Date.valueOf(this.DPHeen.getValue().toString()));
			a.setTerugDatum(Date.valueOf(this.DPTerug.getValue().toString()));
			
			if(rbEnkel.isSelected())
			a.setHeenTerug(false);
			else
			{
				a.setHeenTerug(true);
			}
			TicketSoort soort = soorten.get(lijst.indexOf(cmbTicketSoort.getValue()));
			System.out.println(soort.getTicketSoortID());

			a.setTicketSoortID(soort.getTicketSoortID());
			if(klasse.getValue().matches(Strings.eerstKlasse[Settings.getInstance().getTaal().getValue()]))
			{
			a.setKlasse(0);

			}
			else
			{
				a.setKlasse(1);

			}
			TicketSoortDAO dao = new TicketSoortDAO();
			TicketDAO b = new TicketDAO();
			
			double korting = Double.parseDouble(TFKorting.getText());
			clearalleVelden();
			double prijs = -1;
			try {
				prijs = a.berekenPrijs(dao.getTicket(a.getTicketSoortID()).getPrijsberekening());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(prijs == -1)
			{
				//geen connectie 
			}
			else
			{
			
			if(prijs - korting < 0)
			{
				prijs = 0;
			}
			else
			{
				prijs = prijs - korting;
			}
			a.setPrijs(prijs);
			this.TFprijs.setText(Strings.bedrag[Settings.getInstance().getTaal().getValue()] + prijs);
			try {		
				b.setTicket(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}
			else
			{
				lblError.setText(Strings.allesInvullen[Settings.getInstance().getTaal().getValue()]);
			}
		}
		else
			{
				lblError.setText(Strings.allesInvullen[Settings.getInstance().getTaal().getValue()]);
			}
		}
	
		}
		else if(TFvan.getText().trim().equals("") && TFnaar.getText().trim().equals(""))
		{
			lblError.setText(Strings.allesInvullen[Settings.getInstance().getTaal().getValue()]);
		}
	else
			{
						lblError.setText(Strings.bestaan[Settings.getInstance().getTaal().getValue()]);	
			}
		
		
	}
	public void clearalleVelden()
	{
		this.TFKorting.clear();
		this.TFnaar.clear();
		this.TFprijs.clear();
		this.TFvan.clear();
		this.DPHeen.setValue(null);
		this.DPTerug.setValue(null);
	}

	

}

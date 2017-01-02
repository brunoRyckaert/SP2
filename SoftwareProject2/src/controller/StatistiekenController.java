package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Settings;
import model.StatStation;
import model.Strings;

public class StatistiekenController implements Initializable{

	final ToggleGroup group = new ToggleGroup();;
	@FXML
	private Label lblstat = new Label();
	@FXML
	private RadioButton btnEen = new RadioButton (Strings.OmzetvanDag[Settings.getInstance().getTaal().getValue()]);
	@FXML
	private RadioButton btntwee = new RadioButton (Strings.Omzet2date[Settings.getInstance().getTaal().getValue()]);
	@FXML
	private RadioButton btndrie = new RadioButton (Strings.tickets2date[Settings.getInstance().getTaal().getValue()]);
	@FXML
	private RadioButton btnVier = new RadioButton (Strings.top5stations[Settings.getInstance().getTaal().getValue()]);
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
	@FXML
    final BarChart<String,Number> chart = new BarChart<String,Number>(xAxis,yAxis);
	private Label EindDatum = new Label();

	@FXML
	private Label tekst = new Label();
	@FXML
	private DatePicker begin;
	@FXML
	private DatePicker eind;

	

	
	/*ChoiceBox cb = new ChoiceBox();
	cb.setItems(FXCollections.observableArrayList(
	    "New Document", "Open ", 
	    new Separator(), "Save", "Save as")
	);*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	btnEen.setText(Strings.OmzetvanDag[Settings.getInstance().getTaal().getValue()]);
	btntwee.setText(Strings.Omzet2date[Settings.getInstance().getTaal().getValue()]);
	btndrie.setText(Strings.tickets2date[Settings.getInstance().getTaal().getValue()]);
	btnVier.setText(Strings.top5stations[Settings.getInstance().getTaal().getValue()]);
		this.btnEen.setToggleGroup(group);
		this.btntwee.setToggleGroup(group);
		this.btndrie.setToggleGroup(group);
		this.btnVier.setToggleGroup(group);
		begin.setValue(LocalDate.now().minusDays(1));
		eind.setValue(LocalDate.now());
		this.lblstat.setText(Strings.eersteDatum[Settings.getInstance().getTaal().getValue()]);
		this.EindDatum.setText(Strings.tweedeDatum[Settings.getInstance().getTaal().getValue()]);
	}
	
	
	public void TopVijf(ActionEvent event)
	{
		tekst.setText("");
		   ArrayList<StatStation> a=new ArrayList<StatStation>();
	    	StatistiekDAO b = new StatistiekDAO(); 
	    	a=b.TopVijfMeestStation();
	    	int i = 1;
	    	for(StatStation st : a)
	    	{
	    		tekst.setText(tekst.getText()+i+") "+st.getNaam()+"\n"); 
	    		i++;
	    	}
	    	
	}
	
	public void omzetdag(ActionEvent event)
	{
		tekst.setText("");
		StatistiekDAO s = new StatistiekDAO();
		tekst.setText(Strings.totaal[Settings.getInstance().getTaal().getValue()] + s.totaalOmzetVandeDag() + "euro");
	}
	
	public void OmzetTweeData(ActionEvent event)
	{
//		 this.btndrie.setSelected(false);
//	        this.btnVier.setSelected(false);
//	        this.btnEen.setSelected(false);
		tekst.setText("");
	     if(this.begin.getValue() ==null || this.begin.getValue().isBefore(this.eind.getValue()) == false || this.eind.getValue() == null)
	        {
	        	this.tekst.setText(Strings.fout[Settings.getInstance().getTaal().getValue()]);

	        }
	     else
	     {
	        StatistiekDAO s = new StatistiekDAO();
	        
	        this.tekst.setText(Strings.totaal[Settings.getInstance().getTaal().getValue()]+ this.begin.getValue().toString() + "en "+this.eind.getValue().toString() +" is \n "+ s.totaalOmzetBinnenEenBepaaldePeriode(Date.valueOf(this.begin.getValue().toString()), Date.valueOf(this.eind.getValue().toString())));
	     }
	}
	public void aantalTicketen(ActionEvent event)
	{
		tekst.setText("");
		StatistiekDAO sDao = new StatistiekDAO();
	     if(this.begin.getValue() ==null || this.begin.getValue().isBefore(this.eind.getValue()) == false || this.eind.getValue() == null)
	        {
	        	this.tekst.setText(Strings.fout[Settings.getInstance().getTaal().getValue()]);

	        }
	     else
	     {
	        StatistiekDAO s = new StatistiekDAO();
		 this.tekst.setText(Strings.verkochteTickets[Settings.getInstance().getTaal().getValue()]+sDao.aantalTicket(Date.valueOf(this.begin.getValue().toString()),Date.valueOf(this.eind.getValue().toString())) );
	}
	}
}

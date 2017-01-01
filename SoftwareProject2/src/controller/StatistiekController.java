package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import model.Settings;
import model.Strings;

public class StatistiekController implements Initializable{

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
	@FXML
	final NumberAxis xAxis = new NumberAxis();
	@FXML
    final CategoryAxis yAxis = new CategoryAxis();
	
	@FXML
    final BarChart<Number,String> bc = new BarChart<Number,String>(xAxis,yAxis);
	@FXML
	private TextArea tekst;
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
		// TODO Auto-generated method stub
		
	
		this.btnEen.setToggleGroup(group);
		this.btntwee.setToggleGroup(group);
		this.btndrie.setToggleGroup(group);
		this.btnVier.setToggleGroup(group);
		
	}
	
	
	public void TopVijf(ActionEvent event)
	{
		   ArrayList<StatStation> a=new ArrayList<StatStation>();
	    	StatistiekDAO b = new StatistiekDAO(); 
	    	a=b.TopVijfMeestStation();
	    	
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("Verkochte tickets");
	       
	        for (int i = 0; i < a.size(); i++) {
	        	 series3.getData().add(new XYChart.Data(a.get(i).getAantal(), a.get(i).getNaam()));
			}
	        bc.getData().addAll(series3);
	        this.btndrie.setSelected(false);
	        this.btnEen.setSelected(false);
	        this.btntwee.setSelected(false);
	}
	
	public void omzetdag(ActionEvent event)
	{
		StatistiekDAO s = new StatistiekDAO();
		
		tekst.setText("De omzet van vandaag is " + s.totaalOmzetVandeDag() + "euro");
		  this.btndrie.setSelected(false);
	        this.btnVier.setSelected(false);
	        this.btntwee.setSelected(false);
	}
	
	public void OmzetTweeData(ActionEvent event)
	{
		 this.btndrie.setSelected(false);
	        this.btnVier.setSelected(false);
	        this.btnEen.setSelected(false);
	        
	        while(this.begin.getValue() ==null || this.begin.getValue().isBefore(this.eind.getValue()) == true || this.eind.getValue() == null)
	        {
	        	this.tekst.setText("FOUTIEVE INVOER SCHRIJF DATUM");
	        	this.begin.setValue(LocalDate.now());
	        	this.eind.setValue(LocalDate.now());
	        }
	        StatistiekDAO s = new StatistiekDAO();
	        
	        this.tekst.setText("De omzet tussen "+ this.begin.getValue().toString() + "en "+this.eind.getValue().toString() +" is van "+ s.totaalOmzetBinnenEenBepaaldePeriode(this.begin.getValue().toString(), this.eind.getValue().toString()));
	        
	}
	

}

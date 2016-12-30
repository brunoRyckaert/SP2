package controller;

import java.net.URL;
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

public class StatistiekController implements Initializable{

	@FXML
	private Label lblstat = new Label();
	@FXML
	private ChoiceBox<String> kies = new ChoiceBox<String>();
	@FXML
	final NumberAxis xAxis = new NumberAxis();
	@FXML
    final CategoryAxis yAxis = new CategoryAxis();
	@FXML
    final BarChart<Number,String> bc = new BarChart<Number,String>(xAxis,yAxis);

	

	
	/*ChoiceBox cb = new ChoiceBox();
	cb.setItems(FXCollections.observableArrayList(
	    "New Document", "Open ", 
	    new Separator(), "Save", "Save as")
	);*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	kies.getItems().addAll("top 5 meest productieve stations","omzet van de dag","omzet tussen twee data","aantal verkochte ticketten");
		kies.show();
		kies.setVisible(true);
		
		
	}
	
	
	public void TopVijf()
	{
		   ArrayList<StatStation> a=new ArrayList<StatStation>();
	    	StatistiekDAO b = new StatistiekDAO(); 
	    	a=b.TopVijfMeestStation();
	    	
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("Verkochte tickets");
	       
	        for (int i = 0; i < a.size(); i++) {
	        	 series3.getData().add(new XYChart.Data(a.get(i).getAantal(), a.get(i).getNaam()));
			}
	}

}

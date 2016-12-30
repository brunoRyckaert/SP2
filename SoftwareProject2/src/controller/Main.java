package controller;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.stage.Stage;
//import model.Korting;
//import model.Login;
//import model.Ticket;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.*;
//import java.util.Scanner;
//import java.util.SortedSet;
//import java.util.TreeSet;
//
//import com.sun.prism.Image;
//
//import view.Gui;
//// gebruikersnaam = kassier password = kassier
//// gebruikersnaam = admin   password = admin
//public class Main extends Application {
//	
//	static Stage window;
//	static Scene scene;
//	static Parent root;
//	/*@Override
//	public  void start(Stage primaryStage) {
//		try {
//			root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
//			scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public  void start(Stage primaryStage) {
//		try {
//			root = FXMLLoader.load(getClass().getResource("VerlorenvoorwerpView.fxml"));
//			scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/*
//	public static void main(String[] args) {
////	launch(args);
////	Korting k = new Korting();
////	KortingDAO dao = new KortingDAO();
////		k = dao.getKorting(1);
////		System.out.println(k.getPrijs());
//try {
//	Ticket t = TicketDAO.getTicket(1);
//
//<<<<<<< HEAD
//	TicketDAO.setTicket(t);
//	
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//=======
//	public static void main(String[] args) {
//		launch(args);
//	}*/
//	
//	public static void main(String[] args) {
//		/*VerlorenVoorwerpDAo v = new VerlorenVoorwerpDAo();
//		
//		System.out.println(v.selectLijstVVByNaam(" ").toString());
//		KlantDAO k = new KlantDAO ();
//		
//		System.out.println(k.getKlant(1).toString());
//		*/
//		//start();
//		Parent startScherm = FXMLLoader.load(getClass().getResource("VerlorenVoorwerpView"));
//		Scene startScene = new Scene(startScherm);
//		Stage startStage = new Stage();
//	}
//	@Override
//	public void start(Stage arg0) throws Exception {
//		// TODO Auto-generated method stub
//		Parent startScherm = FXMLLoader.load(getClass().getResource("VerlorenVoorwerpView"));
//		Scene startScene = new Scene(startScherm);
//		Stage startStage = new Stage();
//	}
//}
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

//Main class which extends from Application Class
public class Main extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the EmployeeOperations View
        showEmployeeView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("VerlorenvoorwerpView.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

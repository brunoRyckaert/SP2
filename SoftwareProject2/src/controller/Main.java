package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Korting;
import model.Login;
import model.Settings;
import model.Ticket;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sun.prism.Image;

import view.Gui;
// gebruikersnaam = kassier password = kassier
// gebruikersnaam = admin   password = admin
public class Main extends Application {
	
	private static Stage window;
	private static Scene scene;
	private static Parent root;
	public static Stage getWindow() {
		return window;
	}
	public static void setWindow(Stage window) {
		Main.window = window;
	}
	public static Scene getScene() {
		return scene;
	}
	public static void setScene(Scene scene) {
		Main.scene = scene;
	}
	public static Parent getRoot() {
		return root;
	}
	public static void setRoot(Parent root) {
		Main.root = root;
	}
	@Override
	public  void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("VerlorenVoorwerpenView.fxml"));
			scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	launch(args);
	
	}

}
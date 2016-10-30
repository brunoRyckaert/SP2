package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Login;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;



import com.sun.prism.Image;

import view.Gui;
// gebruikersnaam = trein
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(Login.Sha512("trein","salty"));
		launch(args);
	}
}

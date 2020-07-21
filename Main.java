package com.intershala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start");
		FXMLLoader loader = new
				               FXMLLoader(getClass().getResource("app_layout.fxml"));

		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();

		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");

		primaryStage.show();
	}

	private MenuBar createMenu(){

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked."));

		quitMenuItem.setOnAction(event -> {

			Platform.exit();
			System.out.println(0);
		});

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("App");
		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My JavaFX App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Right now I am a begineer, but soon with the help of my mentor" +
				                   " guidance, I will become pro " + "and start developing Java Games.");


		ButtonType yesBtn = new ButtonType(("Yes"));
		ButtonType noBtn = new ButtonType(("No"));
		ButtonType okBtn = new ButtonType(("ok"));

		alertDialog.getButtonTypes().setAll(noBtn,okBtn,yesBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if(clickedBtn.isPresent()&&clickedBtn.get()==yesBtn){

		System.out.println("Yes Button Clicked");
		}
		else if(clickedBtn.isPresent()&&clickedBtn.get()==okBtn){

		System.out.println("OK button clicked");
		}
		else{
			System.out.println("No button clicked");
	}
	}
	@Override
	public void stop() throws Exception {

		System.out.println("stop");
		super.stop();
	}
}

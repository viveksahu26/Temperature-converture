package com.intershala.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	@FXML
	public ImageView imageBox;

	private static final String C_To_F_TEXT = "Celsius To Farenheit";
	private static final String F_To_C_TEXT = "Farenheit To Celsius";

	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_To_F_TEXT);
		choiceBox.getItems().add(F_To_C_TEXT);

		choiceBox.setValue(C_To_F_TEXT);    //default value

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if (newValue.equals(C_To_F_TEXT))  //if user has selected celsius to farenheit
			{
				isC_TO_F = true;
			} else {                     //else user has selected farenheit to celsius
				isC_TO_F = false;
			}

		});

		convertButton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		String input = userInputField.getText();
		float enteredTemperature = 0.0f;
		try {
			enteredTemperature = Float.parseFloat(input);
		} catch (Exception exception) {
			warnUser();
			return;
		}

		float newTemperature = 0.0f;
		if (isC_TO_F) {
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		} else {
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}
		display(newTemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured 404!");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter Valid Temperature..");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit = isC_TO_F ? "F" : "C";
		System.out.println("The new Temperature is : " + newTemperature + unit);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is : " + newTemperature +" "+ unit);
		alert.show();
	}
}

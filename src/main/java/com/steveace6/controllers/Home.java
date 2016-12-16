package com.steveace6.controllers;

import java.io.File;

import com.steveace6.helper.StringManipulation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Home {

	@FXML
	private VBox container;

	@FXML
	private Label title;

	@FXML
	private TextField hour;

	@FXML
	private TextField minute;
	
	private StringProperty mTimerText;
	private StringProperty mVlcFileText;

	public Home() {

		// startClock();
		mVlcFileText = new SimpleStringProperty();
		setVlcFileText("select a file");
		mTimerText = new SimpleStringProperty();
		setTimerText(100);
	}
	
	public String getVlcFileText(){
		return mVlcFileText.get();
	}

	public void setVlcFileText(String vlcFileText) {
		System.out.println("set VLC File Text");
		mVlcFileText.set(vlcFileText);
	}

	public String getTimerText() {
		return mTimerText.get();
	}

	public StringProperty vlcFileTextProperty(){
		return mVlcFileText;
	}
	
	public StringProperty timerTextProperty() {
		return mTimerText;
	}

	public void setTimerText(String timerText) {
		mTimerText.set(timerText);
	}

	public void setTimerText(int remainingSeconds) {
		int minutes = remainingSeconds / 60;
		int seconds = remainingSeconds % 60;
		setTimerText(String.format("%02d:%02d", minutes, seconds));
	}


	public void setAlarmTime(ActionEvent actionEvent) {
		System.out.println("Set Time");
		System.out.println("VLC File you choose: " + mVlcFileText.get());
		System.out.println("Hour: " + hour.getText() + " Min: " + minute.getText());

		setTimerText(hour.getText() + ":" + minute.getText());

		Alarm alarm = new Alarm();
	
		alarm.setAlarmClock(hour.getText(), minute.getText());
		System.out.println("Alarm set called");

	}

	public void searchForVlcFile(ActionEvent actionEvent) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose a VLC File To Play");

		Stage stage = new Stage();
		File file = fileChooser.showOpenDialog(stage);
		
		setVlcFileText(file.getName());
		Alarm.setVlcFilePath(file.getAbsolutePath());
	}

}

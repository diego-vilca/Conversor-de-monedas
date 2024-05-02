package com.vicv.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConverterGUI extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ConverterView.fxml"));
            stage.setTitle("Currency Converter");
            stage.setScene(new Scene(root,600,400));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
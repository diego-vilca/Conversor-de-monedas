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
            Scene scene = new Scene(root,600,400);
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
            stage.setTitle("Currency Converter");
            stage.setScene(scene);
//            scene.setFill(Color.TRANSPARENT);
//            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
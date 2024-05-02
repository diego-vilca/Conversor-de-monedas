package com.vicv.gui.controller;

import com.vicv.gui.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LogViewController implements Initializable {
    @FXML
    private Button btnBackToPrincipal;


    @FXML
    private AnchorPane apLog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onBackButtonClicked() {
        new SceneSwitch(apLog, "view/ConverterView.fxml");
    }
}

package com.vicv.gui.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterGUIController implements Initializable {

    @FXML
    private Button btnConvertCurrency;

    @FXML
    private Label lblBaseCurrency;

    @FXML
    private Label lblTargetCurrency;
    @FXML
    private ComboBox cbxTargetCurrency;
    @FXML
    private ComboBox cbxBaseCurrency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

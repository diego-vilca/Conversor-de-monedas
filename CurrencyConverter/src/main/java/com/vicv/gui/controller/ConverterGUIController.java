package com.vicv.gui.controller;

import com.vicv.calc.CurrencyCalculator;
import com.vicv.model.CurrencyConversion;
import com.vicv.util.CurrencyCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterGUIController implements Initializable {

    @FXML
    private Button btnConvertCurrency;
    @FXML
    private Label lblBaseCurrency;
    @FXML
    private Label lblTargetCurrency;
    @FXML
    private ComboBox<String> cbxTargetCurrency;
    @FXML
    private ComboBox<String> cbxBaseCurrency;
    @FXML
    private Label lblAmount;
    @FXML
    private TextField txtAmount;
    @FXML
    private Button btnLog;
    @FXML
    private TextField txtResult;
    @FXML
    private Label lblTittle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupComboBox();
    }

    @FXML
    public void onConvertCurrencyButtonClicked(ActionEvent actionEvent) {
        double amount = Double.valueOf(this.txtAmount.getText());
        String baseCurrency = getCurrencyCodeFromGUI(cbxBaseCurrency.getValue());
        String targetCurrency = getCurrencyCodeFromGUI(cbxTargetCurrency.getValue());
        CurrencyConversion conversionResult = CurrencyCalculator.calculateConversion(baseCurrency, targetCurrency, amount);

        this.txtResult.setText("$" + conversionResult.getConversionResult());
        System.out.println(conversionResult);
    }

    private void setupComboBox(){
        loadCbxItems();
        setCbxDefaultValue(this.cbxBaseCurrency, CurrencyCode.USD);
        setCbxDefaultValue(this.cbxTargetCurrency, CurrencyCode.ARS);
    }

    private void loadCbxItems(){
        ObservableList<String> obsList = FXCollections.observableArrayList();

        for(CurrencyCode item : CurrencyCode.values() ){
            obsList.add(item + " - " + item.getDescription());
        }
        this.cbxBaseCurrency.getItems().setAll(obsList);
        this.cbxTargetCurrency.getItems().setAll(obsList);
    }

    private void setCbxDefaultValue(ComboBox<String> cbx, CurrencyCode code){
        cbx.getSelectionModel().select(code.ordinal());
    }

    public static String getCurrencyCodeFromGUI(String currencyCodeFromCbx) {
        Pattern pattern = Pattern.compile("^(.{0,3})");
        Matcher matcher = pattern.matcher(currencyCodeFromCbx);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return currencyCodeFromCbx;
        }
    }
}

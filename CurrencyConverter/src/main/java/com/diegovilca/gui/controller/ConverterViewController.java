package com.diegovilca.gui.controller;

import com.diegovilca.calc.CurrencyCalculator;
import com.diegovilca.gui.SceneSwitch;
import com.diegovilca.model.CurrencyConversion;
import com.diegovilca.util.CommonConstants;
import com.diegovilca.util.CurrencyCodes;
import com.diegovilca.serializer.CurrencyConversionSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterViewController implements Initializable {


    @FXML
    private AnchorPane apConverter;
    @FXML
    private ComboBox cbxTargetCurrency;
    @FXML
    private Button btnConvertCurrency;
    @FXML
    private Label lblTargetCurrency;
    @FXML
    private Button btnLog;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtResult;
    @FXML
    private Label lblAmount;
    @FXML
    private Label lblTittle;
    @FXML
    private Label lblBaseCurrency;
    @FXML
    private ComboBox cbxBaseCurrency;
    private ObservableList<String> obsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obsList = FXCollections.observableArrayList();
        setupComboBox();
    }

    @FXML
    public void onConvertCurrencyButtonClicked(ActionEvent actionEvent) {
        Double amount = 0.0;
        try {
            amount = Double.valueOf(this.txtAmount.getText());
        }catch (NumberFormatException e){
            System.out.println("Ingrese un número válido.");
        }

        String baseCurrency = getCurrencyCodeFromGUI((String) cbxBaseCurrency.getValue());
        String targetCurrency = getCurrencyCodeFromGUI((String) cbxTargetCurrency.getValue());
        CurrencyConversion conversionResult = CurrencyCalculator.calculateConversion(baseCurrency, targetCurrency, amount);

        if (conversionResult.getConversionResult() != 0.0){
            CurrencyConversionSerializer.serialize(conversionResult, CommonConstants.JSON_FILE_PATH);
        }
        this.txtResult.setText("$" + conversionResult.getConversionResult());
    }

    private void setupComboBox() {
        loadCbxItems();
        setCbxDefaultValue(this.cbxBaseCurrency, CurrencyCodes.USD);
        setCbxDefaultValue(this.cbxTargetCurrency, CurrencyCodes.ARS);
    }

    private void loadCbxItems() {

        for (CurrencyCodes item : CurrencyCodes.values()) {
            obsList.add(item + " - " + item.getDescription());
        }

        this.cbxBaseCurrency.getItems().setAll(obsList);
        this.cbxTargetCurrency.getItems().setAll(obsList);
    }

    private void setCbxDefaultValue(ComboBox<String> cbx, CurrencyCodes code) {
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

    @FXML
    public void onLogButtonClicked() {
        new SceneSwitch(apConverter, "view/LogView.fxml");
    }

}

package com.vicv.gui.controller;

import com.vicv.calc.CurrencyCalculator;
import com.vicv.gui.SceneSwitch;
import com.vicv.model.CurrencyConversion;
import com.vicv.serializer.CurrencyConversionSerializer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static com.vicv.util.CommonConstants.*;

public class LogViewController implements Initializable {
    @FXML
    private Button btnBackToPrincipal;
    @FXML
    private AnchorPane apLog;
    @FXML
    private TableView<CurrencyConversion> tblConversionLog;
    @FXML
    private TableColumn<CurrencyConversion, String> colDate;
    @FXML
    private TableColumn<CurrencyConversion, String> colResult;
    @FXML
    private TableColumn<CurrencyConversion, String> colAmount;
    @FXML
    private TableColumn<CurrencyConversion, String> colBaseCurrency;
    @FXML
    private TableColumn<CurrencyConversion, String> colTargetCurrency;
    private ObservableList<CurrencyConversion> obsList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obsList = FXCollections.observableArrayList();
        loadTblItems();
    }

    private void loadTblItems(){
        obsList.addAll(CurrencyConversionSerializer.readFromJson());
        this.tblConversionLog.setItems(obsList);

        this.colBaseCurrency.setCellValueFactory(cellData -> {
            CurrencyConversion data = cellData.getValue();
            return new SimpleStringProperty(data.getBaseCurrency().getDescription());
        });

        this.colTargetCurrency.setCellValueFactory(cellData -> {
            CurrencyConversion data = cellData.getValue();
            return new SimpleStringProperty(data.getTargetCurrency().getDescription());
        });

//        this.colResult.setCellValueFactory(new PropertyValueFactory("conversionResult"));
        this.colResult.setCellValueFactory(cellData -> {
            double result = cellData.getValue().getConversionResult();
            return new SimpleStringProperty("$" + result);
        });

        this.colDate.setCellValueFactory(cellData -> {
            LocalDateTime dateTime = cellData.getValue().getConversionTime();
            return new SimpleStringProperty(CurrencyCalculator.formatDateTime(dateTime, DATETIME_PATTERN));
        });

        this.colAmount.setCellValueFactory(cellData -> {
            CurrencyConversion data = cellData.getValue();
            double amount = data.getConversionResult() / data.getExchangeRate();

            DecimalFormat df = new DecimalFormat("#.##");
            amount = Double.parseDouble(df.format(amount));

            return new SimpleStringProperty("$" + amount);
        });
    }

    @FXML
    public void onBackButtonClicked() {
        new SceneSwitch(apLog, "view/ConverterView.fxml");
    }
}

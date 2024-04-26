package com.vicv.app;

import com.vicv.calc.CurrencyConverter;
import com.vicv.dto.ExchangeRateDTO;
import com.vicv.http.ExchangeRateClient;
import com.vicv.model.BaseCurrency;
import com.vicv.model.TargetCurrency;

public class Main {
    public static void main(String[] args) {
        try{
            //esto viene de la gui
            String base = "EUR";//borrador
            String target = "GBP";//borrador
            /***************************************************************/
            ExchangeRateClient apiConnection = new ExchangeRateClient(base, target);
            ExchangeRateDTO response = apiConnection.Request();
            BaseCurrency baseCurrency = new BaseCurrency(response.baseCode(), 100);
            TargetCurrency targetCurrency = new TargetCurrency(response.targetCode());
            //CurrencyConverter.currencyConversion(100, )


        }catch (Exception e){

        }

    }
}
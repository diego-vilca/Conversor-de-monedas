package com.vicv.calc;

import com.vicv.dto.ExchangeRateDTO;
import com.vicv.http.ExchangeRateClient;

public class CurrencyCalculator {
    public static Double calculateConversion (String baseCurrencyCode, String targetCurrencyCode, double amount){
        Double convertedValue = null;

        try{
            ExchangeRateClient apiConnection = new ExchangeRateClient(baseCurrencyCode, targetCurrencyCode);
            ExchangeRateDTO response = apiConnection.Request();
            //System.out.println(response);
            convertedValue = CurrencyCalculator.calculateExchange(amount, response.conversionRate());
            //System.out.println(convertedValue);
        }
        catch(Exception e){
            System.out.println(e);
        }

        return convertedValue;
    }
    public static Double calculateExchange(double amount, double conversionRate){
        String result = String.format("%.2f", amount * conversionRate);
        return Double.valueOf(result.replace(",", "."));
    }
}

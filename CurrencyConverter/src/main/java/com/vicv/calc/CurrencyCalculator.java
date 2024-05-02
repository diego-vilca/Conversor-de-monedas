package com.vicv.calc;

import com.vicv.dto.ExchangeRateDTO;
import com.vicv.http.ExchangeRateClient;
import com.vicv.model.CurrencyConversion;
import com.vicv.util.CurrencyCode;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyCalculator {
    public static CurrencyConversion calculateConversion (String baseCurrencyCode, String targetCurrencyCode, double amount){
        double conversionResult;

        try{
            ExchangeRateClient apiConnection = new ExchangeRateClient(baseCurrencyCode, targetCurrencyCode);
            ExchangeRateDTO response = apiConnection.getRequest();
            conversionResult = CurrencyCalculator.calculateExchange(amount, response.conversionRate());

            return new CurrencyConversion(CurrencyCode.valueOf(response.baseCode()), CurrencyCode.valueOf(response.targetCode()), conversionResult, response.conversionRate(), LocalDateTime.now());
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public static double calculateExchange(double amount, double conversionRate){
        String result = String.format("%.2f", amount * conversionRate);
        return Double.valueOf(result.replace(",", "."));
    }

}

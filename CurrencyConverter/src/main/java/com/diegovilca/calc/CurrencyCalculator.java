package com.diegovilca.calc;

import com.diegovilca.dto.ExchangeRateDTO;
import com.diegovilca.http.apiClient;
import com.diegovilca.model.CurrencyConversion;
import com.diegovilca.util.CurrencyCodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyCalculator {
    public static CurrencyConversion calculateConversion (String baseCurrencyCode, String targetCurrencyCode, double amount){
        double conversionResult;
        LocalDateTime conversionTime;

        try{
            apiClient apiConnection = new apiClient(baseCurrencyCode, targetCurrencyCode);
            ExchangeRateDTO response = apiConnection.getRequest();
            conversionResult = CurrencyCalculator.calculateExchange(amount, response.conversionRate());
//            conversionTime = formatDateTime(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss");
            conversionTime = LocalDateTime.now();
            return new CurrencyConversion(CurrencyCodes.valueOf(response.baseCode()), CurrencyCodes.valueOf(response.targetCode()), conversionResult, response.conversionRate(), conversionTime);
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
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        // Create a date and time formatter with the specified pattern.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // Format the LocalDateTime using the formatter and convert it back to LocalDateTime.
        String formattedDateTimeStr = dateTime.format(formatter);

        return formattedDateTimeStr;
    }

}

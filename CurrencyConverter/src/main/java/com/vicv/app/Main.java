package com.vicv.app;

import com.vicv.calc.CurrencyCalculator;

public class Main {
    public static void main(String[] args) {
        //esto viene de la gui
        String baseCurrencyCode = "EUR";//borrador
        String targetCurrencyCode = "GBP";//borrador
        double amount = 15.0; // borrador
        double result;

        /****************************************************************/
        result = CurrencyCalculator.calculateConversion(baseCurrencyCode, targetCurrencyCode, amount);
        System.out.println(result);

    }
}
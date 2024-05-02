package com.vicv.model;

import com.google.gson.annotations.SerializedName;
import com.vicv.util.CurrencyCodes;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CurrencyConversion implements Serializable {
    @SerializedName("base_currency")
    private final CurrencyCodes baseCurrency;
    @SerializedName("target_currency")
    private final CurrencyCodes targetCurrency;
    @SerializedName("exchange_rate")
    private final double exchangeRate;
    @SerializedName("conversion_result")
    private final double conversionResult;
    @SerializedName("conversion_time")
    private final LocalDateTime conversionTime;

    public CurrencyConversion(CurrencyCodes baseCurrency, CurrencyCodes targetCurrency, double conversionResult, double exchangeRate, LocalDateTime conversionTime){
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.conversionResult = conversionResult;
        this.exchangeRate = exchangeRate;
        this.conversionTime = conversionTime;
    }

    public CurrencyCodes getBaseCurrency() {
        return this.baseCurrency;
    }
    public CurrencyCodes getTargetCurrency() {
        return this.targetCurrency;
    }
    public double getExchangeRate() {
        return this.exchangeRate;
    }
    public double getConversionResult() {
        return this.conversionResult;
    }
    public LocalDateTime getConversionTime() {
        return this.conversionTime;
    }

     @Override
    public String toString() {
        return "base_code: " +  this.getBaseCurrency() +
                "\ntarget_code: " + this.getTargetCurrency() +
                "\nexchange_rate: " + this.getExchangeRate() +
                "\nconversion_result: " + this.getConversionResult() +
                "\nconversion_time: " + this.getConversionTime();
     }
}

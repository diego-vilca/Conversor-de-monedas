package com.vicv.model;

import com.google.gson.annotations.SerializedName;
import com.vicv.util.CurrencyCode;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CurrencyConversion implements Serializable {
    @SerializedName("base_currency")
    private final CurrencyCode baseCurrency;
    @SerializedName("target_currency")
    private final CurrencyCode targetCurrency;
    @SerializedName("exchange_rate")
    private final double exchangeRate;
    @SerializedName("conversion_result")
    private final double conversionResult;
    @SerializedName("conversion_time")
    private final LocalDateTime conversionTime;

    public CurrencyConversion(CurrencyCode baseCurrency, CurrencyCode targetCurrency, double conversionResult, double exchangeRate, LocalDateTime conversionTime){
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.conversionResult = conversionResult;
        this.exchangeRate = exchangeRate;
        this.conversionTime = conversionTime;
    }

    public CurrencyCode getBaseCurrency() {
        return this.baseCurrency;
    }
    public CurrencyCode getTargetCurrency() {
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

package com.vicv.dto;

public record ExchangeRateDTO(String baseCode, String targetCode, double conversionRate) {
}

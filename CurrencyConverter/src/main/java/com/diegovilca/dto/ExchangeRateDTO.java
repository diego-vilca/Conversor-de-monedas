package com.diegovilca.dto;

public record ExchangeRateDTO(String baseCode, String targetCode, double conversionRate) {
}

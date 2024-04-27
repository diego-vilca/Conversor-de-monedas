package com.vicv.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vicv.dto.ExchangeRateDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private final HttpClient client;
    private final String baseCurrencyCode;
    private final String targetCurrencyCode;
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/dbc3723004e8007795fbca9e/pair/";

    public ExchangeRateClient(String baseCurrencyCode, String targetCurrencyCode){
        this.client = HttpClient.newHttpClient();
        this.baseCurrencyCode = baseCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
    }
    public ExchangeRateDTO Request() throws IOException, InterruptedException {
        String url = BASE_URL + baseCurrencyCode +"/"+ targetCurrencyCode;
        ExchangeRateDTO exchangeRateDTO;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        exchangeRateDTO = gson.fromJson(response.body(), ExchangeRateDTO.class);

        return exchangeRateDTO;
    }

}

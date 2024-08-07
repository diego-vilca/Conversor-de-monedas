package com.diegovilca.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.diegovilca.dto.ExchangeRateDTO;
import com.diegovilca.util.CommonConstants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class apiClient {
    private final String baseCurrencyCode;
    private final String targetCurrencyCode;
    private final static String BASE_URL = "https://v6.exchangerate-api.com/v6/" + CommonConstants.API_KEY;

    public apiClient(String baseCurrencyCode, String targetCurrencyCode){
        this.baseCurrencyCode = baseCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
    }
    public ExchangeRateDTO getRequest() throws IOException, InterruptedException {
        String url = BASE_URL +"/pair/"+ baseCurrencyCode +"/"+ targetCurrencyCode;
        ExchangeRateDTO exchangeRateDTO;
        HttpResponse<String> response = apiClient.performHttpGetRequest(url);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        exchangeRateDTO = gson.fromJson(response.body(), ExchangeRateDTO.class);

        return exchangeRateDTO;
    }

    public static HttpResponse<String> performHttpGetRequest(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

}

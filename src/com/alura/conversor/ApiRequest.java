package com.alura.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public Currency converter(String targetCurrency, int amount) {

        String baseCurrency = "CLP";
        URI uri =
                URI.create("https://v6.exchangerate-api.com/v6/f3834c6f13cbbf8b2f331e75/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Currency.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

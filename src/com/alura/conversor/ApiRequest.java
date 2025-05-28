package com.alura.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public Currency converter(Currency currency) {

        URI uri =
                URI.create("https://v6.exchangerate-api.com/v6/f3834c6f13cbbf8b2f331e75/pair/" + currency.getBase_code() +
                        "/" + currency.getTarget_code() + "/" + currency.getAmount());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            currency.setAmount(currency.getAmount());

            Currency currencyResult = new Gson().fromJson(response.body(), Currency.class);
            currencyResult.setAmount(currency.getAmount());

            return currencyResult;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}

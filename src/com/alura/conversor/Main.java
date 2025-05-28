package com.alura.conversor;

public class Main {
    public static void main(String[] args) {

        Menu menu =  new Menu();
        ApiRequest apiRequest = new ApiRequest();

        Currency currency = menu.showUserOption();

        Currency result = apiRequest.converter(currency);

        System.out.println(result);

    }
}

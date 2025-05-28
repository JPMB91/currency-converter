package com.alura.conversor;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    private void exhibirMenu() {

        System.out.println("""
                ************************************************
                               \s
                Sea bienvenido/a al conversor de monedas:
                               \s
                1) Dólar           =>> Peso Argentino
                2) Peso Argentino  =>> Dólar
                3) Dólar           =>> Real Brasileño
                4) Real Brasileño  =>> Dólar
                5) Dólar           =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Salir
                               \s
                Elija una opción valida de conversión
                ************************************************
               \s""");
    }

    private int userConversionOptions() {

        while (true) {
            exhibirMenu();
            int input = scanner.nextInt();

            if (input >= 1 && input < 8) {

                return input;

            } else {
                System.out.println("Ingrese una opción válida");
            }
        }

    }

    public Currency showUserOption(){

        String targetCurrency;
        String baseCurrency;

        int option = userConversionOptions();

        switch (option){
            case 1:
                targetCurrency = "ARS";
                baseCurrency = "USD";
                break;
            case 2:
                targetCurrency = "USD";
                baseCurrency = "ARS";
                break;
            case 3:
                targetCurrency = "RSD";
                baseCurrency = "USD";
                break;
            case 4:
                targetCurrency = "USD";
                baseCurrency = "RDS";
                break;
            case 5:
                targetCurrency = "COP";
                baseCurrency = "USD";
                break;
            case 6:
                targetCurrency = "USD";
                baseCurrency = "COP";
                break;

            default:
                throw new IllegalArgumentException("Opción no es válida");

        }

        System.out.println("Ingrese la cantidad a convertir");

        int amount = scanner.nextInt();

        scanner.close();
        return new Currency(baseCurrency, targetCurrency, amount);

    }
}

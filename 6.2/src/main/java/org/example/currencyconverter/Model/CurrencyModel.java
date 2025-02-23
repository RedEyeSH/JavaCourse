package org.example.currencyconverter.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyModel {
    private final HashMap<String, Double> currencyRates = new HashMap<>();

    public CurrencyModel() {
        currencyRates.put("EUR", 1.0); // Base Currency
        currencyRates.put("USD", 1.05);
        currencyRates.put("GBP", 0.83);
        currencyRates.put("INR", 90.58);
        currencyRates.put("AUD", 1.65);
    }

    public double getRate(String currency) {
        return currencyRates.getOrDefault(currency, 0.0);
    }

    public List<String> getAvailableCurrencies() {
        return new ArrayList<>(currencyRates.keySet());
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = getRate(fromCurrency);
        double toRate = getRate(toCurrency);
        return (amount / fromRate) * toRate;
    }
}

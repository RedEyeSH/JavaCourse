package org.example.currencyconverter.Controller;

import org.example.currencyconverter.Model.CurrencyModel;

import java.util.List;

public class CurrencyController {
    private final CurrencyModel model;

    public CurrencyController(CurrencyModel model) {
        this.model = model;
    }

    public double convertAmount(double amount, String fromCurrency, String toCurrency) {
        return model.convert(amount, fromCurrency, toCurrency);
    }

    public List<String> getAvailableCurrencies() {
        return model.getAvailableCurrencies();
    }
}

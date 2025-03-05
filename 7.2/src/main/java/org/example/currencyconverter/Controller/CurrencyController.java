package org.example.currencyconverter.Controller;

import org.example.currencyconverter.Dao.CurrencyDao;

public class CurrencyController {
    private final CurrencyDao currencyDao;

    public CurrencyController() {
        this.currencyDao = new CurrencyDao();
    }

    public String[] getAvailableCurrencies() {
        return currencyDao.getAllCurrencyAbbreviations().toArray(new String[0]);
    }

    public double convertAmount(double amount, String fromCurrency, String toCurrency) {
        double fromRate = currencyDao.getExchangeRate(fromCurrency);
        double toRate = currencyDao.getExchangeRate(toCurrency);

        if (fromRate == 0 || toRate == 0) {
            throw new IllegalArgumentException("Invalid currency conversion rates.");
        }

        return (amount / fromRate) * toRate;
    }
}

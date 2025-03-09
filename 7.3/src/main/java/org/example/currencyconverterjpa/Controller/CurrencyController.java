//package org.example.currencyconverterjpa.Controller;
//
//import org.example.currencyconverterjpa.Dao.CurrencyDao;
//
//public class CurrencyController {
//    private final CurrencyDao currencyDao;
//
//    public CurrencyController() {
//        this.currencyDao = new CurrencyDao();
//    }
//
//    public String[] getAvailableCurrencies() {
//        return currencyDao.getAllCurrencyAbbreviations().toArray(new String[0]);
//    }
//
//    public double convertAmount(double amount, String fromCurrency, String toCurrency) {
//        double fromRate = currencyDao.getExchangeRate(fromCurrency);
//        double toRate = currencyDao.getExchangeRate(toCurrency);
//
//        if (fromRate == 0 || toRate == 0) {
//            throw new IllegalArgumentException("Invalid currency conversion rates.");
//        }
//
//        return (amount / fromRate) * toRate;
//    }
//}

package org.example.currencyconverterjpa.Controller;

import org.example.currencyconverterjpa.Dao.CurrencyDao;
import org.example.currencyconverterjpa.Entity.Currency;
import java.util.List;

public class CurrencyController {
    private CurrencyDao currencyDao;

    public CurrencyController() {
        this.currencyDao = new CurrencyDao();
    }

    public double convertAmount(double amount, String fromAbbreviation, String toAbbreviation) {
        Currency fromCurrency = currencyDao.getCurrency(fromAbbreviation);
        Currency toCurrency = currencyDao.getCurrency(toAbbreviation);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency conversion rates.");
        }

        double rate = toCurrency.getExchangeRate() / fromCurrency.getExchangeRate();
        return amount * rate;
    }

    public List<Currency> getAllCurrencies() {
        return currencyDao.getAllCurrencies();
    }

    public void addNewCurrency(String abbreviation, String name, double exchangeRate) {
        currencyDao.insertCurrency(new Currency(abbreviation, name, exchangeRate));
    }
}

package Controller;

import Dao.CurrencyDao;
import Dao.TransactionDao;
import Entity.Currency;
import Entity.Transaction;

import java.util.List;

public class CurrencyController {
    private CurrencyDao currencyDao;
    private TransactionDao transactionDao;

    public CurrencyController() {
        this.currencyDao = new CurrencyDao();
        this.transactionDao = new TransactionDao();
    }

    public double convertAmount(double amount, String fromAbbreviation, String toAbbreviation) {
        Currency fromCurrency = currencyDao.getCurrency(fromAbbreviation);
        Currency toCurrency = currencyDao.getCurrency(toAbbreviation);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency conversion rates.");
        }

        double rate = toCurrency.getExchangeRate() / fromCurrency.getExchangeRate();
        double convertedAmount = amount * rate;

        Transaction transaction = new Transaction(fromCurrency, toCurrency, amount, convertedAmount);
        transactionDao.saveTransaction(transaction);

        return convertedAmount;
    }

    public List<Currency> getAllCurrencies() {
        return currencyDao.getAllCurrencies();
    }

    public void addNewCurrency(String abbreviation, String name, double exchangeRate) {
        currencyDao.insertCurrency(new Currency(abbreviation, name, exchangeRate));
    }
}

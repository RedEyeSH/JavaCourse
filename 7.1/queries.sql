USE CurrencyDB;

SELECT * FROM Currency;

SELECT * FROM Currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) FROM Currency;

SELECT * FROM Currency ORDER BY exchange_rate DESC LIMIT 1;
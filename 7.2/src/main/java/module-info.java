module org.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.currencyconverter to javafx.fxml;
    opens org.example.currencyconverter.Application;
    opens org.example.currencyconverter.Controller;
    opens org.example.currencyconverter.Dao;
    opens org.example.currencyconverter.DataSource;
    opens org.example.currencyconverter.Entity;
}
package org.example.currencyconverter.View;

import org.example.currencyconverter.Model.CurrencyModel;
import org.example.currencyconverter.Controller.CurrencyController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class CurrencyView extends Application {
    @Override
    public void start(Stage primaryStage) {
        CurrencyModel model = new CurrencyModel();
        CurrencyController controller = new CurrencyController(model);

        FlowPane layout = new FlowPane(15, 15);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label amountLabel = new Label("Amount to convert:");
        TextField amountField = new TextField();

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*\\.?\\d*")) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        amountField.setTextFormatter(textFormatter);

        TextField resultField = new TextField();
        resultField.setEditable(false);

        Label fromCurrency = new Label("From Currency:");
        ComboBox<String> fromCurrencyBox = new ComboBox<>();
        fromCurrencyBox.getItems().addAll(controller.getAvailableCurrencies());

        Label toCurrency = new Label("To Currency:");
        ComboBox<String> toCurrencyBox = new ComboBox<>();
        toCurrencyBox.getItems().addAll(controller.getAvailableCurrencies());

        Button convertButton = new Button("Convert");

        Label convertedAmount = new Label("Converted amount:");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        convertButton.setOnAction(event -> {
            String inputText = amountField.getText().trim();

            if (inputText.isEmpty()) {
                errorLabel.setText("Please enter an amount.");
                return;
            }

            try {
                double amount = Double.parseDouble(inputText);

                if (amount <= 0) {
                    errorLabel.setText("Amount must be greater than 0.");
                    return;
                }

                String fromCurrencyVal = fromCurrencyBox.getValue();
                String toCurrencyVal = toCurrencyBox.getValue();

                if (fromCurrencyVal == null || toCurrencyVal == null) {
                    errorLabel.setText("Please select both currencies.");
                    return;
                }

                double result = controller.convertAmount(amount, fromCurrencyVal, toCurrencyVal);
                resultField.setText(String.format("%.2f", result));
                errorLabel.setText("");
            } catch (NumberFormatException e) {
                errorLabel.setText("Invalid amount entered.");
            }
        });

        layout.getChildren().addAll(
                amountLabel,
                amountField,
                fromCurrency,
                fromCurrencyBox,
                toCurrency,
                toCurrencyBox,
                convertButton,
                convertedAmount,
                resultField,
                errorLabel
        );

        amountField.getStyleClass().add("text-field");
        resultField.getStyleClass().add("text-field");
        fromCurrencyBox.getStyleClass().add("combo-box");
        toCurrencyBox.getStyleClass().add("combo-box");
        convertButton.getStyleClass().add("button");
        errorLabel.getStyleClass().add("error-label");

        Scene startScene = new Scene(layout, 300, 450);
        startScene.getStylesheets().add("style.css");

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }
}

package Application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.CurrencyController;
import Entity.Currency;

import java.util.List;
import java.util.function.UnaryOperator;

public class CurrencyApp extends Application {
    private CurrencyController controller;

    public CurrencyApp() {
        this.controller = new CurrencyController();
    }

    @Override
    public void start(Stage primaryStage) {
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

        Label toCurrency = new Label("To Currency:");
        ComboBox<String> toCurrencyBox = new ComboBox<>();

        List<Currency> currencies = controller.getAllCurrencies();
        ObservableList<String> currencyOptions = FXCollections.observableArrayList();

        for (Currency currency : currencies) {
            currencyOptions.add(currency.getAbbreviation());
        }

        fromCurrencyBox.getItems().addAll(currencyOptions);
        toCurrencyBox.getItems().addAll(currencyOptions);


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

        Button addCurrencyButton = new Button("Add New Currency");
        addCurrencyButton.setOnAction(event -> {
            Stage newStage = new Stage();
            VBox currencyLayout = new VBox(15);

            currencyLayout.setStyle("-fx-padding: 15px;");

            Label abbreviationLabel = new Label("Abbreviation:");
            TextField abbreviationField = new TextField();
            VBox abbreviationBox = createVBox(abbreviationLabel, abbreviationField);

            abbreviationField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[a-zA-Z]{0,3}")) {
                    abbreviationField.setText(oldValue);
                }
            });

            Label nameLabel = new Label("Name:");
            TextField nameField = new TextField();
            VBox nameBox = createVBox(nameLabel, nameField);

            Label rateLabel = new Label("Exchange Rate:");
            TextField rateField = new TextField();
            VBox rateBox = createVBox(rateLabel, rateField);

            TextFormatter<String> textFormatterCurr = new TextFormatter<>(filter);
            rateField.setTextFormatter(textFormatterCurr);

            Button saveButton = new Button("Save");
            VBox saveButtonBox = new VBox(saveButton);

            abbreviationLabel.getStyleClass().add("label-add-currency");
            nameLabel.getStyleClass().add("label-add-currency");
            rateLabel.getStyleClass().add("label-add-currency");

            abbreviationField.getStyleClass().add("text-field-add-currency");
            nameField.getStyleClass().add("text-field-add-currency");
            rateField.getStyleClass().add("text-field-add-currency");

            saveButton.getStyleClass().add("button-add-currency");

            saveButton.setOnAction(saveEvent -> {
                String abbreviation = abbreviationField.getText().toUpperCase();
                String name = nameField.getText();
                double rate;

                try {
                    rate = Double.parseDouble(rateField.getText());
                } catch (NumberFormatException e) {
                    return;
                }

                controller.addNewCurrency(abbreviation, name, rate);
                List<Currency> updatedCurrencies = controller.getAllCurrencies();
                ObservableList<String> updatedOptions = FXCollections.observableArrayList();

                for (Currency currency : updatedCurrencies) {
                    updatedOptions.add(currency.getAbbreviation());
                }

                fromCurrencyBox.setItems(updatedOptions);
                toCurrencyBox.setItems(updatedOptions);

                newStage.close();
            });

            currencyLayout.getChildren().addAll(
                    abbreviationBox,
                    nameBox,
                    rateBox,
                    saveButtonBox
            );

            Scene newScene = new Scene(currencyLayout, 200, 225);
            newScene.getStylesheets().add("style.css");
            newStage.setScene(newScene);
            newStage.showAndWait();
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
                errorLabel,
                addCurrencyButton
        );

        amountField.getStyleClass().add("text-field");
        resultField.getStyleClass().add("text-field");
        fromCurrencyBox.getStyleClass().add("combo-box");
        toCurrencyBox.getStyleClass().add("combo-box");
        convertButton.getStyleClass().add("button");
        errorLabel.getStyleClass().add("error-label");

        Scene startScene = new Scene(layout, 300, 540);
        startScene.getStylesheets().add("style.css");

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    private VBox createVBox(Label label, TextField textField) {
        VBox vbox = new VBox(label, textField);
        vbox.setStyle("-fx-background-color: #050816;");
        return vbox;
    }
}

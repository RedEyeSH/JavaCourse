package org.example.javafxcourse.View;

import org.example.javafxcourse.Controller.DictionaryController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    @Override
    public void start(Stage primaryStage) {
        DictionaryController controller = new DictionaryController();

        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        controller.addNewWord("java", "A high-level programming language.");
        controller.addNewWord("python", "A popular programming language known for its readability.");
        controller.addNewWord("html", "The standard markup language for creating web pages.");

        searchButton.setOnAction(event -> {
            String word = wordInput.getText();

            if (word.isEmpty()) {
                resultLabel.setText("Your input is empty. Please enter a word.");
            } else {
                String meaning = controller.searchWord(word);
                resultLabel.setText(meaning);
            }
        });

        FlowPane layout = new FlowPane(10, 10);
        layout.getChildren().addAll(wordInput, searchButton, resultLabel);

        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dictionary App");

        primaryStage.show();
    }
}

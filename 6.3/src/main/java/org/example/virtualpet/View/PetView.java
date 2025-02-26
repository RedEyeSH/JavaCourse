package org.example.virtualpet.View;

import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.virtualpet.Controller.PetController;

public class PetView extends Application {
    private static final int CELL_SIZE = 20;

    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image petImage;

    @Override
    public void init() {
        controller = new PetController(this);
        petImage = new Image(getClass().getResource("/pet.jpg").toExternalForm());
    }
    @Override
    public void start(Stage primaryStage) {
        int gridSize = controller.getGridSize();
        int canvasSize = gridSize * CELL_SIZE;

        canvas = new Canvas(canvasSize, canvasSize);
        gc = canvas.getGraphicsContext2D();

        StackPane layout = new StackPane(canvas);
        Scene scene = new Scene(layout, 400, 400);

        layout.setStyle("-fx-background-color: black");

        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateCanvas(controller.getX(), controller.getY());

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            controller.handleMove(x, y);

            System.out.printf("Mouse moved to (%.2f, %.2f)\n", x, y);
        });

        canvas.setOnMouseExited(event -> {
            controller.stopPet();
        });
    }

    public void updateCanvas(double petX, double petY) {
        Platform.runLater(() -> {
            int gridSize = controller.getGridSize();
            int canvasSize = gridSize * CELL_SIZE;

            gc.clearRect(0, 0, canvasSize, canvasSize);

            gc.setFill(Color.DARKGRAY);
            gc.fillRect(0, 0, canvasSize, canvasSize);

            double imageX = petX - (CELL_SIZE / 2);
            double imageY = petY - (CELL_SIZE / 2);

            gc.drawImage(petImage, imageX, imageY, CELL_SIZE, CELL_SIZE);

        });
    }
}

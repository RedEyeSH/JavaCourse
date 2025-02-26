package org.example.virtualpet.Controller;

import javafx.animation.AnimationTimer;
import org.example.virtualpet.Model.Pet;
import org.example.virtualpet.View.PetView;

public class PetController {
    private final Pet pet;
    private final PetView view;
    private boolean isMoving;
    private double targetX, targetY;

    private final AnimationTimer animationTimer;

    public PetController(PetView view) {
        this.pet = new Pet(50, 50);
        this.view = view;

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePosition();
            }
        };
    }

    public void handleMove(double mouseX, double mouseY) {
        targetX = mouseX;
        targetY = mouseY;

        if (!isMoving) {
            isMoving = true;
            animationTimer.start();
        }
    }

    private void updatePosition() {
        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < 1) {
            isMoving = false;
            animationTimer.stop();
            return;
        }

        double speed = 0.1;
        double newX = pet.getX() + dx * speed;
        double newY = pet.getY() + dy * speed;

        pet.move(newX - pet.getX(), newY - pet.getY());

        view.updateCanvas(pet.getX(), pet.getY());
    }

    public void stopPet() {
        isMoving = false;
        animationTimer.stop();
    }

    public double getX() {
        return pet.getX();
    }

    public double getY() {
        return pet.getY();
    }

    public int getGridSize() {
        return pet.getGridSize();
    }
}

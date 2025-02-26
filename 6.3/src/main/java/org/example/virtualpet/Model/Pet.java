package org.example.virtualpet.Model;

public class Pet {
    private double x;
    private double y;
    private static final int GRID_SIZE = 10;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }
}

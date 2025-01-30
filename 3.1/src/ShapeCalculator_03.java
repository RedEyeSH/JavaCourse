// 3.1 - Task 03

class Shape {
    public double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}

public class ShapeCalculator_03 {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8)

        };

        System.out.println("Shape calculator\n");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Area of Circle with radius " + ((Circle) shape).getRadius() + ": " + shape.calculateArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Area of Rectangle with width " + ((Rectangle) shape).getWidth() + " and height " + ((Rectangle) shape).getHeight() + ": " + shape.calculateArea());
            } else if (shape instanceof Triangle) {
                System.out.println("Area of Triangle with base " + ((Triangle) shape).getBase() + " and height " + ((Triangle) shape).getHeight() + ": " + shape.calculateArea());
            }
        }
    }
}

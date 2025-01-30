// 3.1 - Task 04

class Shape_04 {
    private final String color;

    public Shape_04(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0;
    }

    public String getColor() {
        return color;
    }
}

class Circle_04 extends Shape_04 {
    private final double radius;

    public Circle_04(double radius, String color) {
        super(color);
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

class Rectangle_04 extends Shape_04 {
    private final double width;
    private final double height;

    public Rectangle_04(double width, double height, String color) {
        super(color);
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

class Triangle_04 extends Shape_04 {
    private final double base;
    private final double height;

    public Triangle_04(double base, double height, String color) {
        super(color);
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

public class ShapeProperties_04 {
    public static void main(String[] args) {
        Shape_04[] shapes = {
            new Circle_04(5, "Blue"),
            new Rectangle_04(4, 6, "Red"),
            new Triangle_04(3, 8, "Green")
        };

        System.out.println("Shape calculator\n");
        for (Shape_04 shape : shapes) {
            if (shape instanceof Circle_04) {
                System.out.println("Shape color: " + shape.getColor());
                System.out.println("Area of Circle with radius " + ((Circle_04) shape).getRadius() + ": " + shape.calculateArea() + "\n");
            } else if (shape instanceof Rectangle_04) {
                System.out.println("Shape color: " + shape.getColor());
                System.out.println("Area of Rectangle with width " + ((Rectangle_04) shape).getWidth() + " and height " + ((Rectangle_04) shape).getHeight() + ": " + shape.calculateArea() + "\n");
            } else if (shape instanceof Triangle_04) {
                System.out.println("Shape color: " + shape.getColor());
                System.out.println("Area of Triangle with base " + ((Triangle_04) shape).getBase() + " and height " + ((Triangle_04) shape).getHeight() + ": " + shape.calculateArea() + "\n");
            }
        }
    }
}

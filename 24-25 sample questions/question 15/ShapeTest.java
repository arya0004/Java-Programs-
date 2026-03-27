import java.util.Scanner;

// Shape interface
interface Shape {
    void draw(); // Method to draw the shape
    double calculateArea(); // Method to calculate area of the shape
}

// Circle class implementing Shape interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Area = π * r^2
    }
}

// Rectangle class implementing Shape interface
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " + width);
    }

    @Override
    public double calculateArea() {
        return length * width; // Area = length * width
    }
}

// Triangle class implementing Shape interface
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with base: " + base + " and height: " + height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // Area = 0.5 * base * height
    }
}

// Test class to demonstrate the functionality
public class ShapeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Drawing a Circle
        System.out.print("Enter the radius of the Circle: ");
        double circleRadius = scanner.nextDouble();
        Shape circle = new Circle(circleRadius);
        circle.draw();
        System.out.println("Circle Area: " + circle.calculateArea());

        // Drawing a Rectangle
        System.out.print("Enter the length of the Rectangle: ");
        double rectangleLength = scanner.nextDouble();
        System.out.print("Enter the width of the Rectangle: ");
        double rectangleWidth = scanner.nextDouble();
        Shape rectangle = new Rectangle(rectangleLength, rectangleWidth);
        rectangle.draw();
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        // Drawing a Triangle
        System.out.print("Enter the base of the Triangle: ");
        double triangleBase = scanner.nextDouble();
        System.out.print("Enter the height of the Triangle: ");
        double triangleHeight = scanner.nextDouble();
        Shape triangle = new Triangle(triangleBase, triangleHeight);
        triangle.draw();
        System.out.println("Triangle Area: " + triangle.calculateArea());

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}

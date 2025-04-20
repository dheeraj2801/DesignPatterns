package SOLIDPrinciples.OpenClosedPrinciple;
//    ✅ Fix - Use Polymorphism

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

public class WithOCP {
    public static void main(String[] args) {
        Shape circle = new Circle(50);
        Shape rectangle = new Rectangle(20, 30);
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println("Circle Area: " + areaCalculator.calculateArea(circle));
        System.out.println("Rectangle Area: " + areaCalculator.calculateArea(rectangle));
    }
}

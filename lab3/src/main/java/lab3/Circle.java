package lab3;

public class Circle extends Shape {
    double radius;

    public Circle(String circleColor, double radius) {
        super(circleColor);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw circle: " + this);
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle area: " + String.format("%.2f", calcArea()) + "; " + super.toString() +
                "; radius: " + String.format("%.2f", radius);
    }
}

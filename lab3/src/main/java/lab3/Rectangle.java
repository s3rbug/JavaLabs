package lab3;

public class Rectangle extends Shape {
    double height, width;

    public Rectangle(String rectangleColor, double height, double width) {
        super(rectangleColor);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Draw rectangle: " + this);
    }

    @Override
    public double calcArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle area: " +
                String.format("%.2f", calcArea()) + "; " +
                super.toString() + "; height: " +
                String.format("%.2f", height) + ", width: " +
                String.format("%.2f", width);
    }
}

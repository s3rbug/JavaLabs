package lab3;

public class Triangle extends Shape {
    double sideA, sideB, sideC;

    public Triangle(String triangleColor, double sideA, double sideB, double sideC) {
        super(triangleColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void draw() {
        System.out.println("Draw triangle: " + this);
    }

    @Override
    public double calcArea() {
        double semiPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    @Override
    public String toString() {
        return "Triangle area: " + String.format("%.2f", calcArea()) + "; " +
                super.toString() + "; sides: " +
                String.format("%.2f", sideA) + ", " +
                String.format("%.2f", sideB) + ", " +
                String.format("%.2f", sideC);
    }
}

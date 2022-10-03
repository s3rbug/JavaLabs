package lab3;

import java.util.ArrayList;
import java.util.Comparator;

public class ShapesModel {
    private final ArrayList<Shape> shapes;

    ShapesModel(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    ArrayList<Shape> getShapes() {
        return shapes;
    }

    double getSumOfAllAreas() {
        double sumOfAllAreas = 0;
        for (Shape shape : shapes) {
            sumOfAllAreas += shape.calcArea();
        }
        return sumOfAllAreas;
    }

    double getSumOfCustomAreas(String shapeTypeToCalculateArea) {
        double sumOfCustomAreas = 0;
        for (Shape shape : shapes) {
            if (shapeTypeToCalculateArea.equalsIgnoreCase("Rectangle")) {
                if (shape.getClass() == Rectangle.class) {
                    sumOfCustomAreas += shape.calcArea();
                }
            } else if (shapeTypeToCalculateArea.equalsIgnoreCase("Triangle")) {
                if (shape.getClass() == Triangle.class) {
                    sumOfCustomAreas += shape.calcArea();
                }
            } else if (shapeTypeToCalculateArea.equalsIgnoreCase("Circle")) {
                if (shape.getClass() == Circle.class) {
                    sumOfCustomAreas += shape.calcArea();
                }
            } else {
                return -1;
            }
        }
        return sumOfCustomAreas;
    }

    void sortByArea() {
        shapes.sort(Comparator.comparing(Shape::calcArea));
    }

    void sortByColor() {
        shapes.sort(Comparator.comparing(Shape::getShapeColor));
    }

    void draw(int index) {
        shapes.get(index).draw();
    }
}

package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name if you want to load shapes from that file or hit Enter to load default values: ");
        String inputFilename = scanner.nextLine();
        ArrayList<Shape> shapes;
        if (inputFilename.equals("")) {
            shapes = generateShapes();
        } else {
            try {
                shapes = Shape.readArrayListFromFile(inputFilename);
            } catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
        ShapesModel model = new ShapesModel(shapes);
        ShapesView view = new ShapesView();
        ShapesController controller = new ShapesController(model, view);
        System.out.print("Enter shape to calculate their area (Circle, Triangle, Rectangle): ");
        String shapeTypeToCalculateArea = scanner.nextLine();
        controller.printSumOfAllAreas();
        controller.printSumOfCustomAreas(shapeTypeToCalculateArea);
        System.out.println("\tDefault order:");
        controller.printShapes();
        System.out.println("\tSorted by area:");
        controller.sortByArea();
        controller.printShapes();
        System.out.println("\tSorted by color:");
        controller.sortByColor();
        controller.printShapes();
        System.out.println("\tDraw first element:");
        controller.draw(0);
        System.out.print("Enter file name if you want to save shapes to file or hit Enter to skip: ");
        String outputFilename = scanner.nextLine();
        if (!outputFilename.equals("")) {
            try {
                Shape.writeArrayListToFile(shapes, outputFilename);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static ArrayList<Shape> generateShapes() {
        return new ArrayList<>(
                Arrays.asList(
                        new Circle("red", 5),
                        new Circle("green", 6),
                        new Circle("coral", 7),
                        new Circle("black", 8),
                        new Circle("pink", 9),
                        new Triangle("gold", 3, 4, 5),
                        new Triangle("cyan", 6, 8, 10),
                        new Triangle("indigo", 9, 12, 15),
                        new Triangle("crimson", 12, 16, 20),
                        new Triangle("gray", 15, 20, 25),
                        new Rectangle("blue", 5, 10),
                        new Rectangle("yellow", 10, 15),
                        new Rectangle("chocolate", 15, 10),
                        new Rectangle("violet", 25, 5),
                        new Rectangle("brown", 20, 10)
                ));
    }
}
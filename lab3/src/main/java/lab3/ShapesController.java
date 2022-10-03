package lab3;

public class ShapesController {
    private final ShapesModel model;
    private final ShapesView view;

    public ShapesController(ShapesModel model, ShapesView view) {
        this.model = model;
        this.view = view;
    }

    public void printSumOfAllAreas() {
        view.printSumOfAllAreas(model.getSumOfAllAreas());
    }

    public void printSumOfCustomAreas(String shapeTypeToCalculateArea) {
        double sumOfCustomAreas = model.getSumOfCustomAreas(shapeTypeToCalculateArea);
        if (sumOfCustomAreas != -1) {
            view.printSumOfCustomAreas(model.getSumOfCustomAreas(shapeTypeToCalculateArea), shapeTypeToCalculateArea);
        } else {
            view.printError(shapeTypeToCalculateArea + " is unknown shape, can not calculate sum of custom areas");
        }
    }

    public void sortByArea() {
        model.sortByArea();
    }

    public void sortByColor() {
        model.sortByColor();
    }

    public void printShapes() {
        view.printShapes(model.getShapes());
    }

    public void draw(int index) {
        try {
            model.draw(index);
        } catch (Exception e) {
            view.printError(e.getMessage());
        }
    }
}

package Cages;

import Animals.Animal;
import Animals.Hoofed;

public class HoofedCage extends MammalCage {
    public HoofedCage(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    public boolean checkIfCorrectAnimal(Animal animal) {
        return animal instanceof Hoofed;
    }
}

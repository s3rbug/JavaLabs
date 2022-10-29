package Cages;

import Animals.Animal;
import Animals.Lion;

public class LionCage extends MammalCage {
    public LionCage(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    boolean checkIfCorrectAnimal(Animal animal) {
        return animal instanceof Lion;
    }
}

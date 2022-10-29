package Cages;

import Animals.Animal;
import Animals.Bird;

public class BirdCage extends Cage<Bird> {
    public BirdCage(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    public boolean checkIfCorrectAnimal(Animal animal){
        return animal instanceof Bird;
    }
}

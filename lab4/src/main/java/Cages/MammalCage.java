package Cages;

import Animals.Mammal;

abstract public class MammalCage extends Cage<Mammal> {

    MammalCage(int maxCapacity) {
        super(maxCapacity);
    }
}

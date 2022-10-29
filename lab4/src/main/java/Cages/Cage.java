package Cages;

import Animals.Animal;

import java.util.ArrayList;

abstract public class Cage<T extends Animal> {
    private final int maxCapacity;
    private final ArrayList<T> animals = new ArrayList<>();

    Cage(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public int getCountAnimals(){
        return animals.size();
    }

    public void addAnimal(T animal) throws Exception {
        if (this.getCountAnimals() == this.getMaxCapacity()) {
            throw new Exception("Cages.Cage is full");
        }
        if(!checkIfCorrectAnimal(animal)){
            throw new Exception("Wrong animal type");
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) throws Exception {
        boolean removed = animals.remove(animal);
        if(!removed) {
            throw new Exception("Animals.Animal not found");
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(T animal: animals){
            str.append(animal.toString()).append("\n");
        }
        return str.toString();
    }

    abstract boolean checkIfCorrectAnimal(Animal animal);
}

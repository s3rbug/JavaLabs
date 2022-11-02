import Animals.*;
import Cages.*;
import Zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle("Eagle", 10, 10);
        Lion lion = new Lion("Lion", 10, 10);
        Zebra zebra = new Zebra("Zebra", 10, 10);
        Giraffe giraffe = new Giraffe("Giraffe", 10, 10);

        BirdCage birdCage = new BirdCage(2);
        LionCage lionCage = new LionCage(2);
        HoofedCage hoofedCage = new HoofedCage(3);
        try {
            birdCage.addAnimal(eagle);
            lionCage.addAnimal(lion);
            hoofedCage.addAnimal(zebra);
            Zoo zoo = new Zoo();
            birdCage.removeAnimal(eagle);
            zoo.addCage(birdCage);
            zoo.addCage(lionCage);
            zoo.addCage(hoofedCage);
            System.out.print(zoo);
            System.out.println("Count of animals in zoo: " + zoo.getCountOfAnimals());
        } catch (Exception e) {
            System.out.println("[ERROR] - " + e.getMessage());
        }
    }
}
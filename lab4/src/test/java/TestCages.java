import Animals.*;
import Cages.*;
import Zoo.Zoo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCages {
    Zoo zoo;
    Eagle eagle;
    Lion lion;
    Zebra zebra;
    Giraffe giraffe;
    BirdCage birdCage;
    LionCage lionCage;
    HoofedCage hoofedCage;
    @Before
    public void init(){
        eagle = new Eagle("Eagle", 10, 10);
        lion = new Lion("Lion", 10, 10);
        zebra = new Zebra("Zebra", 10, 10);
        giraffe = new Giraffe("Giraffe", 10, 10);
        birdCage = new BirdCage(2);
        lionCage = new LionCage(2);
        hoofedCage = new HoofedCage(3);
        zoo = new Zoo();
    }
    @Test
    public void addingCagesToZoo() throws Exception {
        lionCage.addAnimal(lion);
        hoofedCage.addAnimal(zebra);
        hoofedCage.addAnimal(giraffe);
        zoo.addCage(birdCage);
        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        assertEquals(3, zoo.getCountOfAnimals());
    }

    @Test
    public void addingWrongAnimalToCageShouldThrowException(){
        Exception exception = assertThrows(Exception.class, () -> hoofedCage.addAnimal(lion));
        assertEquals("Wrong animal type", exception.getMessage());
    }
    @Test
    public void addingAnimalToHoofedCage() throws Exception {
        hoofedCage.addAnimal(zebra);
        assertEquals(3, hoofedCage.getMaxCapacity());
        assertEquals(1, hoofedCage.getCountAnimals());
    }

    @Test
    public void addingAnimalToBirdCage() throws Exception {
        birdCage.addAnimal(eagle);
        assertEquals(2, birdCage.getMaxCapacity());
        assertEquals(1, birdCage.getCountAnimals());
    }

    @Test
    public void addingAnimalToLionCage() throws Exception {
        lionCage.addAnimal(lion);
        assertEquals(2, lionCage.getMaxCapacity());
        assertEquals(1, lionCage.getCountAnimals());
    }
}

package Animals;

public class Hoofed extends Mammal {

    Hoofed(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString(){
        return "Animals.Hoofed: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

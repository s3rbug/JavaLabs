package Animals;

public abstract class Mammal extends Animal {
    Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString(){
        return "Animals.Mammal: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

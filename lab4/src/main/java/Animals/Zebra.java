package Animals;

public class Zebra extends Hoofed {
    public Zebra(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString(){
        return "Animals.Zebra: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

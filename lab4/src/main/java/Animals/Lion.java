package Animals;

public class Lion extends Mammal {

    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString(){
        return "Animals.Lion: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

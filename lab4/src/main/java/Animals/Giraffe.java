package Animals;

public class Giraffe extends Hoofed {
    public Giraffe(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public String toString(){
        return "Animals.Giraffe: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

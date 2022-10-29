package Animals;

public class Bird extends Animal {
    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public String toString(){
        return "Animals.Bird: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

package Animals;

public class Eagle extends Bird {

    public Eagle(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString(){
        return "Animals.Eagle: name - " + name + "; age - " + age + "; weight - " + weight;
    }
}

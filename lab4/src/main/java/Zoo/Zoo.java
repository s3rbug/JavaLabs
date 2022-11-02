package Zoo;

import Animals.Animal;
import Cages.Cage;

import java.util.ArrayList;

public final class Zoo {
    public ArrayList<Cage<? extends Animal>> cages = new ArrayList<>();
    public int getCountOfAnimals(){
        int sum = 0;
        for(Cage<? extends Animal> cage: cages){
            sum += cage.getCountAnimals();
        }
        return sum;
    }
    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < cages.size(); ++i){
            str.append("Cages.Cage №")
                    .append(i + 1)
                    .append(":\n")
                    .append(cages.get(i).toString())
                    .append("\n");
        }
        return str.toString();
    }
}

import java.util.Arrays;
import java.util.Objects;

import com.google.gson.Gson;

public final class Person {
    final String name;
    static Gson gson;
    final int age;
    final double height;
    final boolean isMarried;
    final String[] friends;

    Person(String name, int age, double height, boolean isMarried, String[] friends) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isMarried = isMarried;
        this.friends = friends;
        gson = new Gson();
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        Person person = (Person) object;
        return Objects.equals(this.age, person.age)
                && Objects.equals(this.height, person.height)
                && Objects.equals(this.name, person.name)
                && Objects.equals(this.isMarried, person.isMarried)
                && Arrays.equals(this.friends, person.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, height, name, isMarried, Arrays.hashCode(friends));
    }
    String toJson() {
        return gson.toJson(this);
    }

    Person getFromJson(String json) {
        return gson.fromJson(json, Person.class);
    }

    void print() {
        System.out.print("\tName: " + this.name +
                "\n\tAge: " + this.age +
                "\n\tHeight: " + this.height +
                "\n\tMarried: " + (this.isMarried ? "yes" : "no") +
                "\n\tFriend list: ");
        if(this.friends.length == 0){
            System.out.println("this person has no friends(");
        }
        for(String friend: this.friends){
            System.out.print(friend + " ");
        }
        System.out.println();
    }
}

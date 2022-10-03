public class Main {
    public static void main(String[] args) {
        Person jack = new Person(
                "Jack",
                23,
                175.5,
                false,
                new String[]{"Frank", "Ann"});
        String json = jack.toJson();
        System.out.println("Initial Person object:");
        jack.print();
        System.out.println("Json object: " + json);
        Person jackFromJson = jack.getFromJson(json);
        System.out.println("Object from json:");
        jackFromJson.print();
        if(jack.equals(jackFromJson)){
            System.out.println("Object from json and initial are equal");
        }
        else{
            System.out.println("Object from json and initial are not equal");
        }
    }
}
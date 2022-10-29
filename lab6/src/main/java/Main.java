import Translation.Translation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translation translation = new Translation();
        translation.add("when", "коли");
        translation.add("I", "я");
        translation.add("met", "зустрів");
        translation.add("you", "тебе");

        String answer = "y";
        while(answer.equalsIgnoreCase("y")){
            System.out.print("Do you want to enter new word to dictionary? (y/n): ");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("y")){
                translation.addUsingKeyboard(scanner);
            }
        }
        try {
            System.out.print("Enter phrase to translate: ");
            String phrase = scanner.nextLine();
            System.out.println(translation.translate(phrase));
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
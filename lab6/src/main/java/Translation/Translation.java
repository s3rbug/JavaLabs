package Translation;

import java.util.HashMap;
import java.util.Scanner;

public class Translation {
    HashMap<String, String> dictionary;
    public Translation(){
        dictionary = new HashMap<>();
    }
    Translation(HashMap<String, String> dictionary){
        this.dictionary = dictionary;
    }
    public void add(String word, String translation){
        dictionary.put(word, translation);
    }
    public void addUsingKeyboard(Scanner scanner){
        System.out.print("Enter English word: ");
        String word = scanner.nextLine();
        System.out.print("Enter its translation: ");
        String translation = scanner.nextLine();
        this.add(word, translation);
    }
    public String translate(String phrase) throws Exception{
        String[] words = phrase.trim().split("[\\s,.:;-]+");
        String[] punctuation = phrase.split("[a-zA-z]+");
        StringBuilder translation = new StringBuilder();
        for(int i = 0; i < words.length; ++i){
            if(dictionary.containsKey(words[i])){
                translation.append(punctuation[i]).append(dictionary.get(words[i]));
            }
            else {
                throw new Exception("Unknown word: " + words[i]);
            }
        }
        return translation.toString();
    }
}

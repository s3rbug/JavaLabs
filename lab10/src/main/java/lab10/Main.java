package lab10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseString;
        System.out.print("Do you want to enter base string using keyboard? (y/n): ");
        char askSymbol;
        try {
            askSymbol = scanner.nextLine().charAt(0);
        }
        catch (IndexOutOfBoundsException e){
            askSymbol = 'n';
        }
        if (askSymbol == 'y') {
            System.out.print("Base string: ");
            baseString = scanner.nextLine();
        } else {
            baseString = "Old one";
        }
        System.out.print("Do you want to enter changed string using keyboard? (y/n): ");
        try {
            askSymbol = scanner.nextLine().charAt(0);
        }
        catch (IndexOutOfBoundsException e){
            askSymbol = 'n';
        }
        byte[] changedBaseString;
        if (askSymbol == 'y') {
            System.out.print("Changed string: ");
            changedBaseString = scanner.nextLine().getBytes();
        } else {
            changedBaseString = new byte[]{'N', 'e', 'w', ' ', 'O', 'n', 'e'};
        }

        try {
            Class<?> stringClass = String.class;
            Class<?>[] paramsType = new Class<?>[]{String.class};
            Constructor<?> constructor = stringClass.getConstructor(paramsType);
            String stringObject = (String) constructor.newInstance(baseString);
            System.out.println("Before change: " + stringObject);
            Field valueField = stringClass.getDeclaredField("value");
            // VM option needed to run: --add-opens java.base/java.lang=ALL-UNNAMED
            valueField.setAccessible(true);
            valueField.set(stringObject, changedBaseString);
            System.out.println("After change: " + stringObject);

        } catch (NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
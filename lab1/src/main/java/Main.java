import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long n;
        System.out.print("Enter max integer to look for perfect numbers: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        System.out.print("Perfect numbers less or equal than " + n + ":");
        for(long i = 2; i <= n; ++i){
            if(PerfectNumber.isPerfectNumber(i)){
                System.out.print(" " + i);
            }
        }
    }
}
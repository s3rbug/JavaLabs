import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long n;
        System.out.print("Enter max integer to look for perfect numbers: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        System.out.print("Perfect numbers less or equal than " + n + ":");
        PerfectNumber functionalObject = (long number) -> {
            long i, sum = 1;
            for(i = 2; i * i < number; ++i){
                if(number % i == 0){
                    sum += i + number / i;
                }
            }
            if(i * i == number){
                sum += i;
            }
            return sum == number;
        };

        for(long i = 2; i <= n; ++i){
            if(functionalObject.isPerfectNumber(i)){
                System.out.print(" " + i);
            }
        }
    }
}
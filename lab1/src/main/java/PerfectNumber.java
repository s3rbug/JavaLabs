public final class PerfectNumber {
    public static long sumOfDivisors(long number){
        long i, sum = 1;
        for(i = 2; i * i < number; ++i){
            if(number % i == 0){
                sum += i + number / i;
            }
        }
        if(i * i == number){
            sum += i;
        }
        return sum;
    }
    public static boolean isPerfectNumber(long number){
        return sumOfDivisors(number) == number;
    }
}

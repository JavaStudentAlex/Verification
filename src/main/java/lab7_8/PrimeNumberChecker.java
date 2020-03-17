package lab7_8;

public class PrimeNumberChecker {

    public static boolean isPrime(final int primeNumber){
        int floored_sqrt = (int) Math.floor(Math.sqrt(primeNumber));
        for(int i = 2; i<floored_sqrt; ++i){
            if (primeNumber % i == 0){
                return false;
            }
        }
        return true;
    }
}

package lab7_8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
    private int primeVal;
    private boolean isPrime;

    public PrimeNumberCheckerTest(int primeVal, boolean isPrime){
        this.primeVal = primeVal;
        this.isPrime = isPrime;
    }

    @Parameterized.Parameters
    public static Collection getParams(){
        return Arrays.asList(new Object[][] {
                {17, true},
                {27, false},
                {19, true},
                {23, true}
        });
    }

    @Test
    public void isPrimeCheck() {
        assertEquals(isPrime, PrimeNumberChecker.isPrime(primeVal));
    }
}
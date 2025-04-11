package testing;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class FibonacciTheoriesTest {

    @DataPoints
    public static int[] fibonacciNumbers = {0, 1, 2, 3, 5, 8, 13, 21}; 
    @DataPoints
    public static int[] nonFibonacciNumbers = {4, 6, 7, 9, 10, 12, 15};

    @DataPoints
    public static int[] negativeNumbers = {-1, -5, -8}; 

    @Theory
    public void testFibonacciTrue(int num) {
        assumeTrue(contains(fibonacciNumbers, num));
        assertTrue(FibonacciSeries.fibonacciCheaker(num));
    }

    @Theory
    public void testFibonacciFalse(int num) {
        assumeTrue(contains(nonFibonacciNumbers, num));
        assertFalse(FibonacciSeries.fibonacciCheaker(num));
    }

    @Theory
    public void testNegativeNumbers(int num) {
        assumeTrue(contains(negativeNumbers, num));
        try {
            FibonacciSeries.fibonacciCheaker(num);
            fail("Expected IllegalArgumentException for input: " + num);
        } catch (IllegalArgumentException e) {
            
        }
    }

    private boolean contains(int[] array, int target) {
        for (int i : array) {
            if (i == target) return true;
        }
        return false;
    }
}

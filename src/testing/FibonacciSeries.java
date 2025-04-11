package testing;

public class FibonacciSeries {

    public static boolean fibonacciCheaker(int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException();
        }

        int firstTerm = 0;
        int secondTerm = 1;
        int thirdTerm = 0;

        while (thirdTerm < inputNumber) {
            thirdTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }

        return thirdTerm == inputNumber;
    }
}

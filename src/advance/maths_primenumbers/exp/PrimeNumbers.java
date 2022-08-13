package advance.maths_primenumbers.exp;

import advance.TimeCalculator;
public class PrimeNumbers {

    public static void main(String[] args) {
        int A = 198888787;
        System.out.println(isPrime3(A));
    }

    public static boolean isPrime1(int A) {
        TimeCalculator.getCurrentTime();
        boolean res = true;
        for (int i = 2; i<A; i++) {
            if (A % i == 0) {
                res = false;
                break;
            }
        }
        TimeCalculator.printDuration();
        return res;
    }
    public static boolean isPrime2(int A) {
        TimeCalculator.getCurrentTime();
        boolean res = true;
        for (int i = 2; i<=A/2; i++) {
            if (A % i == 0) {
                res = false;
                break;
            }
        }
        TimeCalculator.printDuration();
        return res;
    }

    public static boolean isPrime3(int A) {
        TimeCalculator.getCurrentTime();
        boolean res = true;
        for (int i = 2; i*i<=A; i++) {
            int i1 = A/i;
            if (A % i == 0 || A % i1 == 0) {
                res = false;
                break;
            }
        }
        TimeCalculator.printDuration();
        return res;
    }
}

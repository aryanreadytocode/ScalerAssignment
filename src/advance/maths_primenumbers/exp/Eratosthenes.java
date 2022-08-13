package advance.maths_primenumbers.exp;

import java.util.Arrays;

/*
* Find all the prime numbers between 1 to N.
* */
public class Eratosthenes {

    public static void main(String[] args) {
        int A = 1;
        int B = 10000;
        System.out.println(Arrays.toString(primes(A, B)));

    }

    public static int[] primes(int A, int B) {
        // find the max element and create array of one more length
        int length = Math.max(A, B);
        int primeCount = 0;
        int[] isPrime = new int[length+1];
        for (int i = 2; i<=length; i++) {
            if (isPrime[i] == 0) {  //2
                for (int j = i*i; j<=length; j+=i) { //j = 4, 6, 8,10, 12
                    if (isPrime[j] == 0) {
                        isPrime[j] = 1; //isPrime[4] = 1;
                        primeCount++;
                    }
                }
            }
        }
        int[] res = new int[(length-1)-primeCount];
        int count1 = 0;
        for (int k = 2; k<=length; k++) {
            if(isPrime[k] == 0){
                res[count1] = k;
                count1++;
            }
        }
        return res;

    }
}

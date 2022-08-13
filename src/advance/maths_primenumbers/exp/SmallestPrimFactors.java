package advance.maths_primenumbers.exp;

import java.util.Arrays;

/*
* Find the smallest prime factors of all numbers between 2 to N.
* */
public class SmallestPrimFactors {

    public static void main(String[] args) {
        int A = 2;
        int B = 10;
        System.out.println(Arrays.toString(smallestPrimeFactors(A, B)));
    }

    public static int[] smallestPrimeFactors(int A, int B) {
        int length = Math.max(A, B);
        int[] spf = new int[length+1];
        int count = 0;
        for (int i = 2; i<=length; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                count++;
                for (int j = i*i; j<=length; j +=i) {
                    if (spf[j] == 0){
                        spf[j] = i;
                        count++;
                    }
                }
            }
        }
        int count1 = 0;
        int[] res = new int[count];
        for (int i = 0; i<spf.length; i++) {
            if (spf[i] != 0){
                res[count1] = spf[i];
                count1++;
            }
        }
        return res;
    }
}

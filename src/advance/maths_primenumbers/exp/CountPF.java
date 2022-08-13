package advance.maths_primenumbers.exp;

import java.util.Arrays;

/* Find the prime factorization of N*/
public class CountPF {

    public static void main(String[] args) {
        int A = 8;
        System.out.println((primeFact(A)));
    }

    public static int[] primeFact1(int[] A) {
        int[] res = new int[A.length];
        int[] spf = buildSPF1(A);
        for (int i = 0; i < A.length; i++) {
            int ele = A[i];
            while (ele > 1) {
                int p = spf[ele];
                res[i]++;
                ele /= p;
            }
        }
        return res;
    }

    public static int primeFact(int A) {
        int[] spf = buildSPF(A);
        int count = 0;
        for (int i = 0; i <= A; i++) {
            int ele = i;
            while (ele > 1) {
                int p = spf[ele];
                    count++;
                    ele /= p;
            }
        }
        return count;
    }

    public static int[] buildSPF1(int[] A) {

        int length = findLength(A);
        int[] spf = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                for (int j = i * i; j <= length; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
    public static int[] buildSPF(int A) {

        int length = (A);
        int[] spf = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                for (int j = i * i; j <= length; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    private static int findLength(int[] a) {
        int maxValue = Integer.MIN_VALUE;
        for (int j = 0; j < a.length; j++) {
            if (maxValue < a[j])
                maxValue = a[j];
        }
        return maxValue;
    }
}

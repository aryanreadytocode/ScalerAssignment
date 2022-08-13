package advance.sorting3.exp;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] A = {213, 97, 718, 123, 37, 443, 982, 64, 375, 683, 0, 1};
        System.out.println(Arrays.toString(radixSort(A)));
    }

    public static int[] radixSort(int[] A) {
         int exp = 1;
         int max = Integer.MIN_VALUE;
         for (int i = 0; i<A.length; i++) {
             if (A[i] > max)
                 max = A[i];
         }

         while (exp <= max) {
             countSort(A, exp);
             exp *= 10;
         }
         return A;
    }

    private static void countSort(int[] A, int exp) {
        int[] freqArr = new int[19];
        // fill the frequency array
        for (int i = 0; i<A.length; i++) {
            int val = A[i] / exp % 10;
            freqArr[val]++;
        }
        // create prefix sum array for frequency array
        for (int i = 1; i<freqArr.length; i++) {
            freqArr[i] += freqArr[i-1];
        }
        int[] ans = new int[A.length];
        for (int i = A.length-1; i>=0; i--) {
            int val = A[i]/exp%10;
            int pos = freqArr[val] - 1;
            ans[pos] = A[i];
            freqArr[val]--;
        }

        for (int i = 0; i<A.length; i++) {
            A[i] = ans[i];
        }
    }
}

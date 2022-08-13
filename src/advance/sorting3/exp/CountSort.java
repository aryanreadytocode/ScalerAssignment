package advance.sorting3.exp;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] A = {1, 0, 5, 4, 3, 0, 4};
        System.out.println(Arrays.toString(countSort(A)));
    }

    public static int[] countSort(int[] A) {
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;
        for (int i =0; i<A.length; i++) {
            if (A[i] < minEle)
                minEle = A[i];
            else if (A[i] > maxEle) {
                maxEle = A[i];
            }
        }
        int length = (maxEle-minEle+1);
        int[] freqArray = new int[length];
        //store the frequency of the element in frequency array
        for (int i = 0; i<A.length; i++) {
            int index = A[i] - minEle;
            freqArray[index]++;
        }
        //create prefix sum array
        for (int i = 1; i<freqArray.length; i++) {
            freqArray[i] = freqArray[i-1] + freqArray[i];
        }


        int[] ans = new int[A.length];
        for (int i = A.length-1; i>=0; i--) {
            int val = A[i];
            int pos = freqArray[val - minEle];
            int idx = pos - 1;
            ans[idx] = val;
            freqArray[val-minEle]--;
        }

        for (int i = 0; i<ans.length; i++) {
            A[i] = ans[i];
        }
        return A;
    }
}

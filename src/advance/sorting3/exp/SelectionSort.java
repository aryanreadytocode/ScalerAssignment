package advance.sorting3.exp;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {213, 97, 718, 123, 37, 443, 982, 64, 375, 683, 0, 1};
        System.out.println(Arrays.toString(selectionSort(A)));
    }

    public static int[] selectionSort(int[] A) {
        for (int i = 1; i<A.length; i++) {
            int impIndex = i;
            while (impIndex>=1 && A[impIndex] < A[impIndex-1] ) {
                int temp = A[impIndex];
                A[impIndex] = A[impIndex-1];
                A[impIndex-1] =temp;
                impIndex--;
            }
        }
        return A;
    }
}

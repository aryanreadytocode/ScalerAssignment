package advance.sorting1.exp;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] A = {3, -1, 6, 9, 4, 2, 5, 4};
        System.out.println(Arrays.toString(sort(A)));
    }

    public static int[] sort(int[] A) {
        int length = A.length;

        for (int i = 0; i<length-1; i++) {
            for (int j = 0; j<length-1; j++) {
                if (A[j+1] < A[j]) {
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }
}

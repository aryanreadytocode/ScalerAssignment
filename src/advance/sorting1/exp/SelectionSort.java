package advance.sorting1.exp;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {7, 5, 4, 10, 1, 20};
        System.out.println(Arrays.toString(selectionSortAsc(A)));
    }

    public static int findKthMin(int[] A, int k) {
        int minValue = 0;
        int minIndex = 0;
        int length = A.length;
        for (int i = 0; i<k ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j<length; j++) {
                if (A[j]<=min){
                    min = A[j];
                    minIndex = j;
                }

            }
            swap(A, i, minIndex);
            minValue = min;
        }
        return minValue;
    }

    private static void swap(int[] arr, int to, int from) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int[] selectionSortAsc(int[] A) {
        for (int i = 0; i<A.length-1; i++) {
            for (int j = i+1; j<A.length; j++) {
                if (A[j]<= A[i]) {
                    swap(A, i, j);
                }
            }
        }
        return A;
    }
}

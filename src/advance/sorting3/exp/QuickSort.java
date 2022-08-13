package advance.sorting3.exp;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {10, 3, 8, 15, 6,12,2,18,7,15,14, 8, 0, 88, 98, 75,3,8568, 5747, 4, 0};
        quickSort(A, 0, A.length-1);
        for (int i = 0; i< A.length; i++) {
            System.out.print(A[i]+" ");
        }

    }

    private static void quickSort(int[] A, int start, int end) {
        if (start>end)
            return;
        if (start == end)
            return;
        int pivot = rearrange(A, start, end);
        quickSort(A, start, pivot-1);
        quickSort(A, pivot+1, end);
    }

    private static int rearrange(int[] A, int start, int end) {
        int pivot = A[start];
        int left = start+1;
        int right = end;
        while (left <= right) {
            if (A[left] <= pivot)
                left++;
            else if (A[right] > pivot)
                right--;
            else {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        A[start] = A[left-1];
        A[left-1] = pivot;
        return left-1;
    }
}

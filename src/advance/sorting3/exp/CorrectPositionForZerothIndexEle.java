package advance.sorting3.exp;

import java.util.Arrays;

/*
* Given unsorted Array
* 1. Place A[0] at it's correct place
* 2. All element <= A[0] should be on it's left
* 3. All elements >A[0] should be on it's right*/
public class CorrectPositionForZerothIndexEle {

    public static void main(String[] args) {
        int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 15};
        System.out.println(Arrays.toString(rearrange(A)));
    }

    /*this will take extra space which is 0(N)*/
    private static int[] solve(int[] A) {
        int length = A.length;
        int indexElement = A[0];
        int[] res = new int[length];
        int index = 0;
        for (int i = 1; i <length; i++) {
            if (A[i] <= indexElement){
                res[index] = A[i];
                index++;
            }
        }
        res[index] = indexElement;
        index++;

        for (int i = 1; i < length; i++) {
            if (A[i] > indexElement){
                res[index] = A[i];
                index++;
            }
        }

        return res;

    }

    /*This will not take extra space Sc- constant*/
    public static int[] rearrange(int[] A) {
        int pivot = A[0];
        int left = 1;
        int right = A.length-1;
        while (left < right) {
            if (A[left] <pivot)
                left++;
            else if (A[right] > pivot)
                right--;
            else {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }

        }
        A[0] = A[left-1];
        A[left-1] = pivot;
        return A;
    }
}

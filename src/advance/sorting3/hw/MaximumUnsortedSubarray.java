package advance.sorting3.hw;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
//        int[] arr = {4, 15, 15, 4, 4, 15, 18, 20};
        int[] arr = {1,2,3};
//        int[] arr = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};
        System.out.println(Arrays.toString(subUnsort(arr)));
    }

    /*We need to compare from start and end
    * from start we should check condition like next element should less than current element and store the indes
    * and for equal element we need to consider minimum index of duplicate element for that we have defined a variable which count
    * no of duplicate val*/
    public static int[] subUnsort(int[] A) {
        int i = 0;
        int j = A.length-1;
        while (i<A.length-1 && A[i] <= A[i+1]) {
            i++;
        }
        while (j>0 && A[j] >= A[j-1]) {
            j--;
        }
        if (i == A.length-1)
            return new int[]{-1};
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int k = i; k<=j; k++) {
            minLeft = Math.min(minLeft, A[k]);
            maxRight = Math.max(maxRight, A[k]);
        }
        int left = 0;
        int right = A.length-1;
        while (left <= i && A[left] <= minLeft){
            left++;
        }
        while (right >= j && A[right] >= maxRight) {
            right--;
        }
        return new int[]{left, right};

    }
    public static int[] subUnsort1(int[] A) {
        int starIndex = Integer.MAX_VALUE;
        int endIndex = Integer.MIN_VALUE;
        for (int i = 1; i<A.length; i++) {
            int impInd = i;
            while(impInd>=1 && A[impInd] < A[impInd-1]) {
                int temp = A[impInd];
                A[impInd] = A[impInd-1];
                A[impInd-1] = temp;
                starIndex = Math.min(starIndex, impInd-1);
                endIndex = Math.max(endIndex, impInd);
                impInd--;
            }
        }
        if(starIndex == Integer.MAX_VALUE )
            return new int[]{-1};
        return new int[]{starIndex, endIndex};
    }
}

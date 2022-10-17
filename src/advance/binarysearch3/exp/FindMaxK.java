package advance.binarysearch3.exp;

import java.rmi.dgc.VMID;

/*
* Given an array of the integers. Find the maximum K such that:
* every subarray of size K has the sum <= B.
* EX- A = {3, 2, 5, 4, 6, 3, 7, 2}, B = 20
* */
public class FindMaxK {

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 4, 6, 3, 7, 2};
        int B = 15;
        int maxK = findK(A, B);
        System.out.println("Max: "+ maxK);
    }

    private static int findK(int[] arr, int B) {
        int ans = 1;
        int min = 0;
        int max = arr.length-1;
        while (min <= max) {
            int middle = min + (max - min)/2;
            boolean isFeasible = checkFeasibility(arr, B, middle+1);
            if (isFeasible) {
                ans = Math.max(ans, middle+1);
                min = middle + 1;
            }else {
                max = middle - 1;
            }
        }
        return ans;
    }

    private static boolean checkFeasibility(int[] arr, int B, int middle) {
        int sum = 0;
        for (int index = 0; index < middle; index++) {
            sum += arr[index];
        }
        if (sum > B) {
            return false;
        }
        for (int index = middle; index < arr.length; index++) {
            sum = sum + arr[index] - arr[index - (middle)];
            if (sum > B)
                return false;
        }
        return true;
    }
}

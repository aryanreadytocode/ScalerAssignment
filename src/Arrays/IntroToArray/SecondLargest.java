package Arrays.IntroToArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/*
* Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.



Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109



Input Format
The first argument is an integer array A.



Output Format
Return the second largest element. If no such element exist then return -1.



Example Input
Input 1:

 A = [2, 1, 2]
Input 2:

 A = [2]


Example Output
Output 1:

 2
Output 2:

 -1


Example Explanation
Explanation 1:

 First largest element = 2
 Second largest element = 2
 Third largest element = 1
Explanation 2:

 There is no second largest element in the array.
* */
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,3,5, -42, 8, 45, 3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(3);
//        list.add(5);
//        list.add(-42);
//        list.add(8);
//        list.add(45);
//        list.add(3);
//        System.out.println("Second Largest NO: "+ secondLargestNo(arr));
        System.out.println("Second Largest NO: "+ solve(list));
    }

    public static int solve(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        if (A.size()==1 || A.isEmpty())
            return -1;
        return A.get(A.size()-2);
    }

    private static int secondLargestNo(int[] arr) {
        int secondMax = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i= 0; i< arr.length-1 ; i++) {
            for (int j = i+1; j<arr.length; j++) {
                int sumed = arr[i]+arr[j];
                if (sumed>sum) {
                    sum = sumed;
                    secondMax = arr[i]<arr[j]?arr[i]:arr[j];
                }
            }
        }
        return secondMax;
    }
}

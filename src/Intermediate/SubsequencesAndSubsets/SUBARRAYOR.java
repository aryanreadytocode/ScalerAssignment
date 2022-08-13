package Intermediate.SubsequencesAndSubsets;

import java.util.ArrayList;
import java.util.Collections;

/*
* Problem Description
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
The first argument given is the integer array A.



Output Format
Return the sum of Value of all subarrays of A % 109 + 7.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110


Example Explanation
Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.
* */
public class SUBARRAYOR {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(new SUBARRAYOR().solve (al));
    }

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int sum = 0;
        ArrayList<ArrayList<Integer>> parAl = new ArrayList<>();
        for (int i = 0; i<Math.pow(2,  n); i++) {
            int orVal = 0;
            for (int j= 0; j<n && j <= i; j++) {
                if(checkBit(i, j))
                    orVal = orVal | A.get(j);
            }
            sum = sum + orVal;
        }
        return sum;
    }

    public boolean checkBit(int i, int j) {
        return ((i & (1<<j)) > 0);
    }
}

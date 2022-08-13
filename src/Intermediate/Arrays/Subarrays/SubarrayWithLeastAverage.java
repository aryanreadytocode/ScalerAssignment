package Intermediate.Arrays.Subarrays;

import java.util.ArrayList;

/*
* Problem Description
Given an array of size N, Find the subarray with least average of size k.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.


Output Format
Return the index of the first element of the subarray of size k that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3
Input 2:

A=[3, 7, 5, 20, -10, 0, 12]
B=2


Example Output
Output 1:
3
Output 2:

4


Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average
* */
public class SubarrayWithLeastAverage {

    public static void main(String[] args) {
        int[] A = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11 };
        int B = 9;
        System.out.println(new SubarrayWithLeastAverage().solve1(A, B));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int min = 0;
        for (int i = 0; i < B; i++) {
            min += A.get(i);
        }
        int leastIndex = 0;
        int i = 1;
        int j = i+B-1;
        int minCur = min;
        while (j < A.size()) {
            minCur = minCur - A.get(i - 1) + A.get(j);
            if (min/B>minCur/B) {
                min = minCur;
                leastIndex = i;
            }
            i++;
            j++;
        }
        return leastIndex;
    }

    public int solve1(int[] A, int B) {
        int min = 0;
        for (int i = 0; i < B; i++) {
            min += A[i];
        }
        int leastIndex = 0;
        int i = 1;
        int j = i+B-1;
        int minCur = min;
        while (j < A.length ){
            minCur = minCur - A[i-1] + A[j];
            System.out.println("Min Current: "+minCur/3+" Min "+min/3 +" index"+i);
            if (min/B>minCur/B) {
                min = minCur;
                leastIndex = i;
                System.out.println("Index : "+leastIndex);
            }
            i++;
            j++;
        }
        return leastIndex;
    }
}

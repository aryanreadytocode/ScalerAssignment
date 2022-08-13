package Intermediate.Arrays.PrefixSum;

import java.util.ArrayList;

/*Problem Description

Given an integer array A of size N. In one second you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.


Problem Constraints

1 <= N <= 1000000
1 <= A[i] <= 1000


Input Format

First argument is an integer array A.


Output Format

Return an integer denoting the minimum time to make all elements equal.


Example Input

A = [2, 4, 1, 3, 2]


Example Output

8


Example Explanation

We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
*/
public class TimeToEquality {
    public static void main(String[] args) {
        /* [2, 4, 1, 3, 2]*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(new TimeToEquality().solve(list));
    }

    public int solve(ArrayList<Integer> A) {
        //find the maximum no
        int maxValue = Integer.MIN_VALUE;
        for (Integer integer : A) {
            if (maxValue < integer)
                maxValue = integer;
        }
        int noOfSec = 0;
        for (Integer integer : A) {
            noOfSec += maxValue - integer;
        }
        return noOfSec;
    }
}
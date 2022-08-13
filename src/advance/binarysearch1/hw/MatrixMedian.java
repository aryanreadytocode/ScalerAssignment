package advance.binarysearch1.hw;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
*
* Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of matrix A.



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5
Output 2:

 17


Example Explanation
Explanation 1:

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.
Explanation 2:

Median is 17.*/
public class MatrixMedian {
    public static void main(String[] args) {
       /* int[][] mat =  {{1, 3, 5},
                        {2, 6, 9},
                        {3, 6, 9}};*/
        int[][] mat = {{5}};
        int median = findMedian(mat);
        System.out.println("Median:"+ median);
    }

    // naive method to solve the problelm
    public static int findMedian(int[][] A) {
        int rowSize = A.length;
        int columnSize = A[0].length;
        int newArrayIndex = 0;
        int[] array = new int[(rowSize * columnSize)];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                array[newArrayIndex] = A[row][column];
                newArrayIndex++;
            }
        }
        Arrays.sort(array);
        int medianIndex = ((rowSize * columnSize) - 1) / 2;
        return array[medianIndex];
    }
}

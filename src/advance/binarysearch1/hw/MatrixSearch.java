package advance.binarysearch1.hw;

/*
* Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A else, return 0.



Example Input
Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
* */
public class MatrixSearch {

    public static void main(String[] args) {
        int[][] A = {{2, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 50}};

        /*int[][] A = {{1, 4, 5, 5, 6, 14, 14, 16, 19},
                    {22, 24, 28, 33, 35, 37, 38, 40, 41},
                    {45, 50, 52, 55, 56, 56, 57, 60, 60},
                    {63, 64, 66, 68, 68, 71, 78, 78, 79},
                    {84, 89, 90, 91, 93, 94, 94, 97, 98}};*/
//        int[][] A = {{3}, {29}, {36}, {63}, {67}};
        int B = 1;
        boolean isThere = searchMatrix(A, B) == 1;
        System.out.println(B+" is present :"+isThere);
    }

    public static int searchMatrix(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int start = 0;
        int end = row-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid][0] > B)
                end = mid-1;
            else if (A[mid][0] < B)
                start = mid +1;
            else
                return 1;

        }
        row = start - 1;
        start = 0;
        end = col - 1;
        while (row>=0 && start <= end) {
            int mid = start + (end - start)/2;
            if (A[row][mid]== B)
                return  1;
            else if (A[row][mid] < B)
                start = mid + 1;
            else
                end = mid -1;
        }
        return 0;
    }
}

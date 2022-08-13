package Intermediate.Arrays.twodmetrices;

import java.util.ArrayList;

/*
* Problem Description

You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M)). You have to subtract matrix A from B and return the resultant matrix. (i.e. return the matrix A - B).

If X and Y are two matrices of the same order (same dimensions). Then X - Y is a matrix of the same order as X and Y and its elements are obtained by subtracting the elements of Y from the corresponding elements of X. Thus if Z = [z[i][j]] = X - Y, then [z[i][j]] = [x[i][j]] – [y[i][j]].



Problem Constraints

1 <= N, M <= 103

-109 <= A[i][j], B[i][j] <= 109



Input Format

First argument is a 2D integer matrix A.

Second argument is a 2D integer matrix B.



Output Format

Return a 2D matrix denoting A - B.



Example Input

Input 1:

 A = [[1, 2, 3],            B = [[9, 8, 7],
      [4, 5, 6],                 [6, 5, 4],
      [7, 8, 9]]                 [3, 2, 1]]
Input 2:

 A = [[1, 1]]               B = [[2, 3]]


Example Output

Output 1:

 [[-8, -6, -4],
  [-2, 0, 2],
  [4, 6, 8]]
Output 2:

 [[-1, -2]]


Example Explanation

Explanation 1:

 image
Explanation 2:

 [[1, 1]] - [[2, 3]] = [[1 - 2, 1 - 3]] = [[-1, -2]]
* */

/*
[21, 62, 16, 44, 55, 100, 16, 86, 29]
  [62, 72, 85, 35, 14, 1, 89, 15, 73]
  [42, 44, 30, 56, 25, 52, 61, 23, 54]
  [5, 35, 12, 35, 55, 74, 50, 50, 80]
  [2, 65, 65, 82, 26, 36, 66, 60, 1]
  [18, 1, 16, 91, 42, 11, 72, 97, 35]
  [23, 57, 9, 28, 13, 44, 40, 47, 98]

* [21 62 42 5 2 18 23 ]
* [62 72 44 35 65 1 57 ]
* [16 85 30 12 65 16 9 ]
* [44 35 56 35 82 91 28 ]
* [55 14 25 55 26 42 13 ]
* [100 1 52 74 36 11 44 ]
* [16 89 61 50 66 72 40 ]
* [86 15 23 50 60 97 47 ]
* [29 73 54 80 1 35 98 ]
 * *
   [21 62 16 44 55 100 16 86 29 ]
 * [62 72 85 35 14 1 89 15 73 ]
 * [42 44 30 56 25 52 61 23 54 ]
 * [5 35 12 35 55 74 50 50 80 ]
 * [2 65 65 82 26 36 66 60 1 ]
 * [18 1 16 91 42 11 72 97 35 ]
 * [23 57 9 28 13 44 40 47 98 ]

 * /
 */
public class MatrixSubtraction {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.get(i).size(); j++) {
                int sum = A.get(i).get(j) - B.get(i).get(j);
                row.add(sum);
            }
            resultMatrix.add(row);
        }
        return resultMatrix;
    }
}

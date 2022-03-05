package Arrays.twodmetrices;

import java.util.ArrayList;

/*
* You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

image



Problem Constraints

1 <= M, N, P <= 100

-100 <= A[i][j], B[i][j] <= 100



Input Format

First argument is a 2D integer matrix A.

Second argument is a 2D integer matrix B.



Output Format

Return a 2D integer matrix denoting AB.



Example Input

Input 1:

 A = [[1, 2],            B = [[5, 6],
      [3, 4]]                 [7, 8]]
Input 2:

 A = [[1, 1]]            B = [[2],
                              [3]]


Example Output

Output 1:

 [[19, 22],
  [43, 50]]
Output 2:

 [[5]]


Example Explanation

Explanation 1:

 image
Explanation 2:

 [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
* */

public class MatrixMultiplication {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (ArrayList<Integer> integers : A) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < B.get(0).size(); j++) {
                int sum = 0;
                for (int k = 0; k < A.get(0).size(); k++) {
                    sum += integers.get(k) * B.get(k).get(j);
                }
                row.add(sum);
            }
            res.add(row);
        }
        return res;
    }
}

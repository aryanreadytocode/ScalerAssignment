package Arrays.twodmetrices;

import java.util.ArrayList;
/*
* Problem Description
You are given two matrices A & B of equal dimensions and you have to check whether two matrices are equal or not.

NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.



Problem Constraints
1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000



Input Format
First argument is vector of vector of integers representing matrix A.

Second argument is vector of vector of integers representing matrix B.



Output Format
Return 1 if both matrices are equal or return 0.



Example Input
Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

==> Clearly all the elements of both matrices are equal at respective positions.
Explanation 2:

==> Clearly all the elements of both matrices are not equal at respective positions.
* */
public class AreMatricesSame {
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        if(A.size()==B.size()){
            for(int i = 0; i< A.size(); i++){
                if(A.get(i).size() == B.get(i).size()){
                    for(int j= 0; j<A.get(i).size(); j++){
                        if(A.get(i).get(j)!=B.get(i).get(j))
                            return 0;
                    }
                }else {
                    return 0;
                }
            }
        }else{
            return 0;
        }
        return 1;
    }
}

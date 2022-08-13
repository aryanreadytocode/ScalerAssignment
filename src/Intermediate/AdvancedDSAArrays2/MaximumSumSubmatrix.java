package Intermediate.AdvancedDSAArrays2;
/*
* Problem Description
Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.


Problem Constraints
1 <= N, M <= 300
-104 <= A[i][j] <= 104


Input Format
The first argument is a 2D Integer array A.


Output Format
Return the sum of the maximum sum sub-matrix from matrix A.


Example Input
Input 1:-
    -6 -6
   -29 -8
A =  3 -8
   -15  2
    25 25
    20 -5
Input 2:-
A = -17 -2
     20 10


Example Output
Output 1:-
65
Output 2:-
30


Example Explanation
Explanation 1:-
The submatrix
25 25
20 -5
has the highest submatrix sum 65.
Explanation 2:-
The submatrix
20 10
has the highest sub matrix sum 30.
* */
public class MaximumSumSubmatrix {

    public static void main(String[] args) {

    }

    static int[][] getPrefixSumMatrix(int[][] A){
        int N=A.length;
        int M=A[0].length;
        int[][] psa=new int[N+1][M+1];
        for(int i=1;i<psa.length;i++){
            for(int j=1;j<psa[0].length;j++){
                psa[i][j]= A[i-1][j-1]+psa[i-1][j]+psa[i][j-1]-psa[i-1][j-1] ;
            }
        }
        return psa;
    }

    public int solve(int[][] A, int B) {
        int maxsum=Integer.MIN_VALUE;
        int[][]pf= getPrefixSumMatrix(A);
        for(int i=1;i<pf.length;i++){
            int sum=Integer.MIN_VALUE;
            for(int j=1;j<pf[0].length;j++){
                if(i-B>=0 && j-B>=0){
                    sum=pf[i][j]-pf[i-B][j]-pf[i][j-B]+pf[i-B][j-B];
                    maxsum=Math.max(sum,maxsum);
                }
            }
        }
        return maxsum;
    }
}

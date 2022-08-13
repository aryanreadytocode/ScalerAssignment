package Intermediate.Arrays.twodmetrices;

import java.util.ArrayList;
/*
* Problem Description

You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.



Problem Constraints

1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000



Input Format

First argument is vector of vector of integers representing matrix A.

Second argument is vecotor of vector of integers representing matrix B.



Output Format

You have to return a vector of vector of integers after doing required operations.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]


Example Output

Output 1:

[[10, 10, 10], [10, 10, 10], [10, 10, 10]]


Example Explanation

Explanation 1:

A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
* */
public class AddTheMatrices {

    public static void main(String[] args) {
        int[][] A = {{6}, {2}, {3}, {10}, {1}, {3}};
        int[][] B = {{6}, {7}, {3}, {8}, {1}, {2}};
        System.out.println(new AddTheMatrices().solve1(A, B));
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A,
                                               ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.get(i).size(); j++) {
                int sum = A.get(i).get(j) + B.get(i).get(j);
                row.add(sum);
            }
            resultMatrix.add(row);
        }
        return resultMatrix;
    }

    public ArrayList<ArrayList<Integer>> solve1(int[][] A,
                                                int[][] B) {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A[i].length; j++) {
                int sum = A[i][j] + B[i][j];
                row.add(sum);
            }
            resultMatrix.add(row);
        }
        return resultMatrix;
    }
}

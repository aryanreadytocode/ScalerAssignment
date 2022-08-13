package Intermediate.Arrays.twodmetrices;

import java.util.ArrayList;
/*
* Problem Description

You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103



Input Format

First argument is a vector of vector of integers.(2D matrix).



Output Format

Return a vector conatining column-wise sums of original matrix.
* */
public class ColumnSum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int rowSize = A.size();
        ArrayList<Integer> resultArray = new ArrayList<>();
        for(int j = 0; j<A.get(0).size(); j++){
            int sum = 0;
            for (ArrayList<Integer> integers : A) {
                sum += integers.get(j);
            }
            resultArray.add(sum);
        }
        return resultArray;
    }
}

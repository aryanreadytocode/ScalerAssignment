package Arrays.twodmetrices;

import java.util.ArrayList;

/*
* Problem Description

You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103



Input Format

First argument is a vector of vector of integers.(2D matrix).



Output Format

Return a vector of vector after doing required operations.



Example Input

Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]


Example Output

Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]


Example Explanation

Explanation 1:

A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
* */
public class RowToColumnZero {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> rowIndex = new ArrayList<>();
        ArrayList<Integer> columnIndex = new ArrayList<>();
        for(int i = 0; i<A.size(); i++){
            for(int  j=0; j<A.get(i).size(); j++){
                if(A.get(i).get(j)==0){
                    rowIndex.add(i);
                    columnIndex.add(j);
                }
            }
        }

        for(int i1 = 0; i1<A.size(); i1++){
            if(rowIndex.contains(i1)){
                for(int j1=0; j1<A.get(i1).size(); j1++){
                    A.get(i1).set(j1, 0);
                }
            }else{
                for(int j1=0; j1<A.get(i1).size(); j1++){
                    if(columnIndex.contains(j1))
                        A.get(i1).set(j1,0);
                }
            }
        }

        return A;
    }

}

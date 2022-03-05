package Arrays.twodmetrices;

import java.util.ArrayList;

/*
* Problem Description

You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints

1 <= n <= 1000



Input Format

First argument is a 2D matrix A of integers



Output Format

Return the 2D rotated matrix.
* */
class RotateMatrix {

    public void solve(ArrayList<ArrayList<Integer>> A) {
        //find  transpose of matrix
        for(int i =0; i<A.size()-1; i++){
            for(int j= i+1; j<A.size(); j++){
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);
            }
        }

        int left = 0;
        int right = A.get(0).size()-1;
        while(left<right) {
            for (ArrayList<Integer> integers : A) {
                int temp = integers.get(left);
                integers.set(left, integers.get(right));
                integers.set(right, temp);
            }
            left++;
            right--;
        }
    }
}

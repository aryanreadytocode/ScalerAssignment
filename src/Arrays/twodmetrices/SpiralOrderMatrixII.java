package Arrays.twodmetrices;

import java.util.ArrayList;

/*
* Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:


Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
* */
public class SpiralOrderMatrixII {

    public static void main(String[] args) {
        System.out.println(new SpiralOrderMatrixII().generateMatrix(1));
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for(int i = 0; i<A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                row.add(0);
            }
            matrix.add(row);
        }
        int count=1;
        int i = 0;
        int j = 0;
        while(A>1) {
            for(int k = 1; k<=A-1; k++) {
                matrix.get(i).set(j,count);
                j++;
                count++;
            }
            for(int k=1; k<=A-1; k++) {
                matrix.get(i).set(j,count);
                i++;
                count++;
            }
            for(int k=1; k<=A-1; k++) {
                matrix.get(i).set(j,count);
                j--;
                count++;
            }
            for(int k=1; k<=A-1; k++) {
                matrix.get(i).set(j,count);
                i--;
                count++;
            }
            A -= 2;
            j++;
            i++;
        }

        if(A==1){
            matrix.get(i).set(j, count);
        }
        return matrix;

    }

}

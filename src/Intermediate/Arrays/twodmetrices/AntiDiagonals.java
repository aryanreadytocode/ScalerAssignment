package Intermediate.Arrays.twodmetrices;

import java.util.ArrayList;

/*
* Problem Description

Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints

1<= N <= 1000
1<= A[i][j] <= 1e9


Input Format

First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.


Output Format

Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input

Input 1:
3
1 2 3
4 5 6
7 8 9
Input 2:

1 2
3 4


Example Output

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:

1 0
2 3
4 0


Example Explanation

For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
For input 2:

The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
* */
public class AntiDiagonals {

    public static void main(String[] args) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();
        ArrayList<Integer> row3 = new ArrayList<>();
        ArrayList<Integer> row4 = new ArrayList<>();
        row.add(1);
        row.add(2);
        row.add(3);
        row2.add(4);
        row2.add(5);
        row2.add(6);
        row3.add(7);
        row3.add(8);
        row3.add(9);
        row4.add(10);
        row4.add(11);
        row4.add(12);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(row);
        A.add(row2);
        A.add(row3);
        A.add(row4);
        System.out.println(new AntiDiagonals().diagonal1(A));

    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int sizeOfMat = A.size();  //3
        for (int j = 0; j < sizeOfMat; j++) {
            int i = 0;
            ArrayList<Integer> row = new ArrayList<>();
            int jmid = j;
            while (i < sizeOfMat) { //[0,0], [1,-1], [2,-2]
                if (j < 0)
                    row.add(0);
                else
                    row.add(A.get(i).get(j));
                j--;
                i++;
            }
            j = jmid;
            result.add(row);
        }

        for (int i1 = 1; i1 < sizeOfMat; i1++) { //[1,2] [2,1][3,0], [2,2][3,1][4,0], [][][][
            ArrayList<Integer> row = new ArrayList<>();
            int j1 = sizeOfMat - 1;
            int imid = i1;
            while (j1 >= 0) {
                if (i1 >= sizeOfMat)
                    row.add(0);
                else
                    row.add(A.get(i1).get(j1));
                i1++;
                j1--;
            }
            i1 = imid;
            result.add(row);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> diagonal1(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<>();
            int k=0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for(int j = k; j< l ;j++){
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }
}

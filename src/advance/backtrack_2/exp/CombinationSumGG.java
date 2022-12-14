package advance.backtrack_2.exp;

import java.util.ArrayList;

public class CombinationSumGG {



    int a[][], targetSum;
    int col[], rowSize, colSize;

    public static void main(String[] args) {

        int A = 5;
        int[][] B = {
                {16, -20, 44, -46, -85, -96, 89},
                {60, -96, -67, -33, 91, 27, 58},
                {26, 90, -80, -39, 47, -42, 64}
        };
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int[] row : B) {
            ArrayList<Integer> al1 = new ArrayList<>();
            for (int col : row) {
                al1.add(col);
            }
            al.add(al1);
        }
        int C = 86;

        int result = new CombinationSumGG().solve(A, B, C);
        System.out.println("Result : " + (result == 1));
    }


    boolean check(int colTempSize, int rowTempSize, int op_left, int rsum) {
        if (rsum > targetSum) return false;
        if (rsum < 0) rsum = 0;
        if (rowTempSize == colSize) {
            rowTempSize = 0;
            colTempSize++;
            rsum = 0;
        }
        if (colTempSize == rowSize) {
            for (int x: col) {
                if (x > targetSum) return false;
            }
            return true;
        }
        if (col[rowTempSize] > targetSum) return false;
        int old = col[rowTempSize];
        col[rowTempSize] = Math.max(col[rowTempSize] + a[colTempSize][rowTempSize], 0);
        if (check(colTempSize, rowTempSize + 1, op_left, rsum + a[colTempSize][rowTempSize]))
            return true;
        col[rowTempSize] = old;
        if (op_left > 0) {
            col[rowTempSize] = Math.max(col[rowTempSize] - a[colTempSize][rowTempSize], 0);
            if (check(colTempSize, rowTempSize + 1, op_left - 1, rsum - a[colTempSize][rowTempSize])) return true;
            col[rowTempSize] = old;
        }
        return false;
    }
    public int solve(int A, int[][] B, int C) {
        a = B;
        targetSum = C;
        rowSize = a.length;
        colSize = a[0].length;
        col = new int[colSize];
        return check(0, 0, A, 0) ? 1 : 0;
    }
}

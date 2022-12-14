package advance.backtrack_2.exp;

import java.util.ArrayList;

public class VerticalAndHorizontalSums {
    public static void main(String[] args) {
        int A = 2;
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

        int result = new VerticalAndHorizontalSums().solve(A, al, C);
        System.out.println("Result : " + (result == 1));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        return solve(A, B, C, 0);
    }

    private int solve(int operation, ArrayList<ArrayList<Integer>> input, int sum, int row) {
        if (row > input.size())
            return 0;

        if (isValid(input, sum) && operation >= 0) {
            return 1;
        }
        if (row >= input.size() || operation<0)
            return 0;
        // Do
        // multiply the element at row col with -1
        for (int colInd = 0; colInd < input.get(0).size(); colInd++) {
            int val = input.get(row).get(colInd) * -1;
            ArrayList<Integer> tempArr = input.get(row);
            tempArr.set(colInd, val);
            if (solve(operation - 1, input, sum, row + 1) == 1) {
                return 1;
            }
            val *= -1;
            tempArr.set(colInd, val);
        }
        return 0;
    }

    private boolean isValid(ArrayList<ArrayList<Integer>> input, int sum) {
        for (int j = 0; j < input.get(0).size(); j++) {
            int colSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < input.size(); i++) {
                colSum += input.get(i).get(j);
                if (maxSum < colSum)
                    maxSum = colSum;
                else if (colSum < 0)
                    colSum = 0;
            }
            if (maxSum>sum)
                return false;
        }
        for (int i = 0; i < input.size(); i++) {
            int rowSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int j = 0; j < input.get(0).size(); j++) {
                rowSum += input.get(i).get(j);
                if (maxSum < rowSum)
                    maxSum = rowSum;
                else if (rowSum < 0)
                    rowSum = 0;
            }
            if (maxSum>sum)
                return false;
        }
        return true;
    }
}
